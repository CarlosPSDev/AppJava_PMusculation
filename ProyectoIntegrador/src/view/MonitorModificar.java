package view;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.UIManager;
import control.ControladorPMusculation;
import model.Ejercicio;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class MonitorModificar extends JDialog {
	
	private JPanel contenedor;	
	private JButton btnModificar;
	private JLabel lblNombre;
	private JRadioButton rdbtnAdd;
	private JTextArea textAInstrucc;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnLimpiar;
	private JRadioButton rdbtnEliminar;
	private ArrayList<String>listadMusculos;
	private JList <String>listMuscDispon;
	private DefaultListModel<String> dlmMDispon;
	private JList <String> listMuscAdd;
	private DefaultListModel<String> dlmMAdd;
	private JSpinner spinRep;
	private JComboBox <String>comboBox;
	private DefaultComboBoxModel<String> cmbEj;
	private ArrayList<Ejercicio> listaEjercicios;
	private static MonitorConsulta frame;
	//private JButton btnCargar;
	private JButton btnEliminar;


	public MonitorModificar() throws HeadlessException {
		super(frame, "Modificar ejercicio");	
		listadMusculos = new ArrayList<String>();
		listaEjercicios = new ArrayList<Ejercicio>();
		inicializar();
	}

	private void inicializar() {
			
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setPreferredSize(new Dimension(543, 552));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ventana = this.getPreferredSize();
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
		pack();
		//setBounds(800, 300, 543, 552);

		contenedor = new JPanel();
		setContentPane(contenedor);
		contenedor.setLayout(null);
		
		btnModificar = new JButton("Modificar");		
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnModificar.setBounds(57, 464, 118, 23);
		contenedor.add(btnModificar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(328, 464, 121, 23);
		contenedor.add(btnLimpiar);
		
		lblNombre = new JLabel("Nombre del Ejercicio:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(30, 11, 145, 23);
		contenedor.add(lblNombre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 90, 474, 110);
		contenedor.add(scrollPane);
		
		textAInstrucc = new JTextArea();
		scrollPane.setViewportView(textAInstrucc);
		textAInstrucc.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("Instrucciones para hacer el ejercicio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 56, 239, 23);
		contenedor.add(lblNewLabel);
		
		JLabel lblMsculos = new JLabel("Músculos disponibles:");
		lblMsculos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsculos.setBounds(20, 257, 138, 20);
		contenedor.add(lblMsculos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 288, 169, 149);
		contenedor.add(scrollPane_1);
		
		listMuscDispon = new JList<String>();
		listMuscDispon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_1.setViewportView(listMuscDispon);
		listMuscDispon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dlmMDispon = new DefaultListModel<String>();
		listMuscDispon.setModel(dlmMDispon);		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(348, 288, 169, 149);
		contenedor.add(scrollPane_2);
		
		listMuscAdd = new JList<String>();
		listMuscAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane_2.setViewportView(listMuscAdd);
		listMuscAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dlmMAdd = new DefaultListModel<String>();
		listMuscAdd.setModel(dlmMAdd);		
		
		
		rdbtnAdd = new JRadioButton("Añadir Músculo");
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnAdd);
		rdbtnAdd.setBounds(213, 302, 129, 23);
		contenedor.add(rdbtnAdd);
		
		rdbtnEliminar = new JRadioButton("Eliminar Músculo");
		rdbtnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnEliminar);
		rdbtnEliminar.setBounds(209, 375, 121, 23);
		contenedor.add(rdbtnEliminar);
		
		JLabel lblNewLabel_1 = new JLabel("Músculos añadidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(363, 260, 136, 14);
		contenedor.add(lblNewLabel_1);		
		
		JLabel lblNumRep = new JLabel("Número de Repeticiones:");
		lblNumRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumRep.setBounds(57, 219, 160, 14);
		contenedor.add(lblNumRep);
		
		spinRep = new JSpinner();
		spinRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinRep.setModel(new SpinnerNumberModel(1, 0, 50, 1));
		spinRep.setBounds(277, 211, 54, 32);
		contenedor.add(spinRep);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(211, 13, 270, 21);
		cmbEj = new DefaultComboBoxModel<String>();
		comboBox.setModel(cmbEj);
		comboBox.setSelectedIndex(-1);
		contenedor.add(comboBox);		
		
		/*btnCargar = new JButton("Cargar");
		btnCargar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCargar.setBounds(343, 45, 89, 23);
		contenedor.add(btnCargar);*/
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(200, 464, 106, 23);
		contenedor.add(btnEliminar);
		
	}
	
	public void cargarMusculos(ArrayList<String> listaMusculos) {
		listadMusculos = listaMusculos;
		for (String musculo : listadMusculos) {
			dlmMDispon.addElement(musculo);
		}
		
	}
	
	public void cargarlistEjercicios(ArrayList<Ejercicio> ejercicios) {	
		cmbEj.removeAllElements();
		listaEjercicios = ejercicios;
		
		cmbEj.addElement("--Selecciona--");		
		for (Ejercicio ejercicio : ejercicios) {			
			cmbEj.addElement(ejercicio.getNombreEj());
		}
	}
	
	public String obtenerEjercModif() {		
		String nombreEj = (String)comboBox.getSelectedItem();		
		return nombreEj;
	}
	
	public void cargarDatosEjercicio(String nombreEj) {
		String [] musculosEjerc;
		for (Ejercicio ejercicio : listaEjercicios) {
			if (ejercicio.getNombreEj().equals(nombreEj)) {
				textAInstrucc.setText(ejercicio.getDescripcion());
				spinRep.setValue(ejercicio.getRepeticiones());
				musculosEjerc = ejercicio.getMusculos().trim().split(", ");
				for (int i = 0; i < musculosEjerc.length; i++) {
					dlmMAdd.addElement(musculosEjerc[i]);
				}				
			}			
		}
	}
	
	public String obtenerMuscSel() {
		String musculoSelec = null;
		
		if (listMuscDispon.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un músculo", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			musculoSelec = listMuscDispon.getSelectedValue();
		}
		return musculoSelec;
	}
	
	public void cargarListaAdd(String muscSelec) {
		if (!dlmMAdd.contains(muscSelec)) {
			dlmMAdd.addElement(muscSelec);
		}		
	}
	
	public String obtenerMuscBorrar() {
		String muscBorrar = null;
		
		if (listMuscAdd.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay ningún músculo seleccionado para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			muscBorrar = listMuscAdd.getSelectedValue();
		}
		
		return muscBorrar;
	}

	public void actualizarListaAdd(String muscBorrar) {
		dlmMAdd.removeElement(muscBorrar);
		
	}
	
	public Ejercicio obtenerDatosModificar(){
		Ejercicio ejercicioN = null;
		String nombreE;
		String descrip;
		int rept;
		String musculos = "";
		if (textAInstrucc.getText().isEmpty() | dlmMAdd.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			nombreE = (String)comboBox.getSelectedItem();
			descrip = textAInstrucc.getText(); 
			rept = (int) spinRep.getValue();
			for(int i = 0; i < listMuscAdd.getModel().getSize(); i++){
				 musculos = musculos + " " +listMuscAdd.getModel().getElementAt(i);
				if (i < listMuscAdd.getModel().getSize() -1) {
					musculos += ",";
				}			    
			}
			ejercicioN = new Ejercicio(nombreE, descrip, rept, musculos);
			
		}
		return ejercicioN;
	}
	public void limpiarCampos(boolean combo) {
		if (combo) {
			comboBox.setSelectedIndex(0);
		}				
		textAInstrucc.setText("");
		spinRep.setValue(1);		
		dlmMAdd.removeAllElements();
		buttonGroup.clearSelection();
		listMuscAdd.removeAll();
		listMuscDispon.clearSelection();
		
	}	
	
	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JRadioButton getRdbtnAdd() {
		return rdbtnAdd;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JRadioButton getRdbtnEliminar() {
		return rdbtnEliminar;
	}	
	

	public JList<String> getListMuscDispon() {
		return listMuscDispon;
	}

	public JList<String> getListMuscAdd() {
		return listMuscAdd;
	}

	
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}	
	

	/*public JButton getBtnCargar() {
		return btnCargar;
	}*/

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void hacerVisible() {
	 	setVisible(true);
	
	}
	
	
	public void setControlador(ControladorPMusculation controlador) {			
		btnModificar.addActionListener(controlador);
		btnLimpiar.addActionListener(controlador);
		btnEliminar.addActionListener(controlador);
		rdbtnAdd.addItemListener(controlador); 
		rdbtnEliminar.addItemListener(controlador);
		comboBox.addItemListener(controlador);
		//btnCargar.addActionListener(controlador);
		listMuscDispon.addMouseListener(controlador);
		listMuscAdd.addMouseListener(controlador);		
	}
	
}
