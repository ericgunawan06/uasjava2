package tanyakjawab;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class frmHighscore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnEnter;
	private JScrollPane scrollPane;
	static String nl,name;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		frmHighscore frame = new frmHighscore();
		frame.setVisible(true);
		/*try (Socket s = new Socket("172.16.126.34",9090)){
			BufferedReader cin = new BufferedReader(
					new InputStreamReader(System.in)
					);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							s.getInputStream()
							)
					);
			PrintWriter out = new PrintWriter(
					s.getOutputStream(),
					true
					);
			 
		
				out.println("test");
			
		}*/
					
			
	}

	/**
	 * Create the frame.
	 */
	public frmHighscore() {
		setTitle("Who Wants To Be A Millionaire");
		JPanel panel2 = new JPanel(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 414, 168);
		contentPane.add(scrollPane);
		
		
		JLabel lblHighscore = new JLabel("HIGHSCORE");
		lblHighscore.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 27));
		lblHighscore.setBounds(10, 0, 156, 37);
		contentPane.add(lblHighscore);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 46, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(53, 43, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					name = textField.getText();
					frmPlay fp = new frmPlay();
					nl = frmPlay.retNilai();
					if(nl.isEmpty()){
						nl = "Nol";
					}
					Socket s = new Socket(main.ip(), 9090);
					PrintWriter p = new PrintWriter(s.getOutputStream(),true);
					p.println(name);
					p.println(nl);
					textField.setText("");
					btnEnter.setEnabled(false);
					TimeUnit.SECONDS.sleep(3);
					database db = new database();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Vector<Vector<Object>> newData = new Vector<>();
					 Vector<Object> columnNames = new Vector<Object>();
				        columnNames.add("No");
				        columnNames.add("Nama Player");
				        columnNames.add("Score");
				     newData = db.selectHighscore();
				     model.setDataVector(newData, columnNames);
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

			}
		});
		
		
		btnEnter.setBounds(181, 42, 89, 23);
		contentPane.add(btnEnter);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main formMain = new main();
				formMain.setVisible(true);
				setVisible(false);
			}
		});
		btnMainMenu.setBounds(281, 11, 143, 23);
		contentPane.add(btnMainMenu);
		
		Vector<Vector<Object>> data = null;
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("No");
        columnNames.add("Nama Player");
        columnNames.add("Score");
        try {
            database db = new database();
            data = db.selectHighscore();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ;
        
        table = new JTable(data, columnNames);
        table.setBounds(10, 71, 414, 168);
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
		
	}
}
