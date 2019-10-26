package view;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import control.ControladorPMusculation;
import model.Ejercicio;
import javax.swing.JButton;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class MonitorCrear extends JFrame {
	
	private JPanel contenedor;	
	private JButton btnCrearNuevo;
	private JLabel lblNombre;
	private JTextField textFNombreEj;
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


	public MonitorCrear() throws HeadlessException {
		super("Alta de ejercicio");	
		listadMusculos = new ArrayList<String>();
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
		
		btnCrearNuevo = new JButton("Crear");		
		btnCrearNuevo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnCrearNuevo.setBounds(105, 464, 124, 23);
		contenedor.add(btnCrearNuevo);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(283, 464, 124, 23);
		contenedor.add(btnLimpiar);
		
		lblNombre = new JLabel("Nombre del Ejercicio:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(30, 11, 160, 23);
		contenedor.add(lblNombre);
		
		textFNombreEj = new JTextField();
		textFNombreEj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFNombreEj.setBounds(187, 14, 317, 20);
		contenedor.add(textFNombreEj);
		textFNombreEj.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 90, 474, 110);
		contenedor.add(scrollPane);
		
		textAInstrucc = new JTextArea();
		textAInstrucc.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(textAInstrucc);
		
		JLabel lblNewLabel = new JLabel("Instrucciones para hacer el ejercicio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 56, 239, 23);
		contenedor.add(lblNewLabel);
		
		JLabel lblMsculos = new JLabel("Músculos disponibles:");
		lblMsculos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMsculos.setBounds(24, 262, 138, 20);
		contenedor.add(lblMsculos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 293, 169, 149);
		contenedor.add(scrollPane_1);
		
		listMuscDispon = new JList<String>();		
		listMuscDispon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listMuscDispon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dlmMDispon = new DefaultListModel<String>();
		listMuscDispon.setModel(dlmMDispon);
		scrollPane_1.setViewportView(listMuscDispon);	
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(348, 293, 169, 149);
		contenedor.add(scrollPane_2);
		
		listMuscAdd = new JList<String>();
		listMuscAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listMuscAdd.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		dlmMAdd = new DefaultListModel<String>();
		listMuscAdd.setModel(dlmMAdd);		
		scrollPane_2.setViewportView(listMuscAdd);
		
		
		rdbtnAdd = new JRadioButton("Añadir Músculo");
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnAdd);
		rdbtnAdd.setBounds(210, 317, 129, 23);
		contenedor.add(rdbtnAdd);
		
		rdbtnEliminar = new JRadioButton("Eliminar Músculo");
		rdbtnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonGroup.add(rdbtnEliminar);
		rdbtnEliminar.setBounds(210, 383, 121, 23);
		contenedor.add(rdbtnEliminar);
		
		JLabel lblNewLabel_1 = new JLabel("Músculos añadidos:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(360, 265, 136, 14);
		contenedor.add(lblNewLabel_1);		
		
		JLabel lblNumRep = new JLabel("Número de Repeticiones:");
		lblNumRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumRep.setBounds(79, 219, 172, 23);
		contenedor.add(lblNumRep);
		
		spinRep = new JSpinner();
		spinRep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinRep.setModel(new SpinnerNumberModel(1, 0, 50, 1));
		spinRep.setBounds(288, 215, 54, 32);
		contenedor.add(spinRep);
	}
	
	public void cargarMusculos(ArrayList<String> listaMusculos) {
		listadMusculos = listaMusculos;
		for (String musculo : listadMusculos) {
			dlmMDispon.addElement(musculo);
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
		String muscBorrar = "";
		
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
	
	public Ejercicio obtenerDatosCrear(){
		Ejercicio ejercicioN = null;
		String nombreE;
		String descrip;
		int rept;
		String musculos = "";
		if (textFNombreEj.getText().isEmpty() | textAInstrucc.getText().isEmpty() | dlmMAdd.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			nombreE = textFNombreEj.getText();
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
	public void limpiarCampos() {
		textFNombreEj.setText("");
		textAInstrucc.setText("");
		spinRep.setValue(1);
		dlmMAdd.removeAllElements();
		
	}
	
	public JButton getBtnCrearNuevo() {
		return btnCrearNuevo;
	}

	public JRadioButton getRdbtnAdd() {
		return rdbtnAdd;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
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

	public void hacerVisible() {
	 	setVisible(true);
	
	}
	
	
	public void setControlador(ControladorPMusculation controlador) {			
		btnCrearNuevo.addActionListener(controlador);
		btnLimpiar.addActionListener(controlador);
		rdbtnAdd.addItemListener(controlador); 
		rdbtnEliminar.addItemListener(controlador);
		listMuscDispon.addMouseListener(controlador);
		listMuscAdd.addMouseListener(controlador);
	}

	

	
}
