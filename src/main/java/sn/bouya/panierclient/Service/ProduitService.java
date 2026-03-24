package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IProduitDAO;

import java.util.List;

public class ProduitService {

    private final IProduitDAO dao;

    public ProduitService(IProduitDAO dao) {
        this.dao = dao;
    }


    public void ajout(Produit pro){
        dao.save(pro);
    }

    public List<Produit> getAll() {
        return dao.getAll();
    }

    public void modifier(Produit p) {
        dao.update(p);
    }

    public void supprimer(Produit p) {
        dao.delete(p);
    }
}
