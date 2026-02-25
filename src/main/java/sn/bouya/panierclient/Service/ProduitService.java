package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IProduitDAO;

public class ProduitService {

    private final IProduitDAO dao;

    public ProduitService(IProduitDAO dao) {
        this.dao = dao;
    }


    public void ajout(Produit pro){
        dao.save(pro);
    }
}
