/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ.pret;

/**
 *
 * @author yirou
 */
public class Pret {
    private final double montant;
    private final double taux;
    private String frequence;

    public Pret(double montant, double taux, String frequence) {
        this.montant = montant;
        this.taux = taux;
        this.frequence = frequence;
    }

    public String getFrequence() {
        return frequence;
    }

    public double getMontant() {
        return montant;
    }

    public double getTaux() {
        return taux;
    }
    
    
}
