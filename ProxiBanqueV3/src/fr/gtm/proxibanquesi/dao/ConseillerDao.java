package fr.gtm.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/** Cette classe implémentent les méthodes de CRUD pour la table 
 * CONSEILLER de la base de données.
 * 
 * @author Alexandre De Bruyn
 *
 */
public class ConseillerDao implements IConseillerDao {

	@Override
	public int create(Conseiller cons) throws LigneExistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();

			String check = "select count(*) from Conseiller where nom = ?"
					+ " and prenom = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setString(1, cons.getNom().toUpperCase());
			checkstat.setString(2, cons.getPrenom().toUpperCase());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) != 0) {
				BddConnector.unconnect(cnx);
				throw new LigneExistanteException("Ce conseiller existe déja.");
			}
			// Statement preparation
			String sql = "insert into conseiller(idcons, nom, prenom, idagence, login, mdp)"
					+ " values "
					+ "( seq_idcons.nextval, ? , ? , ?, ?, ?)";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setString(1, cons.getNom().toUpperCase());
			stat.setString(2, cons.getPrenom().toUpperCase());
			stat.setInt(3, cons.getIdagence());
			stat.setString(4, cons.getLogin().toUpperCase());
			stat.setString(5, cons.getMdp());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		
		return res;
	}

	@Override
	public Conseiller read(Conseiller cons) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where idcons = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cons.getIdcons());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "select * from conseiller where idcons=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setInt(1, cons.getIdcons());
			// Statement execution
			ResultSet res = stat.executeQuery();
			res.next();
			cons.setNom(res.getString(2));
			cons.setPrenom(res.getString(3));
			cons.setIdagence(res.getInt(4));

			BddConnector.unconnect(cnx);			
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return cons;
	}

	@Override
	public int update(Conseiller cons) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where idcons = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cons.getIdcons());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "update conseiller set nom=?, prenom=?, idagence=? "
					+ "where idcons=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setString(1, cons.getNom().toUpperCase());
			stat.setString(2, cons.getPrenom().toUpperCase());
			stat.setInt(3, cons.getIdagence());
			stat.setInt(4, cons.getIdcons());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);			
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return res;
	}
	
	@Override
	public int delete(Conseiller cons) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where idcons = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cons.getIdcons());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "delete from conseiller where idcons=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, cons.getIdcons());
			// Statement execution
			res = stat.executeUpdate();
			
			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return res;
	}

	@Override
	public Conseiller getID(Conseiller cons) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select * from Conseiller where nom = ?"
					+ " and prenom = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setString(1, cons.getNom().toUpperCase());
			stat.setString(2, cons.getPrenom().toUpperCase());
			ResultSet res = stat.executeQuery(); 
			res.next();
			if (res.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			cons.setIdcons(res.getInt(1));
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return cons;
	}

	@Override
	public Conseiller getUser(Conseiller cons) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select * from Conseiller where login = ?"
					+ " and mdp = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setString(1, cons.getLogin().toUpperCase());
			stat.setString(2, cons.getMdp());
			ResultSet res = stat.executeQuery(); 
			System.out.println(res.toString());
			if (!res.next()) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Login et mot de passe invalides.");
			}
			cons.setIdcons(res.getInt(1));
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return cons;
	}
}
