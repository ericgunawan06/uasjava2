package tanyakjawab;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.border.LineBorder;


public class frmPlay extends JFrame {
	static int r;
	static int level = 1;
	static int fifty, rand, randd, ata;
	static String [] Soal = new String [11];
	static String [] J1 = new String [11];
	static String [] J2 = new String [11];
	static String [] J3 = new String [11];
	static String [] J4 = new String [11];
	static String [] Jb = new String [11];
	static String nilai;
	private JPanel contentPane;
	private JTextPane label;
	
	private static void loadSoal()  throws UnknownHostException, IOException {
		try (Socket s = new Socket(main.ip(),9090)){
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
			
			String response ="";
			String request ="";
			
			
			for (int i = 0; i < 11; i++) {
				response = in.readLine();
				Soal[i] = response;
				response = in.readLine();
				J1[i] = response;
				response = in.readLine();
				J2[i] = response;
				response = in.readLine();
				J3[i] = response;
				response = in.readLine();
				J4[i] = response;
				response = in.readLine();
				Jb[i] = response;	
			}
		}
	}

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	
	public static String retNilai(){
		return nilai;
		
	}
	
	public static void main(String[] args) throws Exception{
		frmPlay frame = new frmPlay();
		frame.setVisible(true);
		
	}
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public frmPlay() throws UnknownHostException, IOException {
		setTitle("Who Wants To Be A Millionaire");
		loadSoal();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJwb1 = new JButton("");
		btnJwb1.setBounds(10, 297, 199, 61);
		btnJwb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnJwb1);
		
