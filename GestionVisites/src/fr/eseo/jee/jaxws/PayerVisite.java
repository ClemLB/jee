
package fr.eseo.jee.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.0
 * Fri Mar 06 15:24:58 CET 2020
 * Generated source version: 3.3.0
 */

@XmlRootElement(name = "payerVisite", namespace = "http://jee.eseo.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payerVisite", namespace = "http://jee.eseo.fr/")

public class PayerVisite {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}
