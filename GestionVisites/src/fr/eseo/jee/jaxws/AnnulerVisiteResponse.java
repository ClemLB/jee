
package fr.eseo.jee.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.0
 * Mon Mar 09 10:02:33 CET 2020
 * Generated source version: 3.3.0
 */

@XmlRootElement(name = "annulerVisiteResponse", namespace = "http://jee.eseo.fr/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annulerVisiteResponse", namespace = "http://jee.eseo.fr/")

public class AnnulerVisiteResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

