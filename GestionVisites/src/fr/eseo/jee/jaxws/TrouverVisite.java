
package fr.eseo.jee.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.0
 * Fri Mar 06 16:49:57 CET 2020
 * Generated source version: 3.3.0
 */

@XmlRootElement(name = "trouverVisite", namespace = "http://jee.eseo.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trouverVisite", namespace = "http://jee.eseo.fr/")

public class TrouverVisite {

    @XmlElement(name = "arg0")
    private fr.eseo.jee.Visite arg0;

    public fr.eseo.jee.Visite getArg0() {
        return this.arg0;
    }

    public void setArg0(fr.eseo.jee.Visite newArg0)  {
        this.arg0 = newArg0;
    }

}

