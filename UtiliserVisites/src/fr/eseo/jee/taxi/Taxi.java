
package fr.eseo.jee.taxi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour taxi complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="taxi"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categorie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="codeTaxi" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tarif" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
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
@XmlType(name = "taxi", propOrder = {
    "categorie",
    "codeTaxi",
    "tarif",
    "ville"
})
public class Taxi {

    protected String categorie;
    protected int codeTaxi;
    protected double tarif;
    protected String ville;

    /**
     * Obtient la valeur de la propriété categorie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * Définit la valeur de la propriété categorie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategorie(String value) {
        this.categorie = value;
    }

    /**
     * Obtient la valeur de la propriété codeTaxi.
     * 
     */
    public int getCodeTaxi() {
        return codeTaxi;
    }

    /**
     * Définit la valeur de la propriété codeTaxi.
     * 
     */
    public void setCodeTaxi(int value) {
        this.codeTaxi = value;
    }

    /**
     * Obtient la valeur de la propriété tarif.
     * 
     */
    public double getTarif() {
        return tarif;
    }

    /**
     * Définit la valeur de la propriété tarif.
     * 
     */
    public void setTarif(double value) {
        this.tarif = value;
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
