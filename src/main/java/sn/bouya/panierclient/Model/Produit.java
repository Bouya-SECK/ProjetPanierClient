package sn.bouya.panierclient.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Produit {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idPro;
        private String lebelle;
        private int quantite;
        private Float prixUni;
        private Date datePre;

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getLebelle() {
        return lebelle;
    }

    public void setLebelle(String lebelle) {
        this.lebelle = lebelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixUni() {
        return prixUni;
    }

    public void setPrixUni(float prixUni) {
        this.prixUni = prixUni;
    }

    public Date getDatePre() {
        return datePre;
    }

    public void setDatePre(Date datePre) {
        this.datePre = datePre;
    }
}
