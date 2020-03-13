
package fr.eseo.jee.visite;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour visite complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="visite"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codeVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dateVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="typeVisite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visite", propOrder = {
    "codeVisite",
    "dateVisite",
    "prix",
    "typeVisite",
    "ville"
})
public class Visite {

    protected String codeVisite;
    protected String dateVisite;
    protected double prix;
    protected String typeVisite;
    protected String ville;

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
     * Obtient la valeur de la propriété dateVisite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateVisite() {
        return dateVisite;
    }

    /**
     * Définit la valeur de la propriété dateVisite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateVisite(String value) {
        this.dateVisite = value;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     */
    public void setPrix(double value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété typeVisite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeVisite() {
        return typeVisite;
    }

    /**
     * Définit la valeur de la propriété typeVisite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeVisite(String value) {
        this.typeVisite = value;
    }

    /**
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
    }

}
