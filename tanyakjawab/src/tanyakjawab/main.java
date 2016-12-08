package tanyakjawab;


import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.border.LineBorder;


public class main extends JFrame {
	static String server;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static String ip(){
		return server;
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		server = JOptionPane.showInputDialog("Enter Server IP");
		try (Socket s = new Socket(server,9090)){
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
			for (int i=0; i<6;i++){
				response = in.readLine();
				System.out.println(response);
			}
			
			while(true){
				System.out.println(">> ");
				request = cin.readLine();
				out.println(request);
				
				response = in.readLine();
				if(response == null || response.equals(""))
					break;
				System.out.println(response);
			}
			System.out.print("Connection closed.");
		}
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Who Wants To Be A Millionaire");
		setForeground(new Color(0, 0, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 279);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhoWantsTo = new JLabel("WHO WANTS TO BE A MILLIONAIRE");
		lblWhoWantsTo.setForeground(Color.WHITE);
		lblWhoWantsTo.setBackground(new Color(0, 0, 128));
		lblWhoWantsTo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblWhoWantsTo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWhoWantsTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhoWantsTo.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblWhoWantsTo.setBounds(38, 11, 432, 49);
		contentPane.add(lblWhoWantsTo);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPlay.setBounds(196, 139, 109, 37);
		contentPane.add(btnPlay);
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPlay formPlay;
				try {
					formPlay = new frmPlay();
					formPlay.setVisible(true);
					setVisible(false);
				} catch (UnknownHostException e) {
				} catch (IOException e) {
				}
				
			}
		});
	}
}