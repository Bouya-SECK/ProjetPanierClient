package sn.bouya.panierclient.Repository;

import sn.bouya.panierclient.Model.Produit;

import java.util.List;

public interface IProduitDAO extends IGenericDAO<Produit> {

    List<Produit> getProduitByCategorie(Long id);
}
