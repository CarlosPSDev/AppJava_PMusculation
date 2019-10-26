package model;
/**
 * <h1>Clase Model Musculo</h1> que coniene los atributos con los que formaremos objetos de tipo 
 * m�sculo. 
 * @author Carlos
 * @since 24/04/2019
 * @version 1.0
 */

public class Musculo {
	/** Atributos definidos como privados: 	 
	 *  <ul>
	 *  	<li><i>ID_u</i> de tipo int, representa el n�mero de identificaci�n del m�sculo</li>
	 *  	<li><i>nombre_musc</i> de tipo String, contiene el nombre del m�sculo</li>
	 *  	<li><i>regi�n</i> de tipo String, indica la zona del cuerpo trabajada</li>	 *  	
	 *  </ul> 
	 * Tambien se describe el constructor Musculo */
	
	private int idMusc;
	private String nombreMusc; 
	private String region;
	
	/**<h2>m�todo Usuario</h2>
	 * Constructor que recibe 3 par�metros para inicializar/asignar valor a los 3 atributos 
	 * @param iD_musc de tipo int, contendr� el valor de n�mero de identificaci�n se va a asignar 
	 * al atributo <i>ID_musc</i>
	 * @param nombre_musc de tipo String, contendr� el valor del nombre que se va a asignar 
	 * al atributo <i>nombre_musc</i>
	 * @param region de tipo String, contendr� el valor de la zona del cuerpo que ejercita el ejercicio <i>region</i>	 
	 */	
	
	public Musculo(int idMusc, String nombreMusc, String region) {
		this.idMusc = idMusc;
		this.nombreMusc = nombreMusc;
		this.region = region;
	}

	public int getIdMusc() {
		return idMusc;
	}

	public String getNombreMusc() {
		return nombreMusc;
	}

	public String getRegion() {
		return region;
	}
	
	
	

}
