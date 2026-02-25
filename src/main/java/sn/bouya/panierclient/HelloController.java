package sn.bouya.panierclient;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import sn.bouya.panierclient.Utilitaire.Navigation;

public class HelloController {

    @FXML
    private StackPane stackPane;
    @FXML
    public void afficheAjoutProduit() {
        Navigation.loadView("ajoutProduit.fxml", stackPane);
    }

    @FXML
    public void afficheListeProduit() {
        Navigation.loadView("listeProduit.fxml", stackPane);
    }

    @FXML
    public void affichePanier() {
        Navigation.loadView("ajoutPanier.fxml", stackPane);
    }

    @FXML
    public void afficheListePanier() {
        Navigation.loadView("listePanier.fxml", stackPane);
    }

    @FXML
    public void afficheLigneLignePanier() {
        Navigation.loadView("ajoutLignePanier.fxml", stackPane);
    }

    @FXML
    public void afficheListeLignePanier() {
        Navigation.loadView("listeLignePanier.fxml", stackPane);
    }
}