
package fr.eseo.jee.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.0
 * Mon Mar 09 09:38:59 CET 2020
 * Generated source version: 3.3.0
 */

@XmlRootElement(name = "reserverVisite", namespace = "http://jee.eseo.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverVisite", namespace = "http://jee.eseo.fr/")

public class ReserverVisite {

    @XmlElement(name = "arg0")
    private fr.eseo.jee.ReservationVisite arg0;

    public fr.eseo.jee.ReservationVisite getArg0() {
        return this.arg0;
    }

    public void setArg0(fr.eseo.jee.ReservationVisite newArg0)  {
        this.arg0 = newArg0;
    }

}

