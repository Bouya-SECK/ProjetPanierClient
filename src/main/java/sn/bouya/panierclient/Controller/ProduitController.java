package sn.bouya.panierclient.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IProduitDAO;
import sn.bouya.panierclient.Repository.Implementation.ProduitDAOImple;
import sn.bouya.panierclient.Service.ProduitService;

public class ProduitController {


    @FXML private TextField libelle;
    @FXML private TextField prixUni;
    @FXML private TextField dateEx;
    @FXML private TextField quantite;


    @FXML private TableView<Produit> tableProduit;
    @FXML private TableColumn<Produit, String> colLibelle;
    @FXML private TableColumn<Produit, Integer> colQuantite;
    @FXML private TableColumn<Produit, Float> colPrixUni;
    @FXML private TableColumn<Produit, String> colDateEx;

    private final IProduitDAO ipro = new ProduitDAOImple();
    private final ProduitService produitService = new ProduitService(ipro);


    private Produit produitSelectionne = null;

    @FXML
    public void initialize() {
        if (tableProduit != null) {
            colLibelle.setCellValueFactory(new PropertyValueFactory<>("lebelle"));
            colQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
            colPrixUni.setCellValueFactory(new PropertyValueFactory<>("prixUni"));
            colDateEx.setCellValueFactory(new PropertyValueFactory<>("datePre"));
            chargerListe();


            tableProduit.getSelectionModel().selectedItemProperty().addListener(
                    (obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            produitSelectionne = newVal;
                            libelle.setText(newVal.getLebelle());
                            prixUni.setText(String.valueOf(newVal.getPrixUni()));
                            quantite.setText(String.valueOf(newVal.getQuantite()));
                        }
                    }
            );
        }
    }


    private void chargerListe() {
        tableProduit.getItems().setAll(produitService.getAll());
    }

    // ---- Ajouter ----
    @FXML
    protected void addProduit() {
        Produit p = new Produit();
        p.setLebelle(libelle.getText());
        p.setPrixUni(Float.parseFloat(prixUni.getText()));
        p.setQuantite(Integer.parseInt(quantite.getText()));
        p.setDatePre(new java.sql.Date(new java.util.Date().getTime()));
        produitService.ajout(p);
        viderFormulaire();
        chargerListe();
    }


    @FXML
    protected void modifierProduit() {
        if (produitSelectionne == null) return; // rien de sélectionné
        produitSelectionne.setLebelle(libelle.getText());
        produitSelectionne.setPrixUni(Float.parseFloat(prixUni.getText()));
        produitSelectionne.setQuantite(Integer.parseInt(quantite.getText()));
        produitService.modifier(produitSelectionne);
        viderFormulaire();
        chargerListe();
        produitSelectionne = null;
    }

    // ---- Supprimer ----
    @FXML
    protected void supprimerProduit() {
        Produit selection = tableProduit.getSelectionModel().getSelectedItem();
        if (selection == null) return; // rien de sélectionné
        produitService.supprimer(selection);
        chargerListe();
        viderFormulaire();
    }


    private void viderFormulaire() {
        libelle.setText("");
        prixUni.setText("");
        quantite.setText("");
        dateEx.setText("");
        produitSelectionne = null;
    }
}