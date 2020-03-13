package fr.eseo.jee.taxi;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-03-13T13:34:18.700+01:00
 * Generated source version: 3.3.0
 *
 */
@WebServiceClient(name = "GestionTaxiService",
                  wsdlLocation = "http://192.168.4.204:8080/GestionReservationTaxi/services/GestionTaxiPort?wsdl",
                  targetNamespace = "http://projet.jee.eseo/")
public class GestionTaxiService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://projet.jee.eseo/", "GestionTaxiService");
    public final static QName GestionTaxiPort = new QName("http://projet.jee.eseo/", "GestionTaxiPort");
    static {
        URL url = null;
        try {
            url = new URL("http://192.168.4.204:8080/GestionReservationTaxi/services/GestionTaxiPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(GestionTaxiService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://192.168.4.204:8080/GestionReservationTaxi/services/GestionTaxiPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public GestionTaxiService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GestionTaxiService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GestionTaxiService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public GestionTaxiService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public GestionTaxiService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public GestionTaxiService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SEITaxi
     */
    @WebEndpoint(name = "GestionTaxiPort")
    public SEITaxi getGestionTaxiPort() {
        return super.getPort(GestionTaxiPort, SEITaxi.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SEITaxi
     */
    @WebEndpoint(name = "GestionTaxiPort")
    public SEITaxi getGestionTaxiPort(WebServiceFeature... features) {
        return super.getPort(GestionTaxiPort, SEITaxi.class, features);
    }

}
