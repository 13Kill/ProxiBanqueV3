package fr.gtm.proxibanquesi.front.beans;



import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.service.ClientService;

@ManagedBean(name="BeanComptes")
@SessionScoped
public class CompteBean {    
	public List<Compte> getListComptes() {
		int idClient = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("client"));
		System.out.println("ID Client : "+idClient);
		Client client = new Client();
		client.setId(idClient);

		ClientService clientService = new ClientService();

		List<Compte> comptes = new ArrayList<Compte>();
		List<CompteCourant> compteCourants;
		List<CompteEpargne> compteEpargnes;
		try {
			clientService.getListeComptesCourant(client);
            clientService.getListeComptesEpargne(client);
            
			compteCourants = clientService.getComptesCourant(client);
			compteEpargnes = clientService.getComptesEpargne(client);
		} catch (LigneInexistanteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		if (compteCourants != null) {
			comptes.addAll(compteCourants);
			System.out.println("Courant : "+compteCourants.size());
		}
		if (compteEpargnes != null) {
			comptes.addAll(compteEpargnes);
			System.out.println("Epargne : "+compteEpargnes.size());
		}
		else {
		 System.out.println(0);
		}

		return comptes;
	}
}