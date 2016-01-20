package fr.gtm.proxibanquesi.front.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;

@ManagedBean(name="BeanCli")
@SessionScoped
public class ClientBean {
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private int id;
	private int cons;
	@ManagedProperty(value="#{BeanCns}")
	private ConseillerBean consbean;
	private List<CompteCourant> listcc;
	private List<CompteEpargne> listce;
	private CompteCourant cptcr;
	private CompteEpargne cptep;


	//constructeur
	public ClientBean() {
		super();
	}

	//getter et setter
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCons() {
		return cons;
	}
	public void setCons(int cons) {
		this.cons = cons;
	}
	public ConseillerBean getConsbean() {
		return consbean;
	}
	public void setConsbean(ConseillerBean consbean) {
		this.consbean = consbean;
	}

	public List<CompteCourant> getListcc() {
		return listcc;
	}

	public void setListcc(List<CompteCourant> listcc) {
		this.listcc = listcc;
	}

	public List<CompteEpargne> getListce() {
		return listce;
	}

	public void setListce(List<CompteEpargne> listce) {
		this.listce = listce;
	}

	public CompteCourant getCptcr() {
		return cptcr;
	}

	public void setCptcr(CompteCourant cptcr) {
		this.cptcr = cptcr;
	}

	public CompteEpargne getCptep() {
		return cptep;
	}

	public void setCptep(CompteEpargne cptep) {
		this.cptep = cptep;
	}

	//méthode de création d'un client
	public String creationClient(){
		Client cli =new Client(nom, prenom, adresse, codePostal, ville, telephone, consbean.getConseiller().getIdcons());
		System.out.println(cli.toString());
		ClientService service = new ClientService();
		try {
			service.createClient(cli);
			consbean.getListClient().add(cli);
		} catch (LigneExistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LigneInexistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
}
