package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.Panier;
import sn.bouya.panierclient.Repository.IPanierDAO;

import java.util.List;

public class PanierService {

    private final IPanierDAO dao;

    public PanierService(IPanierDAO dao) {
        this.dao = dao;
    }

    public void ajout(Panier p) {
        dao.save(p);
    }

    public void modifier(Panier p) {
        dao.update(p);
    }

    public void supprimer(Panier p) {
        dao.delete(p);
    }

    public List<Panier> getAll() {
        return dao.getAll();
    }
}