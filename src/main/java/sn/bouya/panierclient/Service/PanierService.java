package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.Panier;
import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IPanierDAO;
import sn.bouya.panierclient.Repository.IProduitDAO;

public class PanierService {

    private final IPanierDAO dao;

    public PanierService(IPanierDAO dao) {
        this.dao = dao;
    }


    public void ajout(Panier pa){
        dao.save(pa);
    }
}
