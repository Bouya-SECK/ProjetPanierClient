package sn.bouya.panierclient.Repository.Implementation;

import sn.bouya.panierclient.Model.LignePanier;
import sn.bouya.panierclient.Repository.ILignePanierDAO;
import sn.bouya.panierclient.config.FactoryJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class LignePanierDAOImple extends GenericDAOImple<LignePanier> implements ILignePanierDAO {

    public LignePanierDAOImple() {
        super(LignePanier.class);
    }

    @Override
    public List<LignePanier> getLignePanierByPanier(Long idPanier) {
        EntityManager em = FactoryJPA.getManager();
        List<LignePanier> lignes = em.createQuery(
                        "SELECT l FROM LignePanier l WHERE l.panier.id = :id", LignePanier.class)
                .setParameter("id", idPanier)
                .getResultList();
        em.close();
        return lignes;
    }
}