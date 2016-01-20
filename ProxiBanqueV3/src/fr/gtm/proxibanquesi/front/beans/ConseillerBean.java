package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;
import fr.gtm.proxibanquesi.service.ConseillerService;

@ManagedBean(name="BeanCns")
@SessionScoped
public class ConseillerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6327912927477151069L;

	private String login;
	private String mdp;
	private String prenom;
	private String nom;
	private int idcons;
	private int idagence;
	private boolean gerant = false;
	private Conseiller conseiller = null;
	private List<Client> listClient;
	private Client selectClient;


	//construteur
	public ConseillerBean() {
		super();
	}
	//getteur et setteur
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdcons() {
		return idcons;
	}
	public void setIdcons(int idcons) {
		this.idcons = idcons;
	}
	public int getIdagence() {
		return idagence;
	}
	public void setIdagence(int idagence) {
		this.idagence = idagence;
	}
	public boolean isGerant() {
		return gerant;
	}
	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return mdp;
	}
	public void setPassword(String mdp) {
		this.mdp = mdp;
	}
	public List<Client> getListClient() {
		return listClient;
	}
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	public Client getSelectClient() {
		return selectClient;
	}
	public void setSelectClient(Client selectClient) {
		this.selectClient = selectClient;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//méthode de logout
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "validationConseiller?faces-redirect=true";
    }
	
	//méthode d'identification
	public String validationLogin(){
		Conseiller cons =new Conseiller();
		cons.setLogin(login);
		cons.setMdp(mdp);
		System.out.println(cons.toString());
		ConseillerService service = new ConseillerService();
		try {
			conseiller = service.checkUser(cons);
			service.getListeClients(conseiller);
			listClient = service.getClients(conseiller);
		} catch (LigneInexistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}

	public String creationConseiller(){		
		// etape 2 : envoyer ces données dans la base de données
		Conseiller cons =new Conseiller(nom, prenom, login, mdp);
		System.out.println(cons.toString());
		ConseillerService service = new ConseillerService();
		try {
			service.createConseiller(cons);
		} catch (LigneExistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LigneInexistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// etape 3 : vérifier qu'il neccite pas encore dans le base de données
		return "validationConseiller";
	}
	
	public String refreshClients() {
        ConseillerService service = new ConseillerService();
        
        try {
            conseiller = service.checkUser(conseiller);
            service.getListeClients(conseiller);
            listClient = service.getClients(conseiller);
        } catch (LigneInexistanteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return "home";
    }
	
	public void rowSelect(SelectEvent event){
		selectClient =  (Client)event.getObject();
		System.out.println("selectClient = "+selectClient.getCptcrt().getNumCompte());
	}

	public void onUserSelect(SelectEvent event){ 
		this.selectClient =  (Client)event.getObject();
		System.out.println("selectClient = "+selectClient.getId());
	}

	public void onUserUnselect(UnselectEvent event)
	{
		selectClient =  null;
	}

	public void onRowEdit(RowEditEvent event) {
		Client tempcli = new Client();
		ClientService servcli = new ClientService();
		tempcli = (Client) event.getObject();
		FacesMessage msg = new FacesMessage("Client modifié", "Client n° : "+tempcli.getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		try {
			servcli.modifierClient(tempcli);
		} catch (LigneInexistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Modification annulé", "Client n° : "+((Client) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
