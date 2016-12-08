package tanyakjawab;

import java.util.Vector;
import java.sql.*;
import javax.swing.*;

public class database {
	private Connection conn;
	public database()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/soal","root","");
    }
    public boolean isConnected(){
        return (conn !=null);
    }
    
	public Vector<Vector<Object>> selectInventori() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM soal1mil");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // return the resultset as Vector
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getString("number"));
            v.add(rs.getString("pertanyaan"));
            v.add(rs.getString("jawaban1"));
            v.add(rs.getString("jawaban2"));
            v.add(rs.getString("jawaban3"));
            v.add(rs.getString("jawaban4"));
            v.add(rs.getString("jawabbenar"));
            v.add(rs.getString("done"));
            data.add(v);
        }
        return data;
    }
	public Vector<Vector<Object>> selectHighscore() throws SQLException {
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM highscore");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>(); // return the resultset as Vector
        while (rs.next()) {
            Vector<Object> v = new Vector<Object>();
            v.add(rs.getInt("no"));
            v.add(rs.getString("nama_player"));
            v.add(rs.getString("score"));
            data.add(v);
        }
        return data;
    }
	
	public void insertSoal(
            String pertanyaan,
            String jawaban1,
            String jawaban2,
            String jawaban3,
            String jawaban4,
            String jawabbenar,
            String done
    ) throws Exception{
        String query = "INSERT INTO soal1mil(pertanyaan, jawaban1, jawaban2,jawaban3,jawaban4,jawabbenar,done) VALUES(?, ?, ?, ?, ?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, pertanyaan);
        stmt.setString(2, jawaban1);
        stmt.setString(3, jawaban2);
        stmt.setString(4, jawaban3);
        stmt.setString(5, jawaban4);
        stmt.setString(6, jawabbenar);
        stmt.setString(7, done);
        stmt.execute();
        stmt.close();
    }
	public void deleteSoal(
            int no
    )throws Exception{
        String query = "DELETE from soal1mil WHERE number = ?";
        PreparedStatement a;
        a = conn.prepareStatement(query);
        a.setInt(1, no);
        a.executeUpdate();
        
    
    }
	
	public String getSoal (int number)throws SQLException {
		String soal = "";
		String query = "SELECT pertanyaan FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			soal = rs.getString("pertanyaan");
		}
		return soal;
	}

	public String getJ1 (int number)throws SQLException {
		String j1 = "";
		String query = "SELECT jawaban1 FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			j1 = rs.getString("jawaban1");
		}
		return j1;
	}
	
	public String getJ2 (int number)throws SQLException {
		String j2 = "";
		String query = "SELECT jawaban2 FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			j2 = rs.getString("jawaban2");
		}
		return j2;
	}
	
	public String getJ3 (int number)throws SQLException {
		String j3 = "";
		String query = "SELECT jawaban3 FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			j3 = rs.getString("jawaban3");
		}
		return j3;
	}
	
	public String getJ4 (int number)throws SQLException {
		String j4 = "";
		String query = "SELECT jawaban4 FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			j4 = rs.getString("jawaban4");
		}
		return j4;
	}
	
	public String getJb (int number)throws SQLException {
		String jb = "";
		String query = "SELECT jawabbenar FROM soal1mil WHERE number = ?";
		PreparedStatement pst = this.conn.prepareStatement(query);
		pst.setInt(1, number);
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			jb = rs.getString("jawabbenar");
		}
		return jb;
	}
	
	   public Vector selectnomor() throws SQLException {
	        Statement stmt = this.conn.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT number FROM soal1mil");

	        Vector data = new Vector(); // return the resultset as Vector
	        while (rs.next()) {
	            data.add(rs.getInt("number"));
	        }
	        return data;
	    }
	   
	   public void updateSoal(
			   int no,
			   String pertanyaan,
	            String jawaban1,
	            String jawaban2,
	            String jawaban3,
	            String jawaban4,
	            String jawabbenar
	    )throws Exception{
	        String query = "UPDATE soal1mil SET  pertanyaan = ?, jawaban1 = ?, jawaban2 = ? , jawaban3 = ?, jawaban4 = ?, jawabbenar = ? WHERE number = ?";
	        PreparedStatement a;
	        a = conn.prepareStatement(query);
	        a.setString(1, pertanyaan);
	        a.setString(2, jawaban1);
	        a.setString(3, jawaban2);
	        a.setString(4, jawaban3);
	        a.setString(5, jawaban4);
	        a.setString(6, jawabbenar);
	        a.setInt(7, no);
	        a.executeUpdate();
	    }
	   public void insertHighscore(
	            String nama,
	            String nilai
	    ) throws Exception{
	        String query = "INSERT INTO highscore(nama_player, score) VALUES(?, ?)";
	        PreparedStatement stmt = conn.prepareStatement(query);
	        stmt.setString(1, nama);
	        stmt.setString(2, nilai);
	        stmt.execute();
	        stmt.close();
	    }
}
