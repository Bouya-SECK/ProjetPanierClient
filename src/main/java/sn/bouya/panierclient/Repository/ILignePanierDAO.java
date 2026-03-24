package sn.bouya.panierclient.Repository;

import sn.bouya.panierclient.Model.LignePanier;

import java.util.List;

public interface ILignePanierDAO extends IGenericDAO<LignePanier> {
    List<LignePanier> getLignePanierByPanier(Long idPanier);
}