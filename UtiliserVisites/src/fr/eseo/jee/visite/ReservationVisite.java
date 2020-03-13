
package fr.eseo.jee.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reservationVisite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="reservationVisite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codeClient" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="codeReservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codeVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nbPersonnes" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="paiementEffectue" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservationVisite", propOrder = {
    "codeClient",
    "codeReservation",
    "codeVisite",
    "nbPersonnes",
    "paiementEffectue"
})
public class ReservationVisite {

    protected int codeClient;
    protected String codeReservation;
    protected String codeVisite;
    protected int nbPersonnes;
    protected boolean paiementEffectue;

    /**
     * Obtient la valeur de la propriété codeClient.
     * 
     */
    public int getCodeClient() {
        return codeClient;
    }

    /**
     * Définit la valeur de la propriété codeClient.
     * 
     */
    public void setCodeClient(int value) {
        this.codeClient = value;
    }

    /**
     * Obtient la valeur de la propriété codeReservation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeReservation() {
        return codeReservation;
    }

    /**
     * Définit la valeur de la propriété codeReservation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeReservation(String value) {
        this.codeReservation = value;
    }

    /**
     * Obtient la valeur de la propriété codeVisite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeVisite() {
        return codeVisite;
    }

    /**
     * Définit la valeur de la propriété codeVisite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeVisite(String value) {
        this.codeVisite = value;
    }

    /**
     * Obtient la valeur de la propriété nbPersonnes.
     * 
     */
    public int getNbPersonnes() {
        return nbPersonnes;
    }

    /**
     * Définit la valeur de la propriété nbPersonnes.
     * 
     */
    public void setNbPersonnes(int value) {
        this.nbPersonnes = value;
    }

    /**
     * Obtient la valeur de la propriété paiementEffectue.
     * 
     */
    public boolean isPaiementEffectue() {
        return paiementEffectue;
    }

    /**
     * Définit la valeur de la propriété paiementEffectue.
     * 
     */
    public void setPaiementEffectue(boolean value) {
        this.paiementEffectue = value;
    }

}
