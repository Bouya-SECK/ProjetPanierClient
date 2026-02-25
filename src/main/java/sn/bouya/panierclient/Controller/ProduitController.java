package sn.bouya.panierclient.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IProduitDAO;
import sn.bouya.panierclient.Repository.Implementation.ProduitDAOImple;
import sn.bouya.panierclient.Service.ProduitService;

public class ProduitController {

    @FXML
    private TextField libelle;

    @FXML
    private TextField prixUni;

    @FXML
    private TextField dateEx;

    @FXML
    private TextField quantite;


    private final IProduitDAO ipro = new IProduitDAOImple();
    private final ProduitService produitService = new ProduitService(ipro);

    @FXML
    protected void addProduit() {
        Produit p = new Produit();
        p.setLibelle(libelle.getText());
        p.setPrixUni(prixUni.getText());
        p.setDatePre(dateEx.getText());
        p.setQuantite(quantite.getText());
        produitService.ajout(p);
    }
}