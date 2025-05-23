
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Contact_Model {
	
	String url = "jdbc:mysql://localhost:3306/CONTACT_MANAGEMENT?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	String user = "root";
	String password = "password"; 
	public Connection connect() throws SQLException {
	    return DriverManager.getConnection(url, user, password);
	}

	public void addContact(String name, String contact, String email) {
		String sql = "INSERT INTO CONTACT(NAME,PHONE,EMAIL)VALUES(?,?,?)";
		try(Connection con  = connect();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, contact);
			ps.setString(3, email);
			int res = ps.executeUpdate();
			if(res!=0) {
			System.out.println("\n====Contact Added Sucessfully ====\n");
			}
			
		}catch(Exception e) {
			System.out.println("Contact is Not Added");
			System.out.println("\n");
			System.out.println("Plase Enter the Correct Information");
            System.out.println("Data your are giving is not valid for adding the contact number ");
			
		}
		
	}
	
	

	


	public void updateContact(int uid, String newName, String newNumber, String newEmail) {
		String q = "UPDATE CONTACT SET ID=?,NAME=?,PHONE=?,EMAIL=? WHERE ID=?";
		try(Connection con = connect();
				PreparedStatement ps = con.prepareStatement(q)){
				ps.setInt(1, uid);
				ps.setString(2,newName);
				ps.setString(3, newNumber);
				ps.setString(4, newEmail);
				ps.setInt(5, uid);
				int res = ps.executeUpdate();
				if(res>0) {
					System.out.println("\n====Contact Updated Successfully====\n");
				}
				else {
					System.out.println("Contact cannot be found for updation");
				}
				
		}catch(Exception e) {
			System.out.println("Contact Not Updated");
			System.out.println("Some information is not valid for updating");
			System.out.println("\n");

			
		}
	}

	public void deleteContact(int did) {
		String sql = "DELETE FROM CONTACT WHERE ID=?";
		try(Connection cn = connect();
				PreparedStatement ps = cn.prepareStatement(sql)){
				ps.setInt(1, did);
				int re = ps.executeUpdate();
				if(re>0) {
					System.out.println("\n====Contact Deleted Successfully====\n");
				}else {
					System.out.println("Contact is Not Deleted");
				}
				
	}catch(Exception e) {
		
		System.out.println("Contact is Not Deleted");
		System.out.println("\n");
		System.out.println("Enter the correct ID or data provided is not valid");
      
	}
	
}

	public ArrayList<Contact> getContact() {
		 ArrayList<Contact> list = new ArrayList<>();
		    String sql = "SELECT * FROM CONTACT";
		    try (Connection conn = connect(); 
		         Statement stmt = conn.createStatement(); 
		         ResultSet rs = stmt.executeQuery(sql)) {
		        
		        while (rs.next()) {
		            Contact c = new Contact(
		                rs.getInt("id"),
		                rs.getString("name"),
		                rs.getString("phone"),
		                rs.getString("email")
		            );
		            list.add(c);
		        }
		    } catch (SQLException e) {
		    	System.out.println("Error Occured...");
		    	System.out.println("Coudn't able to fech the contacts from database");
		        System.out.println("Error in getAllContacts(): " + e.getMessage());
		    	System.out.println("\n");

		    }
		    return list;
		}
	}

