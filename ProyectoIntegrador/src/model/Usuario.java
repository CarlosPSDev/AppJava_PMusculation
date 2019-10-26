package model;
/**
 * <h1>Clase Padre Model Usuario</h1> que coniene los atributos con los que formaremos objetos de tipo 
 * Usuario que ser�n definidos en las clases hijas. 
 * @author Carlos
 * @since 24/04/2019
 * @version 1.0
 */

public class Usuario {	
	/** Atributos definidos como privados: 	 
	 *  <ul>
	 *  	<li><i>nombre</i> de tipo String, contiene el nombre del usuario</li>
	 *  	<li><i>tipo</i> de tipo String, diferencia si el usuario es monitor o cliente</li>
	 *  	<li><i>ID_u</i> de tipo int, representa el n�mero de identificaci�n del usuario</li>
	 *  </ul> 
	 * Tambien se describe el constructor Usuario */
	
	private String nombre;
	private String tipo;
	private int idU;
	
	/**<h2>m�todo Usuario</h2>
	 * Constructor que recibe 3 par�metros para inicializar/asignar valor a los 3 atributos 
	 * @param nombre de tipo String, contendr� el valor del nombre que se va a asignar al atributo <i>nombre</i>
	 * @param tipo de tipo String, contendr� el valor del tipo de usuario que se va a asignar al atributo <i>tipo</i>
	 * @param iD_u de tipo int, contendr� el valor de n�mero de identificaci�n se va a asignar al atributo <i>ID</i>
	 */
	public Usuario(String nombre, String tipo, int idU) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.idU = idU;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getIdU() {
		return idU;
	}

	
	
	
	
	

}
