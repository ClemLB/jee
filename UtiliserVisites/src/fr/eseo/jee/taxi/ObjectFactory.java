
package fr.eseo.jee.taxi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.eseo.jee.taxi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AnnulerTaxi_QNAME = new QName("http://projet.jee.eseo/", "annulerTaxi");
    private final static QName _AnnulerTaxiResponse_QNAME = new QName("http://projet.jee.eseo/", "annulerTaxiResponse");
    private final static QName _Connexion_QNAME = new QName("http://projet.jee.eseo/", "connexion");
    private final static QName _ConnexionResponse_QNAME = new QName("http://projet.jee.eseo/", "connexionResponse");
    private final static QName _CreerCompte_QNAME = new QName("http://projet.jee.eseo/", "creerCompte");
    private final static QName _CreerCompteResponse_QNAME = new QName("http://projet.jee.eseo/", "creerCompteResponse");
    private final static QName _NbreReservationsClient_QNAME = new QName("http://projet.jee.eseo/", "nbreReservationsClient");
    private final static QName _NbreReservationsClientResponse_QNAME = new QName("http://projet.jee.eseo/", "nbreReservationsClientResponse");
    private final static QName _PayerTaxi_QNAME = new QName("http://projet.jee.eseo/", "payerTaxi");
    private final static QName _PayerTaxiResponse_QNAME = new QName("http://projet.jee.eseo/", "payerTaxiResponse");
    private final static QName _ReserverTaxi_QNAME = new QName("http://projet.jee.eseo/", "reserverTaxi");
    private final static QName _ReserverTaxiResponse_QNAME = new QName("http://projet.jee.eseo/", "reserverTaxiResponse");
    private final static QName _TrouverTaxi_QNAME = new QName("http://projet.jee.eseo/", "trouverTaxi");
    private final static QName _TrouverTaxiResponse_QNAME = new QName("http://projet.jee.eseo/", "trouverTaxiResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.eseo.jee.taxi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnnulerTaxi }
     * 
     */
    public AnnulerTaxi createAnnulerTaxi() {
        return new AnnulerTaxi();
    }

    /**
     * Create an instance of {@link AnnulerTaxiResponse }
     * 
     */
    public AnnulerTaxiResponse createAnnulerTaxiResponse() {
        return new AnnulerTaxiResponse();
    }

    /**
     * Create an instance of {@link Connexion }
     * 
     */
    public Connexion createConnexion() {
        return new Connexion();
    }

    /**
     * Create an instance of {@link ConnexionResponse }
     * 
     */
    public ConnexionResponse createConnexionResponse() {
        return new ConnexionResponse();
    }

    /**
     * Create an instance of {@link CreerCompte }
     * 
     */
    public CreerCompte createCreerCompte() {
        return new CreerCompte();
    }

    /**
     * Create an instance of {@link CreerCompteResponse }
     * 
     */
    public CreerCompteResponse createCreerCompteResponse() {
        return new CreerCompteResponse();
    }

    /**
     * Create an instance of {@link NbreReservationsClient }
     * 
     */
    public NbreReservationsClient createNbreReservationsClient() {
        return new NbreReservationsClient();
    }

    /**
     * Create an instance of {@link NbreReservationsClientResponse }
     * 
     */
    public NbreReservationsClientResponse createNbreReservationsClientResponse() {
        return new NbreReservationsClientResponse();
    }

    /**
     * Create an instance of {@link PayerTaxi }
     * 
     */
    public PayerTaxi createPayerTaxi() {
        return new PayerTaxi();
    }

    /**
     * Create an instance of {@link PayerTaxiResponse }
     * 
     */
    public PayerTaxiResponse createPayerTaxiResponse() {
        return new PayerTaxiResponse();
    }

    /**
     * Create an instance of {@link ReserverTaxi }
     * 
     */
    public ReserverTaxi createReserverTaxi() {
        return new ReserverTaxi();
    }

    /**
     * Create an instance of {@link ReserverTaxiResponse }
     * 
     */
    public ReserverTaxiResponse createReserverTaxiResponse() {
        return new ReserverTaxiResponse();
    }

    /**
     * Create an instance of {@link TrouverTaxi }
     * 
     */
    public TrouverTaxi createTrouverTaxi() {
        return new TrouverTaxi();
    }

    /**
     * Create an instance of {@link TrouverTaxiResponse }
     * 
     */
    public TrouverTaxiResponse createTrouverTaxiResponse() {
        return new TrouverTaxiResponse();
    }

    /**
     * Create an instance of {@link Taxi }
     * 
     */
    public Taxi createTaxi() {
        return new Taxi();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link ReservationTaxi }
     * 
     */
    public ReservationTaxi createReservationTaxi() {
        return new ReservationTaxi();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerTaxi }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnnulerTaxi }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "annulerTaxi")
    public JAXBElement<AnnulerTaxi> createAnnulerTaxi(AnnulerTaxi value) {
        return new JAXBElement<AnnulerTaxi>(_AnnulerTaxi_QNAME, AnnulerTaxi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnulerTaxiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnnulerTaxiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "annulerTaxiResponse")
    public JAXBElement<AnnulerTaxiResponse> createAnnulerTaxiResponse(AnnulerTaxiResponse value) {
        return new JAXBElement<AnnulerTaxiResponse>(_AnnulerTaxiResponse_QNAME, AnnulerTaxiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connexion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Connexion }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "connexion")
    public JAXBElement<Connexion> createConnexion(Connexion value) {
        return new JAXBElement<Connexion>(_Connexion_QNAME, Connexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnexionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConnexionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "connexionResponse")
    public JAXBElement<ConnexionResponse> createConnexionResponse(ConnexionResponse value) {
        return new JAXBElement<ConnexionResponse>(_ConnexionResponse_QNAME, ConnexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreerCompte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreerCompte }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "creerCompte")
    public JAXBElement<CreerCompte> createCreerCompte(CreerCompte value) {
        return new JAXBElement<CreerCompte>(_CreerCompte_QNAME, CreerCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreerCompteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreerCompteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "creerCompteResponse")
    public JAXBElement<CreerCompteResponse> createCreerCompteResponse(CreerCompteResponse value) {
        return new JAXBElement<CreerCompteResponse>(_CreerCompteResponse_QNAME, CreerCompteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NbreReservationsClient }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NbreReservationsClient }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "nbreReservationsClient")
    public JAXBElement<NbreReservationsClient> createNbreReservationsClient(NbreReservationsClient value) {
        return new JAXBElement<NbreReservationsClient>(_NbreReservationsClient_QNAME, NbreReservationsClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NbreReservationsClientResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NbreReservationsClientResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "nbreReservationsClientResponse")
    public JAXBElement<NbreReservationsClientResponse> createNbreReservationsClientResponse(NbreReservationsClientResponse value) {
        return new JAXBElement<NbreReservationsClientResponse>(_NbreReservationsClientResponse_QNAME, NbreReservationsClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerTaxi }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayerTaxi }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "payerTaxi")
    public JAXBElement<PayerTaxi> createPayerTaxi(PayerTaxi value) {
        return new JAXBElement<PayerTaxi>(_PayerTaxi_QNAME, PayerTaxi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayerTaxiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PayerTaxiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "payerTaxiResponse")
    public JAXBElement<PayerTaxiResponse> createPayerTaxiResponse(PayerTaxiResponse value) {
        return new JAXBElement<PayerTaxiResponse>(_PayerTaxiResponse_QNAME, PayerTaxiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverTaxi }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserverTaxi }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "reserverTaxi")
    public JAXBElement<ReserverTaxi> createReserverTaxi(ReserverTaxi value) {
        return new JAXBElement<ReserverTaxi>(_ReserverTaxi_QNAME, ReserverTaxi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverTaxiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserverTaxiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "reserverTaxiResponse")
    public JAXBElement<ReserverTaxiResponse> createReserverTaxiResponse(ReserverTaxiResponse value) {
        return new JAXBElement<ReserverTaxiResponse>(_ReserverTaxiResponse_QNAME, ReserverTaxiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrouverTaxi }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrouverTaxi }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "trouverTaxi")
    public JAXBElement<TrouverTaxi> createTrouverTaxi(TrouverTaxi value) {
        return new JAXBElement<TrouverTaxi>(_TrouverTaxi_QNAME, TrouverTaxi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrouverTaxiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrouverTaxiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://projet.jee.eseo/", name = "trouverTaxiResponse")
    public JAXBElement<TrouverTaxiResponse> createTrouverTaxiResponse(TrouverTaxiResponse value) {
        return new JAXBElement<TrouverTaxiResponse>(_TrouverTaxiResponse_QNAME, TrouverTaxiResponse.class, null, value);
    }

}
