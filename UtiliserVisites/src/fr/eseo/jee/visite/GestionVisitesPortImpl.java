
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package fr.eseo.jee.visite;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-03-13T14:12:36.914+01:00
 * Generated source version: 3.3.0
 *
 */

@javax.jws.WebService(
                      serviceName = "GestionVisitesService",
                      portName = "GestionVisitesPort",
                      targetNamespace = "http://jee.eseo.fr/",
                      wsdlLocation = "http://192.168.4.197:8080/GestionVisites/services/GestionVisitesPort?wsdl",
                      endpointInterface = "fr.eseo.jee.visite.SEIGestionVisites")

public class GestionVisitesPortImpl implements SEIGestionVisites {

    private static final Logger LOG = Logger.getLogger(GestionVisitesPortImpl.class.getName());

    /* (non-Javadoc)
     * @see fr.eseo.jee.visite.SEIGestionVisites#annulerVisite(java.lang.String arg0, int arg1)*
     */
    public boolean annulerVisite(java.lang.String arg0, int arg1) {
        LOG.info("Executing operation annulerVisite");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            boolean _return = false;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see fr.eseo.jee.visite.SEIGestionVisites#reserverVisite(fr.eseo.jee.visite.ReservationVisite arg0)*
     */
    public java.lang.String reserverVisite(fr.eseo.jee.visite.ReservationVisite arg0) {
        LOG.info("Executing operation reserverVisite");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return55318703";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see fr.eseo.jee.visite.SEIGestionVisites#payerVisite(java.lang.String arg0)*
     */
    public java.lang.String payerVisite(java.lang.String arg0) {
        LOG.info("Executing operation payerVisite");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-2103792437";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see fr.eseo.jee.visite.SEIGestionVisites#trouverVisite(fr.eseo.jee.visite.Visite arg0)*
     */
    public java.util.List<fr.eseo.jee.visite.Visite> trouverVisite(fr.eseo.jee.visite.Visite arg0) {
        LOG.info("Executing operation trouverVisite");
        System.out.println(arg0);
        try {
            java.util.List<fr.eseo.jee.visite.Visite> _return = new java.util.ArrayList<fr.eseo.jee.visite.Visite>();
            fr.eseo.jee.visite.Visite _returnVal1 = new fr.eseo.jee.visite.Visite();
            _returnVal1.setCodeVisite("CodeVisite-1099281957");
            _returnVal1.setDateVisite("DateVisite961786334");
            _returnVal1.setPrix(0.6706891302549093);
            _returnVal1.setTypeVisite("TypeVisite-91095930");
            _returnVal1.setVille("Ville-605418455");
            _return.add(_returnVal1);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
