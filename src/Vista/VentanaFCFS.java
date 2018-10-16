/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 *
 * @author Camila
 */


public class VentanaFCFS {

	private JFrame frmAlgoritmoFcfs;
	private JTable tablaProcesos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFCFS window = new VentanaFCFS();
					window.frmAlgoritmoFcfs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaFCFS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlgoritmoFcfs = new JFrame();
		frmAlgoritmoFcfs.setTitle("Algoritmo FCFS");
		frmAlgoritmoFcfs.setBounds(100, 100, 680, 509);
		frmAlgoritmoFcfs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgoritmoFcfs.getContentPane().setLayout(null);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(SystemColor.window);
		panelTabla.setBounds(0, 0, 664, 251);
		frmAlgoritmoFcfs.getContentPane().add(panelTabla);
		
		JButton btnAnadirProceso = new JButton("A\u00F1adir Proceso");
		btnAnadirProceso.setForeground(Color.WHITE);
		btnAnadirProceso.setBackground(SystemColor.activeCaption);
		btnAnadirProceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnLimpiarTablas = new JButton("Limpiar Tabla");
		btnLimpiarTablas.setForeground(Color.WHITE);
		btnLimpiarTablas.setBackground(SystemColor.activeCaption);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tablaProcesos = new JTable();
		tablaProcesos.setBackground(SystemColor.window);
		tablaProcesos.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablaProcesos.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "1", "1", "1", "1", "1", "12"},
				{"3", "4", "5", "6", "7", "8", null},
			},
			new String[] {
				"ID", "T. Llegada", "R\u00E1faga", "T. Inicio", "T. Final", "T. Retorno", "T. Espera"
			}
		));
		scrollPane.setViewportView(tablaProcesos);
		
		JLabel lblTablaDeProcesos = new JLabel("Tabla de procesos");
		lblTablaDeProcesos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTablaDeProcesos.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panelTabla = new GroupLayout(panelTabla);
		gl_panelTabla.setHorizontalGroup(
			gl_panelTabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabla.createSequentialGroup()
					.addGap(96)
					.addComponent(btnAnadirProceso, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(122)
					.addComponent(btnLimpiarTablas, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
				.addGroup(Alignment.TRAILING, gl_panelTabla.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_panelTabla.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblTablaDeProcesos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
					.addGap(20))
		);
		gl_panelTabla.setVerticalGroup(
			gl_panelTabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabla.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTablaDeProcesos)
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelTabla.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpiarTablas)
						.addComponent(btnAnadirProceso))
					.addGap(26))
		);
		panelTabla.setLayout(gl_panelTabla);
		
		JPanel panelGantt = new JPanel();
		panelGantt.setBackground(SystemColor.window);
		panelGantt.setBounds(0, 252, 664, 218);
		frmAlgoritmoFcfs.getContentPane().add(panelGantt);
		panelGantt.setLayout(null);
		
		JLabel lblDiagramaDeGantt = new JLabel("Diagrama de Gantt");
		lblDiagramaDeGantt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiagramaDeGantt.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagramaDeGantt.setBounds(10, 11, 644, 14);
		panelGantt.add(lblDiagramaDeGantt);
	}
}

