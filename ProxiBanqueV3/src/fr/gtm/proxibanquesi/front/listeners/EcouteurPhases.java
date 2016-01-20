package fr.gtm.proxibanquesi.front.listeners;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;


public class EcouteurPhases implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("Phase après : " + event.getPhaseId().toString());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("AVANT après : " + event.getPhaseId().toString());		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}


}
