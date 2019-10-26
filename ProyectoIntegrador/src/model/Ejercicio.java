package model;


/**
 * <h1>Clase Model Ejercicio</h1> que coniene los atributos con los que formaremos objetos de tipo 
 * ejercicio. 
 * @author Carlos
 * @since 24/04/2019
 * @version 1.0
 */


public class Ejercicio {
	private int idEj;
	private String nombreEj; 
	private String descripcion; 
	private int repeticiones;
	private String musculos;	
	
	/** Atributos definidos como privados: 	 
	 *<ul>
	 *  <li><i>ID_ej</i> de tipo int, representa el n�mero de identificaci�n del ejercicio</li>
	 *  <li><i>nombre_ej</i> de tipo String, contiene el nombre del ejercicio</li>
	 *  <li><i>descripcion</i> de tipo String, contiene una descripci�n del ejercicio</li>
	 *  <li><i>repeticiones</i> de tipo int, contiene el n�mero de repeticiones del ejercicio</li>
	 *  <li><i>musculos</i> de tipo String, contiene los nombres de los m�sculos de cada ejercicio</li>	  	
	 *</ul> 
	 * Tambien se describe el constructor Ejercicio */
	
	
		 
	/**<h2>m�todo gEjercicio</h2>
	 * Constructor que recibe 4 par�metros para inicializar/asignar valor a los 5 atributos 
	 * @param idEj de tipo int, contendr� el valor de n�mero de identificaci�n se va a asignar al atributo <i>ID_ej</i>
	 * @param nombre_ej de tipo String, contendr� el valor del nombre que se va a asignar al atributo <i>nombre_ej</i>
	 * @param descripcion de tipo String, contendr� el valor de la descripci�n del atributo <i>descripcion</i>
	 * @param repeticiones de tipo int, contendr� el valor del n�mero de repeticiones del atributo <i>repeticiones</i>
	 * @param musculos de tipo String con los nombres de los m�sculos para ese ejercicio<i>musculos</i>
	 */
	
	public Ejercicio(int idEj, String nombre_ej, String descripcion, int repeticiones, String musculos) {
		this.idEj = idEj;
		this.nombreEj = nombre_ej;
		this.descripcion = descripcion;
		this.repeticiones = repeticiones;
		this.musculos = musculos;
	}
		

	public Ejercicio(String nombreEj, String descripcion, int repeticiones, String musculos) {
		this.nombreEj = nombreEj;
		this.descripcion = descripcion;
		this.repeticiones = repeticiones;
		this.musculos = musculos;
	}

	public Ejercicio(String nombreEj, String descripcion, int repeticiones) {
		this.nombreEj = nombreEj;
		this.descripcion = descripcion;
		this.repeticiones = repeticiones;
	}


	public int getIdEj() {
		return idEj;
	}

	public String getNombreEj() {
		return nombreEj;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public String getMusculos() {
		return musculos;
	}


	@Override
	public String toString() {
		return "Nombr: = " + nombreEj + ", descripci�n: " + descripcion + ", repeticiones: " + repeticiones
				+ ", m�sculos: " + musculos;
	}
	
	
	
	
	
	
	

}
