package sn.bouya.panierclient.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sn.bouya.panierclient.Model.Panier;
import sn.bouya.panierclient.Repository.IPanierDAO;
import sn.bouya.panierclient.Repository.Implementation.PanierDAOImple;
import sn.bouya.panierclient.Service.PanierService;

public class PanierController {

    @FXML private TextField nomComplet;

    private final IPanierDAO ipan = new PanierDAOImple();
    private final PanierService panierService = new PanierService(ipan);

    @FXML
    protected void addPanier() {
        Panier p = new Panier();
        p.setNomComplet(nomComplet.getText());
        p.setDateCreation(new java.sql.Date(new java.util.Date().getTime()));
        panierService.ajout(p);
        nomComplet.setText(""); // vider le champ après ajout
    }
}