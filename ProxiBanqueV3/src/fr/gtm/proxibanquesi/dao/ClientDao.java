package fr.gtm.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * @author Alexandre et Coralie 
 * Cette classe est la classe DAO qui contient les méthodes create(Client), read(Client), update(Client), delete(Client) et Client getID(Client).
 *
 */
public class ClientDao implements IClientDao {

	@Override

	public int create(Client cli) throws LigneExistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();

			String check = "select count(*) from Client where nom = ?" + " and prenom = ? and adresse = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setString(1, cli.getNom().toUpperCase());
			checkstat.setString(2, cli.getPrenom().toUpperCase());
			checkstat.setString(3, cli.getAdresse().toUpperCase());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) != 0) {
				BddConnector.unconnect(cnx);
				throw new LigneExistanteException("Ce client existe déja.");
			}
			// Statement preparation
			String sql = "insert into client(idclient, nom, prenom, adresse, codepostal, ville, telephone, idcons)"
					+ " values " + "( seq_idclient.nextval, ? , ? , ?, ?, ?, ?, ?)";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setString(1, cli.getNom().toUpperCase());
			stat.setString(2, cli.getPrenom().toUpperCase());
			stat.setString(3, cli.getAdresse().toUpperCase());
			stat.setString(4, cli.getCodePostal());
			stat.setString(5, cli.getVille().toUpperCase());
			stat.setString(6, cli.getTelephone());
			stat.setInt(7, cli.getCons());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return res;
	}

	@Override
	public Client read(Client cli) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Client where idclient = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cli.getId());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce client n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "select * from client where idclient=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, cli.getId());
			// Statement execution
			ResultSet res = stat.executeQuery();
			res.next();
			cli.setNom(res.getString(2));
			cli.setPrenom(res.getString(3));
			cli.setAdresse(res.getString(4));
			cli.setCodePostal(res.getString(5));
			cli.setVille(res.getString(6));
			cli.setTelephone(res.getString(7));
			cli.setCons(res.getInt(8));

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cli;
	}

	@Override
	public int update(Client cli) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Client where idclient = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cli.getId());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce client n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "update client set nom=?, prenom=?, adresse=?, codepostal=?, ville=?, telephone=?, idcons=? "
					+ "where idclient=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setString(1, cli.getNom().toUpperCase());
			stat.setString(2, cli.getPrenom().toUpperCase());
			stat.setString(3, cli.getAdresse());
			stat.setString(4, cli.getCodePostal());
			stat.setString(5, cli.getVille());
			stat.setString(6, cli.getTelephone());
			stat.setInt(7, cli.getCons());
			stat.setInt(8, cli.getId());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return res;
	}

	@Override
	public int delete(Client cli) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Client where idclient = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cli.getId());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce client n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "delete from client where idclient=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, cli.getId());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return res;
	}

	@Override
	public Client getID(Client cli) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select * from Client where nom = ?" + " and prenom = ? and adresse = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setString(1, cli.getNom().toUpperCase());
			stat.setString(2, cli.getPrenom().toUpperCase());
			stat.setString(3, cli.getAdresse().toUpperCase());
			ResultSet res = stat.executeQuery();
			if (!res.next()) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce client n'existe pas dans la base.");
			}
			cli.setId(res.getInt(1));

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cli;
	}

	@Override
	public ArrayList<Integer> getListeClients(int idcons) {
		ArrayList<Integer> listeClients = new ArrayList<Integer>();
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select idclient from Client where idcons = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setInt(1, idcons);
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				listeClients.add(res.getInt(1));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeClients;
	}

}
