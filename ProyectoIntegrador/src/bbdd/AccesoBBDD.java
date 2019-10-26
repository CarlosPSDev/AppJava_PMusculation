package bbdd;
/**
 * <h1>Clase AccesoBBDD</h1> donde creamos la conexi�n a la base de datos.
 * Contiene los atributos con los que crearemos la conexi�n a la bases de datos
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoBBDD {
	
	private String driver; 
	private String url;
	/** Atributos definidos como privados: 	 
	 *<ul>
	 *  <li><i>driver</i> de tipo String, representa el driver utilizado para la conexi�n</li>
	 *  <li><i>url</i> de tipo String, contiene la direcci�n de acceso para la conexi�n a la BBDD</li>	 *    	
	 *</ul> 
	 *
	 *
	 * Tambien se describe el constructor AccesoBBDD */
	
	/**<h2>m�todo AccdesoBBDD</h2>
	 * Constructor que recibe 2 par�metros para inicializar/asignar valor a los 2 atributos 
	 * @param driver de tipo String, contendr� el valor de n�mero de identificaci�n se va a asignar al atributo <i>driver</i>
	 * @param url de tipo String, contendr� el valor de la direcci�n del atributo<i>url</i>	 
	 */	
	public AccesoBBDD() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:dbSQLITE/POJOMUSCULATION.db"; 
	}
	
	/**
	 * M�todo getConexion para establecer la conexi�n con la BBDD.*
	 * @return el atributo "con" con la conexi�n
	 * @throws ClassNotFoundException excepci�n que es propagada al m�todo  que lo invoque
	 * @throws SQLException excepci�n que es propagada al m�todo  que lo invoque
	 */
	public Connection getConexion() throws ClassNotFoundException, SQLException { 
		Class.forName(driver); 
		Connection con = DriverManager.getConnection(url); 
		return con; 
	}
	

}
