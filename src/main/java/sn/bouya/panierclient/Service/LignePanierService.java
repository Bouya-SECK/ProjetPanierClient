package sn.bouya.panierclient.Service;

import sn.bouya.panierclient.Model.LignePanier;
import sn.bouya.panierclient.Repository.ILignePanierDAO;

import java.util.List;

public class LignePanierService {

    private final ILignePanierDAO dao;

    public LignePanierService(ILignePanierDAO dao) {
        this.dao = dao;
    }

    public void ajout(LignePanier lp) {
        dao.save(lp);
    }

    public void modifier(LignePanier lp) {
        dao.update(lp);
    }

    public void supprimer(LignePanier lp) {
        dao.delete(lp);
    }

    public List<LignePanier> getAll() {
        return dao.getAll();
    }

    public List<LignePanier> getByPanier(Long idPanier) {
        return dao.getLignePanierByPanier(idPanier);
    }
}