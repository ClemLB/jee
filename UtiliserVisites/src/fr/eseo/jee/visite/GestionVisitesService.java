package fr.eseo.jee.visite;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-03-13T14:12:36.957+01:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "GestionVisitesService",
                  wsdlLocation = "http://192.168.4.197:8080/GestionVisites/services/GestionVisitesPort?wsdl",
                  targetNamespace = "http://jee.eseo.fr/")
public class GestionVisitesService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://jee.eseo.fr/", "GestionVisitesService");
    public final static QName GestionVisitesPort = new QName("http://jee.eseo.fr/", "GestionVisitesPort");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.4.197:8080/GestionVisites/services/GestionVisitesPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(GestionVisitesService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://192.168.4.197:8080/GestionVisites/services/GestionVisitesPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public GestionVisitesService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GestionVisitesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GestionVisitesService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public GestionVisitesService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public GestionVisitesService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public GestionVisitesService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SEIGestionVisites
     */
    @WebEndpoint(name = "GestionVisitesPort")
    public SEIGestionVisites getGestionVisitesPort() {
        return super.getPort(GestionVisitesPort, SEIGestionVisites.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SEIGestionVisites
     */
    @WebEndpoint(name = "GestionVisitesPort")
    public SEIGestionVisites getGestionVisitesPort(WebServiceFeature... features) {
        return super.getPort(GestionVisitesPort, SEIGestionVisites.class, features);
    }

}
