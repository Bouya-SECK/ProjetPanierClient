package sn.bouya.panierclient.Repository.Implementation;

import sn.bouya.panierclient.Repository.IGenericDAO;
import sn.bouya.panierclient.config.FactoryJPA;

import javax.persistence.EntityManager;
import java.util.List;

public class GenericDAOImple<T> implements IGenericDAO {

    private Class<T> type;

    public GenericDAOImple(Class<T> type) {
        this.type = type;
    }

    @Override
    public void save(Object entite) {
        EntityManager em = FactoryJPA.getManager();
        em.getTransaction().begin();
        em.persist(entite);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Object entite) {
        EntityManager em = FactoryJPA.getManager();
        em.getTransaction().begin();
        em.merge(entite);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Object entite) {
        EntityManager em = FactoryJPA.getManager();
        em.getTransaction().begin();
        em.remove(em.merge(entite));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<T> getAll() {
        EntityManager em = FactoryJPA.getManager();
        List<T> datas = em.createQuery("from "+type.getSimpleName(),type).getResultList();
        em.close();
        return datas;
    }
}
