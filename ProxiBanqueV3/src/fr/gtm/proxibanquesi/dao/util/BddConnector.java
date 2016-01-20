package fr.gtm.proxibanquesi.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilitary class handling the connection to Oracle database.
 * @author Alexandre De Bruyn
 *
 */
public final class BddConnector {

	/** Empty constructor preventing instantiation. */
	private BddConnector() { }
	/** Oracle driver class. */
	private static String pilote = "oracle.jdbc.OracleDriver";
	/** URL of oracle database. */
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	/** Login of the database user. */
	private static String login = "proxibanque";
	/** Password of the database user. */
	private static String password = "proxipass";

	// Methods
	 /** Create a connection to the database.
	 * @return A Connection object
	 */
	public static Connection connect() {
		Connection cnx = null;
		try {
			Class.forName(pilote);
			cnx = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(BddConnector.class.getName()).log(Level.SEVERE, null, ex);
		}
		return cnx;
	}

	/** Close a connection to the database.
	 * @param cnx The connection to close
	 */
	public static void unconnect(final Connection cnx) {
		try {
			cnx.close();
		} catch (SQLException ex) {
			Logger.getLogger(BddConnector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
