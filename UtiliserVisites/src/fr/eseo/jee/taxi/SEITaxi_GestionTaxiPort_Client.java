
package fr.eseo.jee.taxi;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-03-13T13:34:18.533+01:00
 * Generated source version: 3.3.0
 *
 */
public final class SEITaxi_GestionTaxiPort_Client {

    private static final QName SERVICE_NAME = new QName("http://projet.jee.eseo/", "GestionTaxiService");

    private SEITaxi_GestionTaxiPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = GestionTaxiService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        GestionTaxiService ss = new GestionTaxiService(wsdlURL, SERVICE_NAME);
        SEITaxi port = ss.getGestionTaxiPort();

        {
        System.out.println("Invoking trouverTaxi...");
        fr.eseo.jee.taxi.Taxi _trouverTaxi_arg0 = new fr.eseo.jee.taxi.Taxi();
        _trouverTaxi_arg0.setCategorie("Categorie978306066");
        _trouverTaxi_arg0.setCodeTaxi(543272776);
        _trouverTaxi_arg0.setTarif(0.4831532979682541);
        _trouverTaxi_arg0.setVille("Ville-1059414223");
        java.lang.String _trouverTaxi_arg1 = "_trouverTaxi_arg12094015441";
        java.util.List<fr.eseo.jee.taxi.Taxi> _trouverTaxi__return = port.trouverTaxi(_trouverTaxi_arg0, _trouverTaxi_arg1);
        System.out.println("trouverTaxi.result=" + _trouverTaxi__return);


        }
        {
        System.out.println("Invoking payerTaxi...");
        int _payerTaxi_arg0 = 1311945376;
        java.lang.String _payerTaxi__return = port.payerTaxi(_payerTaxi_arg0);
        System.out.println("payerTaxi.result=" + _payerTaxi__return);


        }
        {
        System.out.println("Invoking connexion...");
        java.lang.String _connexion_arg0 = "_connexion_arg0-1880555221";
        java.lang.String _connexion_arg1 = "_connexion_arg11335604327";
        fr.eseo.jee.taxi.Client _connexion__return = port.connexion(_connexion_arg0, _connexion_arg1);
        System.out.println("connexion.result=" + _connexion__return);


        }
        {
        System.out.println("Invoking reserverTaxi...");
        fr.eseo.jee.taxi.ReservationTaxi _reserverTaxi_arg0 = new fr.eseo.jee.taxi.ReservationTaxi();
        _reserverTaxi_arg0.setCodeClient(-161008092);
        _reserverTaxi_arg0.setCodeReservation(-1894171675);
        _reserverTaxi_arg0.setCodeTaxi(220342798);
        _reserverTaxi_arg0.setDate("Date189075016");
        _reserverTaxi_arg0.setPaiement(true);
        _reserverTaxi_arg0.setVille("Ville97336314");
        int _reserverTaxi__return = port.reserverTaxi(_reserverTaxi_arg0);
        System.out.println("reserverTaxi.result=" + _reserverTaxi__return);


        }
        {
        System.out.println("Invoking creerCompte...");
        fr.eseo.jee.taxi.Client _creerCompte_arg0 = new fr.eseo.jee.taxi.Client();
        _creerCompte_arg0.setCodeClient(203355277);
        _creerCompte_arg0.setEmail("Email-781147006");
        _creerCompte_arg0.setNom("Nom1645539438");
        _creerCompte_arg0.setPassword("Password1446221160");
        _creerCompte_arg0.setPrenom("Prenom-1575165503");
        int _creerCompte__return = port.creerCompte(_creerCompte_arg0);
        System.out.println("creerCompte.result=" + _creerCompte__return);


        }
        {
        System.out.println("Invoking nbreReservationsClient...");
        int _nbreReservationsClient_arg0 = -1643762399;
        java.util.List<fr.eseo.jee.taxi.ReservationTaxi> _nbreReservationsClient__return = port.nbreReservationsClient(_nbreReservationsClient_arg0);
        System.out.println("nbreReservationsClient.result=" + _nbreReservationsClient__return);


        }
        {
        System.out.println("Invoking annulerTaxi...");
        int _annulerTaxi_arg0 = -825720693;
        java.lang.String _annulerTaxi__return = port.annulerTaxi(_annulerTaxi_arg0);
        System.out.println("annulerTaxi.result=" + _annulerTaxi__return);


        }

        System.exit(0);
    }

}
