
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Years" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Interest" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LoanAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AnnualTax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AnnualInsurance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "years",
    "interest",
    "loanAmount",
    "annualTax",
    "annualInsurance"
})
@XmlRootElement(name = "GetMortgagePayment")
public class GetMortgagePayment {

    @XmlElement(name = "Years")
    protected int years;
    @XmlElement(name = "Interest")
    protected double interest;
    @XmlElement(name = "LoanAmount")
    protected double loanAmount;
    @XmlElement(name = "AnnualTax")
    protected double annualTax;
    @XmlElement(name = "AnnualInsurance")
    protected double annualInsurance;

    /**
     * Obtient la valeur de la propriété years.
     * 
     */
    public int getYears() {
        return years;
    }

    /**
     * Définit la valeur de la propriété years.
     * 
     */
    public void setYears(int value) {
        this.years = value;
    }

    /**
     * Obtient la valeur de la propriété interest.
     * 
     */
    public double getInterest() {
        return interest;
    }

    /**
     * Définit la valeur de la propriété interest.
     * 
     */
    public void setInterest(double value) {
        this.interest = value;
    }

    /**
     * Obtient la valeur de la propriété loanAmount.
     * 
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Définit la valeur de la propriété loanAmount.
     * 
     */
    public void setLoanAmount(double value) {
        this.loanAmount = value;
    }

    /**
     * Obtient la valeur de la propriété annualTax.
     * 
     */
    public double getAnnualTax() {
        return annualTax;
    }

    /**
     * Définit la valeur de la propriété annualTax.
     * 
     */
    public void setAnnualTax(double value) {
        this.annualTax = value;
    }

    /**
     * Obtient la valeur de la propriété annualInsurance.
     * 
     */
    public double getAnnualInsurance() {
        return annualInsurance;
    }

    /**
     * Définit la valeur de la propriété annualInsurance.
     * 
     */
    public void setAnnualInsurance(double value) {
        this.annualInsurance = value;
    }

}
