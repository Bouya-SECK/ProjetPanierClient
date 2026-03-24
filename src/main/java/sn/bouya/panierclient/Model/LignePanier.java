package sn.bouya.panierclient.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class LignePanier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantite;


    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;


    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;
}