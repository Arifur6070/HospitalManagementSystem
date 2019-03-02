import java.sql.*;
import java.util.Vector;
public class Database {



  Connection conn;
  
  String JDBC_DRIVER;  
  String DB_URL;
  Statement stmt;
  String USER;
  String PASS;
  Database(){
      JDBC_DRIVER = "com.mysql.jdbc.Driver";  
      DB_URL = "jdbc:mysql://localhost:3306/hospitalmanagement";
      USER = "root";
      PASS = "";
      
      try{
          Class.forName("com.mysql.jdbc.Driver");
          conn = DriverManager.getConnection(DB_URL,USER,PASS);
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
  }
 
  public boolean pass(String u,String p)
  {
	  String query;
	  boolean login=false;
	  
	  try {
		  query="SELECT username,password from admin";
		  stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(query);
          while(rs.next()){
              
               String name = rs.getString("username");
               String pass = rs.getString("password");
               if(name.equals(u) && pass.equals(p))
               {
            	   login=true;
               } 
          }
          
          rs.close();
          stmt.close();
		  
	  } 
	  catch (Exception ex)
	  {
		  ex.printStackTrace();
		  }
	  return login;
	  
  }
  
  
  public Vector<Vector<String>> getpatientlist()
	{
		try
		{
			stmt = conn.createStatement();
			String sql = "SELECT * FROM patient";
			ResultSet rs = stmt.executeQuery(sql);
			Vector<Vector<String>> patient_list = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> p_list = new Vector<String>();
				p_list.add(rs.getString("cabin_no"));
				p_list.add(rs.getString("p_name"));
				p_list.add(rs.getString("price"));
				p_list.add(rs.getString("phone_no"));
				p_list.add(rs.getString("date"));
				p_list.add(rs.getString("room_type"));
				
				patient_list.add(p_list);
			}
			return patient_list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
  public Vector<Vector<String>> getcabinlist()
	{
		try
		{
			stmt = conn.createStatement();
			String sql = "SELECT * FROM cabin";
			ResultSet rs = stmt.executeQuery(sql);
			Vector<Vector<String>> cabin_list = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> c_list = new Vector<String>();
				c_list.add(rs.getString("cabin_no"));
				c_list.add(rs.getString("d_name"));
				c_list.add(rs.getString("type"));
				c_list.add(rs.getString("price"));
				cabin_list.add(c_list);
			}
			return cabin_list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
  
  public Vector<Vector<String>> getdoctorlist()
	{
		try
		{
			stmt = conn.createStatement();
			String sql = "SELECT * FROM doctor";
			ResultSet rs = stmt.executeQuery(sql);
			Vector<Vector<String>> doctor_list = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> d_list = new Vector<String>();
				d_list.add(rs.getString("d_name"));
				d_list.add(rs.getString("cabin_no"));
				d_list.add(rs.getString("phone_no"));
				d_list.add(rs.getString("address"));
				d_list.add(rs.getString("working_hour"));
				
				float hour=(rs.getFloat("working_hour"));
				float sal=(rs.getFloat("unit_salary"));
				sal = hour * sal;
				d_list.add(String.valueOf(sal));
				doctor_list.add(d_list);
			}
			return doctor_list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
public void insertToCabin(int cabin_no,String d_name, String type, String price){
      
      try{
    	  stmt = conn.createStatement();
    	  String sql = "INSERT INTO cabin ( cabin_no,d_name,type,price )" + "VALUES ('"+cabin_no+"','"+d_name+"','"+type+"','"+price+"')";
    	  stmt.execute(sql);
          
          stmt.close();
          conn.close();
          
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
     
  }

public void updateCabin(int cabin_no,String d_name, String type, String price){
	 
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "UPDATE cabin SET  d_name ='" + d_name +  "', type = '" + type +  "', price = '" + price + "' where cabin_no ='"+cabin_no+"'";
  	  stmt.execute(sql);
        
        stmt.close();
        conn.close();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

public void deleteCabin(int cabin_no){
	 
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "DELETE FROM cabin WHERE cabin_no ='"+cabin_no+"'";
  	  stmt.execute(sql);
        
        stmt.close();
        conn.close();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

public void insertToDoctor(String d_name,int cabin_no, String phone_no, String address,float working_hour, float unit_salary){
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "INSERT INTO doctor ( d_name,cabin_no,phone_no,address,working_hour,unit_salary )" + "VALUES ('"+d_name+"','"+cabin_no+"','"+phone_no+"','"+address+"','"+working_hour+"','"+unit_salary+"')";
  	  stmt.execute(sql);
      
  	  String sql1 = "INSERT INTO cabin ( cabin_no,d_name )" + "VALUES ('"+cabin_no+"','"+d_name+"')";
  	  stmt.execute(sql1);
      stmt.close();
        
        
        conn.close();
        
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
   
}
public void updateDoctor(String d_name,int cabin_no, String phone_no, String address,float working_hour, float unit_salary){
	 
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "UPDATE doctor SET  cabin_no ='" + cabin_no +  "', phone_no = '" + phone_no +  "', address = '" + address + "', working_hour = '" + working_hour +  "', unit_salary = '" + unit_salary +  "' where d_name ='"+d_name+"'";
  	  stmt.execute(sql);
        
  	  String sql1="Update cabin SET d_name ='" + d_name + "' where cabin_no ='"+cabin_no+"'";
  	  stmt.execute(sql1);
  	  stmt.close();
  	  conn.close();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

public void deleteDoctor(String d_name){
	 
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "DELETE FROM doctor WHERE d_name ='"+d_name+"'";
  	  stmt.execute(sql);
        
        stmt.close();
        conn.close();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}
 
public void insertToPatient(String p_name,int cabin_no, String phone_no, String date, String room_type, int price){
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "INSERT INTO patient ( p_name,cabin_no,phone_no,date,room_type,price )" + "VALUES ('"+p_name+"','"+cabin_no+"','"+phone_no+"','"+date+"','"+room_type+"','"+price+"')";
  	  stmt.execute(sql);
      
  	  //String sql1 = "INSERT INTO cabin ( cabin_no,d_name )" + "VALUES ('"+cabin_no+"','"+d_name+"')";
  	  //stmt.execute(sql1);
      stmt.close();
        
        
        conn.close();
        
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
   
}
  

public void deletePatient(String p_name,int cabin_no){
	 
    
    try{
  	  stmt = conn.createStatement();
  	  String sql = "DELETE FROM patient WHERE p_name ='"+p_name+"' AND cabin_no='"+cabin_no+"'";
  	  stmt.execute(sql);
        
        stmt.close();
        conn.close();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}
 


  public void updateDB(int room_no,String name, String phone_no, String address, String date_from, String date_to){
	 
      
      try{
    	  stmt = conn.createStatement();
    	  String sql = "UPDATE user_info SET name ='" + name +  "', phone_no ='" + phone_no +  "', address = '" + address +  "', date_from = '" + date_from +  "', date_to =  '" + date_to +  "' where room_no ='"+room_no+"'";
    	  stmt.execute(sql);
          
          stmt.close();
          conn.close();
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
  }
  
}

