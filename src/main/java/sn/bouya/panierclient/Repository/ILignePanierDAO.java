package sn.bouya.panierclient.Repository;

import sn.bouya.panierclient.Model.LignePanier;

public interface ILignePanierDAO extends IGenericDAO<LignePanier> {
    LignePanier findByLibelle(String lib);
}