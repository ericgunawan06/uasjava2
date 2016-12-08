package tanyakjawab;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.io.*;

public class inputdatabase extends JFrame{
	private static final int PORT = 9090;
	static int []r=new int [100];
	JTable table = null;
    public inputdatabase(){
        setTitle("Input database");
        setSize(1500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel(new GridLayout(7,2));
        JPanel panel2 = new JPanel(new GridLayout());
        JPanel panel4 = new JPanel (new GridLayout(1,3));
        JLabel soal = new JLabel("Pertanyaan");
        JLabel j1 = new JLabel("Jawaban 1");
        JLabel j2 = new JLabel("Jawaban 2");
        JLabel j3 = new JLabel("Jawaban 3");
        JLabel j4 = new JLabel("Jawaban 4");
        JLabel jb = new JLabel("Jawaban Benar");	
        JLabel no = new JLabel("Nomor(Untuk Delete dan Update)");
        JButton insert = new JButton("Insert");
        JButton delete = new JButton("Delete");
        JButton update = new JButton ("Update");
        JTextField soal1= new JTextField();
        JTextField j11= new JTextField();
        JTextField j21= new JTextField();
        JTextField j31= new JTextField();
        JTextField j41= new JTextField();
        JTextField jb1= new JTextField();
        JTextField no1 = new JTextField();
        Vector<Vector<Object>> data = null;
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("No");
        columnNames.add("Pertanyaan");
        columnNames.add("Jawaban 1");
        columnNames.add("Jawaban 2");
        columnNames.add("Jawaban 3");
        columnNames.add("Jawaban 4");
        columnNames.add("Jawaban Benar");

        try {
            database db = new database();
            data = db.selectInventori();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        panel2.add(scrollPane, BorderLayout.CENTER);
        panel2.setBorder(BorderFactory.createTitledBorder("Database"));
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        panel1.add(no);
        panel1.add(no1);
        panel1.add(soal);
        panel1.add(soal1);
        panel1.add(j1);
        panel1.add(j11);
        panel1.add(j2);
        panel1.add(j21);
        panel1.add(j3);
        panel1.add(j31);
        panel1.add(j4);
        panel1.add(j41);
        panel1.add(jb);
        panel1.add(jb1);
        panel4.add(insert);
        panel4.add(delete);
        panel4.add(update);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createTitledBorder("Input"));
        panel4.setBorder(BorderFactory.createTitledBorder("Button"));
        add(panel1);
        add(panel4);
        add(panel2);

        
        insert.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            	if (soal1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Pertanyaan tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j11.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 1 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j21.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 2 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j31.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 3 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j41.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 4 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (jb1.getText().equals("") || !jb1.getText().equals(j11.getText()) && !jb1.getText().equals(j21.getText()) && !jb1.getText().equals(j31.getText()) & !jb1.getText().equals(j41.getText())){
                    JOptionPane.showMessageDialog(null, "Jawaban Benar tidak dapat kosong atau Tidak Sama Dengan Jawaban 1,2,3,4", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else {try {
                        database db = new database();
                            db.insertSoal(soal1.getText(), j11.getText(), j21.getText(), j31.getText(), j41.getText(), jb1.getText(), "0");
                            Vector<Vector<Object>> data = null;
                            Vector<Object> columnNames = new Vector<Object>();
                            columnNames.add("No");
                            columnNames.add("Pertanyaan");
                            columnNames.add("Jawaban 1");
                            columnNames.add("Jawaban 2");
                            columnNames.add("Jawaban 3");
                            columnNames.add("Jawaban 4");
                            columnNames.add("Jawaban Benar");

                            try {
                                data = db.selectInventori();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            // Create JTable and fill it with data
                            table = new JTable(data, columnNames);
                            JScrollPane scrollPane = new JScrollPane(table);
                            table.setFillsViewportHeight(true);
                            table.setEnabled(false);
                            panel2.removeAll();
                            panel2.add(scrollPane, BorderLayout.CENTER);
                            panel2.revalidate();
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                    soal1.setText("");
                    j11.setText("");
                    j21.setText("");
                    j31.setText("");
                    j41.setText("");
                    jb1.setText("");
                }
            
        }});
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (no1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nomor tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            	else
                try {
                    database db = new database();

                    db.deleteSoal(Integer.parseInt(no1.getText()));
                    Vector<Vector<Object>> data = null;
                    Vector<Object> columnNames = new Vector<Object>();
                    columnNames.add("No");
                    columnNames.add("Pertanyaan");
                    columnNames.add("Jawaban 1");
                    columnNames.add("Jawaban 2");
                    columnNames.add("Jawaban 3");
                    columnNames.add("Jawaban 4");
                    columnNames.add("Jawaban Benar");

                    try {
                        data = db.selectInventori();
                    }
                    catch (Exception ea) {
                        ea.printStackTrace();
                    }

                    // Create JTable and fill it with data
                    table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);
                    table.setFillsViewportHeight(true);
                    table.setEnabled(false);
                    panel2.removeAll();
                    panel2.add(scrollPane, BorderLayout.CENTER);
                    panel2.revalidate();
                }
                catch(Exception ef){
                    System.out.println(ef);
                }

                no1.setText("");
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (no1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nomor tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            else if (soal1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Pertanyaan tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j11.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 1 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j21.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 2 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j31.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 3 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (j41.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Jawaban 4 tidak dapat kosong", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else if (jb1.getText().equals("") || !jb1.getText().equals(j11.getText()) && !jb1.getText().equals(j21.getText()) && !jb1.getText().equals(j31.getText()) & !jb1.getText().equals(j41.getText())){
                    JOptionPane.showMessageDialog(null, "Jawaban Benar tidak dapat kosong atau Tidak Sama Dengan Jawaban 1,2,3,4", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    database db = new database();

                    db.updateSoal(Integer.parseInt(no1.getText()),soal1.getText(),j11.getText(),j21.getText(),j31.getText(),j41.getText(),jb1.getText());
                    Vector<Vector<Object>> data = null;
                    Vector<Object> columnNames = new Vector<Object>();
                    columnNames.add("No");
                    columnNames.add("Pertanyaan");
                    columnNames.add("Jawaban 1");
                    columnNames.add("Jawaban 2");
                    columnNames.add("Jawaban 3");
                    columnNames.add("Jawaban 4");
                    columnNames.add("Jawaban Benar");

                    try {
                        data = db.selectInventori();
                    }
                    catch (Exception ea) {
                        ea.printStackTrace();
                    }

                    // Create JTable and fill it with data
                    table = new JTable(data, columnNames);
                    JScrollPane scrollPane = new JScrollPane(table);
                    table.setFillsViewportHeight(true);
                    table.setEnabled(false);
                    panel2.removeAll();
                    panel2.add(scrollPane, BorderLayout.CENTER);
                    panel2.revalidate();
                }
                catch(Exception ef){
                    System.out.println(ef);
                }

                no1.setText("");
                soal1.setText("");
                j11.setText("");
                j21.setText("");
                j31.setText("");
                j41.setText("");
                jb1.setText("");
            }
        });
        setVisible(true);
    }


public static void main(String[] args) throws IOException{
	
    new inputdatabase();
    System.out.println("The server is running on port " + PORT);
	ServerSocket listener = new ServerSocket(PORT);
	try{
		while(true){
			Socket s = listener.accept();
			Thread t = new Reversal(s);
			t.start();
		}
	}
	finally{
		listener.close();
	}
}
}

class Reversal extends Thread{
	private Socket socket;
	private String client;
	
	Reversal(Socket s){
		socket = s;
		client = s.getRemoteSocketAddress().toString();
		System.out.println("Incoming connection from " + client);
	}
	public void run(){
		try{
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()
							)
					);
			PrintWriter out = new PrintWriter(
					socket.getOutputStream(),
					true
					);
			database db = null;
			try {
				db = new database();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Vector data = null;
			 try {
	                data = db.selectnomor();
	            }
	            catch (Exception e) {
	            	
	                e.printStackTrace();
	            }
	            int[] random = new int[11];
	            String[] no_quest = new String[11];

	            for (int i=0; i < 11; i++){
	                int randomNum = 1 + (int)(Math.random() * ((data.size() - 1) + 1));
	                random[i] = randomNum;
	                no_quest[i] = data.get(random[i]-1).toString();
	            }
	            int[] no_q = new int[11];

	            for(int i = 0; i < 11; i++) {
	                no_q[i] = Integer.parseInt(no_quest[i]);
	                
	            }
	            String[] question = new String[11];
	            String[] j1 = new String[11];
	            String[] j2 = new String[11];
	            String[] j3 = new String[11];
	            String[] j4 = new String[11];
	            String[] jb = new String[11];

	            for(int i = 0; i < 11; i++){
	                question[i] = db.getSoal(no_q[i]);
	                j1[i] = db.getJ1(no_q[i]);
	                j2[i] = db.getJ2(no_q[i]);
	                j3[i] = db.getJ3(no_q[i]);
	                j4[i] = db.getJ4(no_q[i]);
	                jb[i] = db.getJb(no_q[i]);

	            }
	            for (int i = 0; i < 11; i++) {
	            	out.println(question[i]);
	                out.println(j1[i]);
	                out.println(j2[i]);
	                out.println(j3[i]);
	                out.println(j4[i]);
	                out.println(jb[i]);
				}
	           
			while(true){
				database dbd = new database();
				 String response;
					response = in.readLine();
					String name = response;
					response = in.readLine();
					String nilai = response;
					dbd.insertHighscore(name, nilai);
				 break;
			}
		}
		catch(IOException e){
			System.out.println("Error" + client + ": "+ e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		finally{
			try{
				socket.close();
			}
			catch (IOException e){
				e.printStackTrace();
			}
			System.out.println("Close connection from " + client);
		}
	}
		
}