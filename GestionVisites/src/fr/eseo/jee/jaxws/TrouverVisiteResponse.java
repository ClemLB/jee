
package fr.eseo.jee.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.0
 * Mon Mar 09 11:17:14 CET 2020
 * Generated source version: 3.3.0
 */

@XmlRootElement(name = "trouverVisiteResponse", namespace = "http://jee.eseo.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trouverVisiteResponse", namespace = "http://jee.eseo.fr/")

public class TrouverVisiteResponse {

    @XmlElement(name = "return")
    private java.util.List<fr.eseo.jee.Visite> _return;

    public java.util.List<fr.eseo.jee.Visite> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.List<fr.eseo.jee.Visite> new_return)  {
        this._return = new_return;
    }

}

