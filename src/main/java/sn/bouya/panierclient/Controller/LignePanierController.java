package sn.bouya.panierclient.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sn.bouya.panierclient.Model.LignePanier;
import sn.bouya.panierclient.Model.Panier;
import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.Implementation.LignePanierDAOImple;
import sn.bouya.panierclient.Repository.Implementation.PanierDAOImple;
import sn.bouya.panierclient.Repository.Implementation.ProduitDAOImple;
import sn.bouya.panierclient.Repository.ILignePanierDAO;
import sn.bouya.panierclient.Repository.IPanierDAO;
import sn.bouya.panierclient.Repository.IProduitDAO;
import sn.bouya.panierclient.Service.LignePanierService;
import sn.bouya.panierclient.Service.PanierService;
import sn.bouya.panierclient.Service.ProduitService;

public class LignePanierController {


    @FXML private TextField quantite;
    @FXML private ComboBox<Produit> comboProduit;
    @FXML private ComboBox<Panier> comboPanier;


    @FXML private TableView<LignePanier> tableLignePanier;
    @FXML private TableColumn<LignePanier, Integer> colId;
    @FXML private TableColumn<LignePanier, Integer> colQuantite;
    @FXML private TableColumn<LignePanier, String> colProduit;
    @FXML private TableColumn<LignePanier, String> colPanier;


    private final ILignePanierDAO ilp = new LignePanierDAOImple();
    private final IProduitDAO ipro = new ProduitDAOImple();
    private final IPanierDAO ipan = new PanierDAOImple();

    private final LignePanierService lignePanierService = new LignePanierService(ilp);
    private final ProduitService produitService = new ProduitService(ipro);
    private final PanierService panierService = new PanierService(ipan);

    private LignePanier ligneSelectionne = null;

    @FXML
    public void initialize() {


        if (comboProduit != null) {
            comboProduit.getItems().setAll(produitService.getAll());
        }
        if (comboPanier != null) {
            comboPanier.getItems().setAll(panierService.getAll());
        }


        if (tableLignePanier != null) {
            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            colProduit.setCellValueFactory(new PropertyValueFactory<>("produit"));
            colPanier.setCellValueFactory(new PropertyValueFactory<>("panier"));
            chargerListe();


            tableLignePanier.getSelectionModel().selectedItemProperty().addListener(
                    (obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            ligneSelectionne = newVal;
                            quantite.setText(String.valueOf(newVal.getQuantite()));
                            comboProduit.setValue(newVal.getProduit());
                            comboPanier.setValue(newVal.getPanier());
                        }
                    }
            );
        }
    }

    private void chargerListe() {
        tableLignePanier.getItems().setAll(lignePanierService.getAll());
    }


    @FXML
    protected void addLignePanier() {
        LignePanier lp = new LignePanier();
        lp.setQuantite(Integer.parseInt(quantite.getText()));
        lp.setProduit(comboProduit.getValue());
        lp.setPanier(comboPanier.getValue());
        lignePanierService.ajout(lp);
        viderFormulaire();
        chargerListe();
    }


    @FXML
    protected void modifierLignePanier() {
        if (ligneSelectionne == null) return;
        ligneSelectionne.setQuantite(Integer.parseInt(quantite.getText()));
        ligneSelectionne.setProduit(comboProduit.getValue());
        ligneSelectionne.setPanier(comboPanier.getValue());
        lignePanierService.modifier(ligneSelectionne);
        viderFormulaire();
        chargerListe();
        ligneSelectionne = null;
    }

    @FXML
    protected void supprimerLignePanier() {
        LignePanier selection = tableLignePanier.getSelectionModel().getSelectedItem();
        if (selection == null) return;
        lignePanierService.supprimer(selection);
        chargerListe();
        viderFormulaire();
    }

    private void viderFormulaire() {
        quantite.setText("");
        comboProduit.setValue(null);
        comboPanier.setValue(null);
        ligneSelectionne = null;
    }
}