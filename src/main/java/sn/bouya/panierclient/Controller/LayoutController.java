package sn.bouya.panierclient.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import sn.bouya.panierclient.Utilitaire.Navigation;

public class LayoutController {

    @FXML
    private StackPane stackPane;

    @FXML
    public void afficheAjoutProduit() {
        Navigation.loadView("ajout_produit.fxml", stackPane);
    }

    @FXML
    public void afficheListeProduit() {
        Navigation.loadView("liste_produit.fxml", stackPane);
    }

    @FXML
    public void affichePanier() {
        Navigation.loadView("ajout_panier.fxml", stackPane);
    }

    @FXML
    public void afficheListePanier() {
        Navigation.loadView("liste_panier.fxml", stackPane);
    }

    @FXML
    public void afficheLigneLignePanier() {
        Navigation.loadView("ajout_ligne_panier.fxml", stackPane);
    }

    @FXML
    public void afficheListeLignePanier() {
        Navigation.loadView("liste_ligne_panier.fxml", stackPane);
    }
}