		JButton btnJwb2 = new JButton("");
		btnJwb2.setBounds(219, 297, 201, 61);
		btnJwb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnJwb2);
		
		JButton btnJwb3 = new JButton("");
		btnJwb3.setBounds(10, 369, 199, 60);
		btnJwb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnJwb3);
		
		JButton btnJwb4 = new JButton("");
		btnJwb4.setBounds(219, 369, 201, 60);
		btnJwb4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnJwb4);
		
		label = new JTextPane();
		label.setBorder(new LineBorder(new Color(0, 204, 153), 3));
		contentPane.add(label);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setLocation(new Point(10, 131));
		label.setBounds(new Rectangle(10, 131, 0, 0));
		label.setEditable(false);
		label.setBounds(10, 171, 408, 115);
		
		label.setBackground(null);
		
		StyledDocument doc = label.getStyledDocument();
		
		JPanel panel = new JPanel();
		panel.setBounds(430, 44, 145, 394);
		panel.setBackground(new Color(255, 255, 0));
		panel.setForeground(new Color(128, 0, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCepe = new JLabel("Cepe");
		lblCepe.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblCepe.setOpaque(true);
		lblCepe.setForeground(new Color(255, 255, 0));
		lblCepe.setBackground(new Color(0, 0, 128));
		lblCepe.setHorizontalAlignment(SwingConstants.CENTER);
		lblCepe.setBounds(0, 360, 145, 36);
		panel.add(lblCepe);
		
		JLabel lblNope = new JLabel("Nope");
		lblNope.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblNope.setForeground(new Color(255, 255, 0));
		lblNope.setBackground(new Color(0, 0, 128));
		lblNope.setOpaque(true);
		lblNope.setHorizontalAlignment(SwingConstants.CENTER);
		lblNope.setBounds(0, 324, 145, 36);
		panel.add(lblNope);
		
		JLabel lblGope = new JLabel("Gope");
		lblGope.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblGope.setOpaque(true);
		lblGope.setForeground(new Color(255, 255, 0));
		lblGope.setBackground(new Color(0, 0, 128));
		lblGope.setHorizontalAlignment(SwingConstants.CENTER);
		lblGope.setBounds(0, 288, 145, 36);
		panel.add(lblGope);
		
		JLabel lblCeban = new JLabel("Ceban");
		lblCeban.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblCeban.setOpaque(true);
		lblCeban.setForeground(new Color(255, 255, 0));
		lblCeban.setBackground(new Color(0, 0, 128));
		lblCeban.setHorizontalAlignment(SwingConstants.CENTER);
		lblCeban.setBounds(0, 144, 145, 36);
		panel.add(lblCeban);
		
		JLabel lblGoban = new JLabel("Goban");
		lblGoban.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblGoban.setForeground(new Color(255, 255, 0));
		lblGoban.setBackground(new Color(0, 0, 128));
		lblGoban.setOpaque(true);
		lblGoban.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoban.setBounds(0, 108, 145, 36);
		panel.add(lblGoban);
		
		JLabel lblCepeceng = new JLabel("Cepeceng");
		lblCepeceng.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblCepeceng.setOpaque(true);
		lblCepeceng.setForeground(new Color(255, 255, 0));
		lblCepeceng.setBackground(new Color(0, 0, 128));
		lblCepeceng.setHorizontalAlignment(SwingConstants.CENTER);
		lblCepeceng.setBounds(0, 72, 145, 36);
		panel.add(lblCepeceng);
		
		JLabel lblGopeceng = new JLabel("Gopeceng");
		lblGopeceng.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblGopeceng.setForeground(new Color(255, 255, 0));
		lblGopeceng.setBackground(new Color(0, 0, 128));
		lblGopeceng.setOpaque(true);
		lblGopeceng.setHorizontalAlignment(SwingConstants.CENTER);
		lblGopeceng.setBounds(0, 36, 145, 36);
		panel.add(lblGopeceng);
		
		JLabel lblGoceng = new JLabel("Goceng");
		lblGoceng.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblGoceng.setForeground(new Color(255, 255, 0));
		lblGoceng.setBounds(0, 180, 145, 36);
		panel.add(lblGoceng);
		lblGoceng.setBackground(new Color(0, 0, 128));
		lblGoceng.setOpaque(true);
		lblGoceng.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNoceng = new JLabel("Noceng");
		lblNoceng.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblNoceng.setBounds(0, 216, 145, 36);
		panel.add(lblNoceng);
		lblNoceng.setOpaque(true);
		lblNoceng.setForeground(new Color(255, 255, 0));
		lblNoceng.setBackground(new Color(0, 0, 128));
		lblNoceng.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCetiaw = new JLabel("Cetiaw");
		lblCetiaw.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblCetiaw.setBounds(0, 0, 145, 36);
		panel.add(lblCetiaw);
		lblCetiaw.setOpaque(true);
		lblCetiaw.setFocusCycleRoot(true);
		lblCetiaw.setForeground(new Color(255, 255, 0));
		lblCetiaw.setBackground(new Color(0, 0, 128));
		lblCetiaw.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCeceng = new JLabel("Ceceng");
		lblCeceng.setFont(new Font("MV Boli", Font.BOLD, 17));
		lblCeceng.setForeground(new Color(255, 255, 0));
		lblCeceng.setBounds(0, 252, 145, 36);
		panel.add(lblCeceng);
		lblCeceng.setBackground(new Color(0, 0, 128));
		lblCeceng.setOpaque(true);
		lblCeceng.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnJwb1.setBackground(null);
		btnJwb2.setBackground(null);         
		btnJwb3.setBackground(null);
		btnJwb4.setBackground(null);
		
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		label.setText(Soal[0]);
		btnJwb1.setText(J1[0]);
		btnJwb2.setText(J2[0]);
		btnJwb3.setText(J3[0]);
		btnJwb4.setText(J4[0]);
		
		JButton btnNewButton = new JButton(new ImageIcon("C:/Users/eg06/Desktop/Classic5050.png"));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnJwb1.getText() .equals(Jb[level-1])){
					fifty = 1;
				}
				else if(btnJwb2.getText() .equals(Jb[level-1])){
					fifty = 2;
				}
				else if(btnJwb3.getText() .equals(Jb[level-1])){
					fifty = 3;
				}
				else if(btnJwb4.getText() .equals(Jb[level-1])){
					fifty = 4;
				}
				Random rand1 = new Random();
				rand = rand1.nextInt(4)+1;

				while(rand == fifty){
					Random rand2 = new Random();
					rand = rand2.nextInt(4)+1;
				}
				if(rand == 1){
					btnJwb1.setText("");
					btnJwb1.setEnabled(false);
				}
				else if(rand == 2){
					btnJwb2.setText("");
					btnJwb2.setEnabled(false);
				}
				else if(rand == 3){
					btnJwb3.setText("");
					btnJwb3.setEnabled(false);
				}
				else if(rand == 4){
					btnJwb4.setText("");
					btnJwb4.setEnabled(false);
				}
				
				Random rand4 = new Random();
				randd = rand4.nextInt(4) + 1;
				
				while(randd == fifty || randd == rand ){
					Random rand5 = new Random();
					randd = rand5.nextInt(4) + 1;
				}
				if(randd == 1){
					btnJwb1.setText("");
					btnJwb1.setEnabled(false);
				}
				else if(randd == 2){
					btnJwb2.setText("");
					btnJwb2.setEnabled(false);
				}
				else if(randd == 3){
					btnJwb3.setText("");
					btnJwb3.setEnabled(false);
				}
				else if(randd == 4){
					btnJwb4.setText("");
					btnJwb4.setEnabled(false);
				}
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setBounds(430, 2, 46, 41);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton(new ImageIcon("C:/Users/eg06/Desktop/ClassicPAF.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			JOptionPane.showMessageDialog(null, Jb[level-1]);	
			button.setEnabled(false);
				
			}
		});
		button.setBounds(529, 2, 46, 41);
		contentPane.add(button);
		
		JButton button_1 = new JButton(new ImageIcon("C:/Users/eg06/Desktop/atd.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ata1 = 0;
				int ata2 = 0;
				int ata3 = 0;
				int ata4 = 0;
				if(btnJwb1.getText() .equals(Jb[level-1])){
					ata1 = 100;
				}
				else if(btnJwb2.getText() .equals(Jb[level-1])){
					ata2 = 100;
				}
				else if(btnJwb3.getText() .equals(Jb[level-1])){
					ata3 = 100;
				}
				else if(btnJwb4.getText() .equals(Jb[level-1])){
					ata4 = 100;
				}
							
			JOptionPane.showMessageDialog(null, "A = " + ata1 + "%\n" + "B = " + ata2 + "%\n" + "C = " + ata3 + "%\n" + "D = " + ata4 + "%\n");	
			button_1.setEnabled(false);
			}
		});
		button_1.setBounds(479, 2, 46, 41);
		contentPane.add(button_1);
		
		JLabel lblSelamat = new JLabel("");
		lblSelamat.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSelamat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelamat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelamat.setBounds(12, 9, 403, 154);
		contentPane.add(lblSelamat);
		
		//nilai = "Nol";
		
		btnJwb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnJwb2.setEnabled(false);
				btnJwb3.setEnabled(false);
				btnJwb4.setEnabled(false);
					if(btnJwb1.getText() .equals(Jb[level-1])) {
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb1.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb1.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb1.setBackground(Color.orange);
								}
								
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb1.setBackground(Color.green);
								level = level + 1;
								
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if( level <= 11){
									if (level == 2) {
										lblCepe.setBackground(new Color(0, 0, 128));
										lblNope.setBackground(Color.magenta);
										nilai = "Cepe";
									}
									else if (level == 3) {
										lblNope.setBackground(new Color(0, 0, 128));
										lblGope.setBackground(Color.magenta);
										nilai = "Nope";
									}
									else if (level == 4) {
										lblGope.setBackground(new Color(0, 0, 128));
										lblCeceng.setBackground(Color.magenta);
										nilai = "Gope";
									}
									else if (level == 5) {
										lblCeceng.setBackground(new Color(0, 0, 128));
										lblNoceng.setBackground(Color.magenta);
										nilai = "Ceceng";
									}
									else if (level == 6) {
										lblNoceng.setBackground(new Color(0, 0, 128));
										lblGoceng.setBackground(Color.magenta);
										nilai = "Noceng";
									}
									else if (level == 7) {
										lblGoceng.setBackground(new Color(0, 0, 128));
										lblCeban.setBackground(Color.magenta);
										nilai = "Goceng";
									}
									else if (level == 8) {
										lblCeban.setBackground(new Color(0, 0, 128));
										lblGoban.setBackground(Color.magenta);
										nilai = "Ceban";
									}
									else if (level == 9) {
										lblGoban.setBackground(new Color(0, 0, 128));
										lblCepeceng.setBackground(Color.magenta);
										nilai = "Goban";
									}
									else if (level == 10) {
										lblCepeceng.setBackground(new Color(0, 0, 128));
										lblGopeceng.setBackground(Color.magenta);
										nilai = "Cepeceg";
									}
									else if (level == 11) {
										lblGopeceng.setBackground(new Color(0, 0, 128));
										lblCetiaw.setBackground(Color.magenta);
										nilai = "Gopeceng";
									}
									
									
									label.setText(Soal[level-1]);
									btnJwb1.setText(J1[level-1]);
									btnJwb2.setText(J2[level-1]);
									btnJwb3.setText(J3[level-1]);
									btnJwb4.setText(J4[level-1]);
									
									btnJwb1.setBackground(null);
									btnJwb3.setEnabled(true);
									btnJwb2.setEnabled(true);
									btnJwb4.setEnabled(true);
								}
								
								if (level == 12) {
									nilai = "Cetiaw";
									lblSelamat.setText("SELAMAT ANDA MENJADI MILLONAIRE!!!");
									
									for (int i = 0; i < 10; i++) {
										lblSelamat.setForeground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setForeground(Color.green);
										lblCetiaw.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setBackground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									frmHighscore formHS = new frmHighscore();
									formHS.setVisible(true);
									setVisible(false);
								}
							}
						});
						t.start();
						
					}
					else {
						if(level > 1){
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb1.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb1.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb1.setBackground(Color.orange);
								}
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb1.setBackground(Color.red);
								
								try {
									TimeUnit.MILLISECONDS.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								lblSelamat.setText("GAME OVER");
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								frmHighscore formHS = new frmHighscore();
								formHS.setVisible(true);
								setVisible(false);
							}
						});
						t.start();
						}
						if(level == 1){
							Thread t = new Thread(new Runnable() {
								public void run() {
									for (int i = 0; i < 5; i++) {
										btnJwb1.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb1.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb1.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb1.setBackground(Color.red);
									
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									lblSelamat.setText("GAME OVER");
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									main formMain = new main();
									formMain.setVisible(true);
									setVisible(false);
								}
							});
							t.start();
							}
					}
					
			}
		});
		
		btnJwb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnJwb1.setEnabled(false);
				btnJwb3.setEnabled(false);
				btnJwb4.setEnabled(false);
				
					if(btnJwb2.getText() .equals(Jb[level-1])) {
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb2.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb2.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb2.setBackground(Color.orange);
								}
								
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb2.setBackground(Color.green);
								level = level + 1;
								
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if( level <= 11){
									if (level == 2) {
										lblCepe.setBackground(new Color(0, 0, 128));
										lblNope.setBackground(Color.magenta);
										nilai = "Cepe";
									}
									else if (level == 3) {
										lblNope.setBackground(new Color(0, 0, 128));
										lblGope.setBackground(Color.magenta);
										nilai = "Nope";
									}
									else if (level == 4) {
										lblGope.setBackground(new Color(0, 0, 128));
										lblCeceng.setBackground(Color.magenta);
										nilai = "Gope";
									}
									else if (level == 5) {
										lblCeceng.setBackground(new Color(0, 0, 128));
										lblNoceng.setBackground(Color.magenta);
										nilai = "Ceceng";
									}
									else if (level == 6) {
										lblNoceng.setBackground(new Color(0, 0, 128));
										lblGoceng.setBackground(Color.magenta);
										nilai = "Noceng";
									}
									else if (level == 7) {
										lblGoceng.setBackground(new Color(0, 0, 128));
										lblCeban.setBackground(Color.magenta);
										nilai = "Goceng";
									}
									else if (level == 8) {
										lblCeban.setBackground(new Color(0, 0, 128));
										lblGoban.setBackground(Color.magenta);
										nilai = "Ceban";
									}
									else if (level == 9) {
										lblGoban.setBackground(new Color(0, 0, 128));
										lblCepeceng.setBackground(Color.magenta);
										nilai = "Goban";
									}
									else if (level == 10) {
										lblCepeceng.setBackground(new Color(0, 0, 128));
										lblGopeceng.setBackground(Color.magenta);
										nilai = "Cepeceg";
									}
									else if (level == 11) {
										lblGopeceng.setBackground(new Color(0, 0, 128));
										lblCetiaw.setBackground(Color.magenta);
										nilai = "Gopeceng";
									}
									
									
									label.setText(Soal[level-1]);
									btnJwb1.setText(J1[level-1]);
									btnJwb2.setText(J2[level-1]);
									btnJwb3.setText(J3[level-1]);
									btnJwb4.setText(J4[level-1]);
									
									btnJwb2.setBackground(null);
									btnJwb1.setEnabled(true);
									btnJwb3.setEnabled(true);
									btnJwb4.setEnabled(true);
								}
								
								if (level == 12) {
									nilai = "Cetiaw";
									lblSelamat.setText("SELAMAT ANDA MENJADI MILLONAIRE!!!");
									
									for (int i = 0; i < 10; i++) {
										lblSelamat.setForeground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setForeground(Color.green);
										lblCetiaw.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setBackground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									frmHighscore formHS = new frmHighscore();
									formHS.setVisible(true);
									setVisible(false);
								}
							}
						});
						t.start();
					}
					else {
						if(level > 1){
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb2.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb2.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb2.setBackground(Color.orange);
								}
										
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb2.setBackground(Color.red);
					
								try {
									TimeUnit.MILLISECONDS.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								lblSelamat.setText("GAME OVER");
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								frmHighscore formHS = new frmHighscore();
								formHS.setVisible(true);
								setVisible(false);
							}
						});
						t.start();
						}
						if(level == 1){
							Thread t = new Thread(new Runnable() {
								public void run() {
									for (int i = 0; i < 5; i++) {
										btnJwb2.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb2.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb2.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb2.setBackground(Color.red);
									
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									lblSelamat.setText("GAME OVER");
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									main formMain = new main();
									formMain.setVisible(true);
									setVisible(false);
								}
							});
							t.start();
							}
					}
			}
		});
		
		btnJwb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnJwb1.setEnabled(false);
				btnJwb2.setEnabled(false);
				btnJwb4.setEnabled(false);
				
					if(btnJwb3.getText() .equals(Jb[level-1])) {
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb3.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb3.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb3.setBackground(Color.orange);
								}
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb3.setBackground(Color.green);
								level = level + 1;
								
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if( level <= 11){
									if (level == 2) {
										lblCepe.setBackground(new Color(0, 0, 128));
										lblNope.setBackground(Color.magenta);
										nilai = "Cepe";
									}
									else if (level == 3) {
										lblNope.setBackground(new Color(0, 0, 128));
										lblGope.setBackground(Color.magenta);
										nilai = "Nope";
									}
									else if (level == 4) {
										lblGope.setBackground(new Color(0, 0, 128));
										lblCeceng.setBackground(Color.magenta);
										nilai = "Gope";
									}
									else if (level == 5) {
										lblCeceng.setBackground(new Color(0, 0, 128));
										lblNoceng.setBackground(Color.magenta);
										nilai = "Ceceng";
									}
									else if (level == 6) {
										lblNoceng.setBackground(new Color(0, 0, 128));
										lblGoceng.setBackground(Color.magenta);
										nilai = "Noceng";
									}
									else if (level == 7) {
										lblGoceng.setBackground(new Color(0, 0, 128));
										lblCeban.setBackground(Color.magenta);
										nilai = "Goceng";
									}
									else if (level == 8) {
										lblCeban.setBackground(new Color(0, 0, 128));
										lblGoban.setBackground(Color.magenta);
										nilai = "Ceban";
									}
									else if (level == 9) {
										lblGoban.setBackground(new Color(0, 0, 128));
										lblCepeceng.setBackground(Color.magenta);
										nilai = "Goban";
									}
									else if (level == 10) {
										lblCepeceng.setBackground(new Color(0, 0, 128));
										lblGopeceng.setBackground(Color.magenta);
										nilai = "Cepeceg";
									}
									else if (level == 11) {
										lblGopeceng.setBackground(new Color(0, 0, 128));
										lblCetiaw.setBackground(Color.magenta);
										nilai = "Gopeceng";
									}	
									
									label.setText(Soal[level-1]);
									btnJwb1.setText(J1[level-1]);
									btnJwb2.setText(J2[level-1]);
									btnJwb3.setText(J3[level-1]);
									btnJwb4.setText(J4[level-1]);
									
									btnJwb3.setBackground(null);
									btnJwb1.setEnabled(true);
									btnJwb2.setEnabled(true);
									btnJwb4.setEnabled(true);
								}
								
								if (level == 12) {
									nilai = "Cetiaw";
									lblSelamat.setText("SELAMAT ANDA MENJADI MILLONAIRE!!!");
									
									for (int i = 0; i < 10; i++) {
										lblSelamat.setForeground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setForeground(Color.green);
										lblCetiaw.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setBackground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									frmHighscore formHS = new frmHighscore();
									formHS.setVisible(true);
									setVisible(false);
								}
							}
						});
						t.start();
					}
					else {
						if(level > 1){
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb3.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb3.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb3.setBackground(Color.orange);
								}
	
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb3.setBackground(Color.red);
								
								try {
									TimeUnit.MILLISECONDS.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								lblSelamat.setText("GAME OVER");
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								frmHighscore formHS = new frmHighscore();
								formHS.setVisible(true);
								setVisible(false);
							}
						});
						t.start();
						}
						if(level == 1){
							Thread t = new Thread(new Runnable() {
								public void run() {
									for (int i = 0; i < 5; i++) {
										btnJwb3.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb3.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb3.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb3.setBackground(Color.red);
									
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									lblSelamat.setText("GAME OVER");
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									main formMain = new main();
									formMain.setVisible(true);
									setVisible(false);
								}
							});
							t.start();
							}
					}
			}
		});
		
		btnJwb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnJwb1.setEnabled(false);
				btnJwb2.setEnabled(false);
				btnJwb3.setEnabled(false);
				
				if(btnJwb4.getText() .equals(Jb[level-1])) {
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb4.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb4.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb4.setBackground(Color.orange);
								}
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb4.setBackground(Color.green);
								level = level + 1;
								
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								if( level <= 11){
									if (level == 2) {
										lblCepe.setBackground(new Color(0, 0, 128));
										lblNope.setBackground(Color.magenta);
										nilai = "Cepe";
									}
									else if (level == 3) {
										lblNope.setBackground(new Color(0, 0, 128));
										lblGope.setBackground(Color.magenta);
										nilai = "Nope";
									}
									else if (level == 4) {
										lblGope.setBackground(new Color(0, 0, 128));
										lblCeceng.setBackground(Color.magenta);
										nilai = "Gope";
									}
									else if (level == 5) {
										lblCeceng.setBackground(new Color(0, 0, 128));
										lblNoceng.setBackground(Color.magenta);
										nilai = "Ceceng";
									}
									else if (level == 6) {
										lblNoceng.setBackground(new Color(0, 0, 128));
										lblGoceng.setBackground(Color.magenta);
										nilai = "Noceng";
									}
									else if (level == 7) {
										lblGoceng.setBackground(new Color(0, 0, 128));
										lblCeban.setBackground(Color.magenta);
										nilai = "Goceng";
									}
									else if (level == 8) {
										lblCeban.setBackground(new Color(0, 0, 128));
										lblGoban.setBackground(Color.magenta);
										nilai = "Ceban";
									}
									else if (level == 9) {
										lblGoban.setBackground(new Color(0, 0, 128));
										lblCepeceng.setBackground(Color.magenta);
										nilai = "Goban";
									}
									else if (level == 10) {
										lblCepeceng.setBackground(new Color(0, 0, 128));
										lblGopeceng.setBackground(Color.magenta);
										nilai = "Cepeceg";
									}
									else if (level == 11) {
										lblGopeceng.setBackground(new Color(0, 0, 128));
										lblCetiaw.setBackground(Color.magenta);
										nilai = "Gopeceng";
									}	
									
									label.setText(Soal[level-1]);
									btnJwb1.setText(J1[level-1]);
									btnJwb2.setText(J2[level-1]);
									btnJwb3.setText(J3[level-1]);
									btnJwb4.setText(J4[level-1]);
									
									btnJwb4.setBackground(null);
									btnJwb1.setEnabled(true);
									btnJwb2.setEnabled(true);
									btnJwb3.setEnabled(true);
								}
								
								if (level == 12) {
									nilai = "Cetiaw";
									lblSelamat.setText("SELAMAT ANDA MENJADI MILLONAIRE!!!");
									
									for (int i = 0; i < 10; i++) {
										lblSelamat.setForeground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setForeground(Color.green);
										lblCetiaw.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										lblSelamat.setBackground(Color.orange);
										lblCetiaw.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(1);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									frmHighscore formHS = new frmHighscore();
									formHS.setVisible(true);
									setVisible(false);
								}
							}
						});
						t.start();
						
					}
					else {
						if(level > 1){
						Thread t = new Thread(new Runnable() {
							public void run() {
								for (int i = 0; i < 5; i++) {
									btnJwb4.setBackground(Color.orange);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb4.setBackground(Color.green);
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb4.setBackground(Color.orange);
								}
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								btnJwb4.setBackground(Color.red);
								
								try {
									TimeUnit.MILLISECONDS.sleep(250);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								lblSelamat.setText("GAME OVER");
								
								try {
									TimeUnit.SECONDS.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								frmHighscore formHS = new frmHighscore();
								formHS.setVisible(true);
								setVisible(false);
							}
						});
						t.start();
						}
						if(level == 1){
							Thread t = new Thread(new Runnable() {
								public void run() {
									for (int i = 0; i < 5; i++) {
										btnJwb4.setBackground(Color.orange);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb4.setBackground(Color.green);
										try {
											TimeUnit.MILLISECONDS.sleep(250);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										btnJwb4.setBackground(Color.orange);
									}
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									btnJwb4.setBackground(Color.red);
									
									try {
										TimeUnit.MILLISECONDS.sleep(250);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									lblSelamat.setText("GAME OVER");
									
									try {
										TimeUnit.SECONDS.sleep(2);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
									main formMain = new main();
									formMain.setVisible(true);
									setVisible(false);
								}
							});
							t.start();
							}
					}
			}
		});
		
		if (level == 1) {
			lblCepe.setBackground(Color.magenta);
		}
		
	}
}
