package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.LignePanier;
import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.ILignePanierDAO;
import sn.bouya.panierclient.Repository.IProduitDAO;

public class LignePanierService {

    private final ILignePanierDAO dao;

    public LignePanierService(ILignePanierDAO dao) {
        this.dao = dao;
    }


    public void ajout(LignePanier pl){
        dao.save(pl);
    }
}
