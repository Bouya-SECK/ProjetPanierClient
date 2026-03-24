package sn.bouya.panierclient.Repository.Implementation;

import sn.bouya.panierclient.Model.Produit;
import sn.bouya.panierclient.Repository.IProduitDAO;
import sn.bouya.panierclient.Repository.Implementation.GenericDAOImple;
import sn.bouya.panierclient.config.FactoryJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class ProduitDAOImple extends GenericDAOImple<Produit> implements IProduitDAO {

    public ProduitDAOImple() {
        super(Produit.class);
    }

    @Override
    public List<Produit> getProduitByCategorie(Long id) {
        EntityManager em = FactoryJPA.getManager();
        List<Produit> produits = em.createQuery(
                        "SELECT p FROM Produit p WHERE p.categorie.id = :id", Produit.class)
                .setParameter("id", id)
                .getResultList();
        em.close();
        return produits;
    }
}