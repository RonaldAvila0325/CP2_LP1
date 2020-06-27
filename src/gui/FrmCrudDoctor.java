package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Doctor;
import model.DoctorModel;
import util.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class FrmCrudDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtFecha;
	private JTextField txtSueldo;
	private JTextField txtEmail;
	private JTable table;
	
	int idSeleccionado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudDoctor frame = new FrmCrudDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public FrmCrudDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO DOCTOR");
		lblNewLabel.setBounds(160, 11, 178, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(10, 63, 121, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(10, 92, 121, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FECHA NACIMIENTO");
		lblNewLabel_3.setBounds(10, 121, 140, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SUELDO");
		lblNewLabel_4.setBounds(291, 63, 56, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CORREO");
		lblNewLabel_5.setBounds(291, 102, 56, 14);
		contentPane.add(lblNewLabel_5);
		
		
		
		txtNombre = new JTextField();
		txtNombre.setBounds(160, 59, 121, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(160, 88, 121, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(160, 117, 121, 20);
		contentPane.add(txtFecha);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(357, 60, 121, 20);
		contentPane.add(txtSueldo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(357, 99, 121, 20);
		contentPane.add(txtEmail);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 468, 127);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idoctor", "Nombre", "DNI", "FechaNacimiento", "Sueldo", "Correo"
			}
		));
		
		listaDoctor();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				int fila = table.getSelectedRow();

				idSeleccionado = Integer.parseInt(table.getValueAt(fila, 0).toString());
				String nom= table.getValueAt(fila, 1).toString();
				String dni= table.getValueAt(fila, 2).toString();
				String fec= table.getValueAt(fila, 3).toString();
				String sue= table.getValueAt(fila, 4).toString();
				String ema= table.getValueAt(fila, 5).toString();

				txtNombre.setText(nom);
				txtDNI.setText(dni);
				txtFecha.setText(fec);
				txtSueldo.setText(sue);
				txtEmail.setText(ema);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nom=txtNombre.getText().trim();
				String dni=txtDNI.getText().trim();
				String fec=txtFecha.getText().trim();
				String sue=txtSueldo.getText().trim();
				String ema=txtEmail.getText().trim();		
				
				if(nom.matches(Validaciones.NOMBRE)== false) 
				{
					mensaje("El nombre debe ser entre 3 y 30 cacateres");
				}
				else if(dni.matches(Validaciones.DNI)== false) 
				{
					mensaje("El DNI debe ser de 8 digitos");
				}
				else if(fec.matches(Validaciones.FECHA)== false) 
				{
					mensaje("El año es yyyy/MM/dd");
				}
				else if(sue.matches(Validaciones.SUELDO)== false)
				{
					mensaje("El sueldo debe llevar decimal 0.0");
				}
				
				else if(ema.matches(Validaciones.CORREO)== false) 
				{
					mensaje("El correo debe ser xxx.xxx.xxx@xxx.xx");
				}
				else 
				{
					Doctor obj=new Doctor();
					obj.setIdoctor(idSeleccionado);
					obj.setNombre(nom);
					obj.setDni(dni);
					obj.setFechaNacimiento(fec);
					obj.setSueldo(sue);
					obj.setEmail(ema);
					
					DoctorModel m=new DoctorModel();
					int salida=m.insertaDoctor(obj);
					
					if(salida > 0) 
					{
						mensaje("Se registro correctamente");
						listaDoctor();
						limpiarCajasTexto();
					}
					else 
					{
						mensaje("Error en el registro");
					}
				}
			}
		});
		btnRegistrar.setBounds(10, 159, 121, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(idSeleccionado== -1) 
				{
					mensaje("Se debe seleccionar una fila");
				}
				else 
				{
					DoctorModel m=new DoctorModel();
					int s=m.eliminaDoctor(idSeleccionado);
					
					if (s > 0) 
					{
						mensaje("Se elimino correctamente");
						listaDoctor();
						limpiarCajasTexto();
						idSeleccionado= -1;
					} else 
					{
						mensaje("Error al eliminar");
					}
				}
			}
		});
		btnEliminar.setBounds(389, 159, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(idSeleccionado==-1) 
				{
					mensaje("Se debe seleccionar una fila");
				}
				else 
				{
					String nom=txtNombre.getText().trim();
					String dni=txtDNI.getText().trim();
					String fec=txtFecha.getText().trim();
					String sue=txtSueldo.getText().trim();
					String ema=txtEmail.getText().trim();		
					
					if(nom.matches(Validaciones.NOMBRE)== false) 
					{
						mensaje("El nombre debe ser entre 3 y 30 cacateres");
					}
					else if(dni.matches(Validaciones.DNI)== false) 
					{
						mensaje("El DNI debe ser de 8 digitos");
					}
					else if(fec.matches(Validaciones.FECHA)== false) 
					{
						mensaje("El año es yyyy/MM/dd");
					}
					else if(sue.matches(Validaciones.SUELDO)== false)
					{
						mensaje("El sueldo debe llevar decimal 0.0");
					}
					
					else if(ema.matches(Validaciones.CORREO)== false) 
					{
						mensaje("El correo debe ser xxx.xxx.xxx@xxx.xx ");
					}
					else 
					{
						Doctor obj=new Doctor();
						obj.setIdoctor(idSeleccionado);
						obj.setNombre(nom);
						obj.setDni(dni);
						obj.setFechaNacimiento(fec);
						obj.setSueldo(sue);
						obj.setEmail(ema);
						
						DoctorModel m=new DoctorModel();
						int salida=m.actualizaDoctor(obj);
						
						if(salida > 0) 
						{
							mensaje("Se actualizo correctamente");
							listaDoctor();
							limpiarCajasTexto();
							idSeleccionado=-1;
						}
						else 
						{
							mensaje("Error al actualizar");
						}
					}
				}
			}
		});
		btnActualizar.setBounds(192, 159, 121, 23);
		contentPane.add(btnActualizar);
		
	}
	
	void listaDoctor()
	{
		DoctorModel m=new DoctorModel();
		List<Doctor> data=m.listaDoctor();
		
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for(Doctor aux: data) 
		{
			Object[]fila= 
				{
						aux.getIdoctor(),
						aux.getNombre(),
						aux.getDni(),
						aux.fechaNacimiento,
						aux.getSueldo(),
						aux.getEmail(),
				};
			dtm.addRow(fila);
		}
	}

	void mensaje(String m)
	{
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() 
	{
		txtNombre.setText("");
		txtDNI.setText("");
		txtFecha.setText("");
		txtSueldo.setText("");
		txtEmail.setText("");
		txtNombre.requestFocus();
	}
}
