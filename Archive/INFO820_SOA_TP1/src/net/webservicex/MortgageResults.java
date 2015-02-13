
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour MortgageResults complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="MortgageResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MonthlyPrincipalAndInterest" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MonthlyTax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MonthlyInsurance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TotalPayment" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MortgageResults", propOrder = {
    "monthlyPrincipalAndInterest",
    "monthlyTax",
    "monthlyInsurance",
    "totalPayment"
})
public class MortgageResults {

    @XmlElement(name = "MonthlyPrincipalAndInterest")
    protected double monthlyPrincipalAndInterest;
    @XmlElement(name = "MonthlyTax")
    protected double monthlyTax;
    @XmlElement(name = "MonthlyInsurance")
    protected double monthlyInsurance;
    @XmlElement(name = "TotalPayment")
    protected double totalPayment;

    /**
     * Obtient la valeur de la propriété monthlyPrincipalAndInterest.
     * 
     */
    public double getMonthlyPrincipalAndInterest() {
        return monthlyPrincipalAndInterest;
    }

    /**
     * Définit la valeur de la propriété monthlyPrincipalAndInterest.
     * 
     */
    public void setMonthlyPrincipalAndInterest(double value) {
        this.monthlyPrincipalAndInterest = value;
    }

    /**
     * Obtient la valeur de la propriété monthlyTax.
     * 
     */
    public double getMonthlyTax() {
        return monthlyTax;
    }

    /**
     * Définit la valeur de la propriété monthlyTax.
     * 
     */
    public void setMonthlyTax(double value) {
        this.monthlyTax = value;
    }

    /**
     * Obtient la valeur de la propriété monthlyInsurance.
     * 
     */
    public double getMonthlyInsurance() {
        return monthlyInsurance;
    }

    /**
     * Définit la valeur de la propriété monthlyInsurance.
     * 
     */
    public void setMonthlyInsurance(double value) {
        this.monthlyInsurance = value;
    }

    /**
     * Obtient la valeur de la propriété totalPayment.
     * 
     */
    public double getTotalPayment() {
        return totalPayment;
    }

    /**
     * Définit la valeur de la propriété totalPayment.
     * 
     */
    public void setTotalPayment(double value) {
        this.totalPayment = value;
    }

}
