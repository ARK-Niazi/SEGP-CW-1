

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseManager {

	
	private String connectionString;
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	//private ArrayList<String> studentCount
	public DataBaseManager() {
		// TODO Auto-generated constructor stub
	}
	private void createConnection() {
		try {
			connectionString = "jdbc:mysql://localhost/SEGP-1";
			conn = DriverManager.getConnection(connectionString, "root", "");
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[][] getDataList(String querry){
		ArrayList<String> list=new ArrayList<>();
		createConnection();
		try {
			rs=st.executeQuery(querry);
			while(rs.next()){
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getInt(4)+"");
				list.add(rs.getString(5));
				list.add(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [][] l=new String[list.size()/6][7];
		int count=0;
		for(int i=0;i<(list.size()/6);i++){
			for(int j=0;j<7;j++){
				if(j==0)
					l[i][j]=(i+1)+"";
				else{
					l[i][j]=list.get(count);
					count++;
				}
			}
		}
		return l;
	}
	public String[][] getPatList(String querry){
		ArrayList<String> list=new ArrayList<>();
		createConnection();
		try {
			rs=st.executeQuery(querry);
			String s = null;
			while(rs.next()){
				s=rs.getString(1);
				list.add(s);
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4)+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String [][] l=new String[list.size()/4][5];
		int count=0;
		for(int i=0;i<(list.size()/4);i++){
			for(int j=0;j<5;j++){
				if(j==0)
					l[i][j]=(i+1)+"";
				else{
					l[i][j]=list.get(count);
					count++;
				}
			}
		}
		return l;
	}
	public void updateStudent(String querry){
		createConnection();
		try {
			st.executeUpdate(querry);
			rs=st.executeQuery("select * from students");
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updatePat(String querry){
		createConnection();
		try {
			st.executeUpdate(querry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Boolean doesStudentAttributeExist(String querry,String attribute){
		createConnection();
		try {
			rs=st.executeQuery(querry);
			if(attribute.equals("id")){
				while(rs.next()){
					if(attribute.equals(rs.getInt(2)))
						return true;
				}
				return false;
			}
			if(attribute.equals("email")){
				while(rs.next()){
					if(attribute.equals(rs.getString(5)))
						return true;
				}
				return false;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public Boolean addPat(String name,String dep,String email,String load){
			createConnection();
			try {
				st.executeUpdate("insert into pats values('"+name+"','"+dep+"','"+email+"','"+load+"')");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//st.executeUpdate("insert into pats ")()
			return true;
	}
	public Boolean addStudent(String name,String id,String mail,String dep,String year){
		createConnection();
		try {
			st.executeUpdate("insert into students values('"+name+"',"+id+",'"+dep+"',"+year+",'"+mail+"','-')");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//st.executeUpdate("insert into pats ")()
		return true;
	}
	public int getSizeOfPat(String name){
		try {
			Statement m=conn.createStatement();
			ResultSet rs=m.executeQuery("select * from pats where name='"+name+"'");
			int n=0;
			while(rs.next()){
				n=rs.getInt(5);
			}
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public void delete(String q){
		createConnection();
		try {
			st.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
