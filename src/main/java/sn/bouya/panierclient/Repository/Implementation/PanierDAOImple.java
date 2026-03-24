package sn.bouya.panierclient.Repository.Implementation;

import sn.bouya.panierclient.Model.Panier;
import sn.bouya.panierclient.Repository.IPanierDAO;

public class PanierDAOImple extends GenericDAOImple<Panier> implements IPanierDAO {

    public PanierDAOImple() {
        super(Panier.class);
    }
}