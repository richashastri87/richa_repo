package compute;

import java.sql.Connection; //establish the connection
import java.sql.DriverManager; //register/load driver 
import java.sql.PreparedStatement; //prepare and run sql statement
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;




public class connectionEx
{

	public static void main(String[] args) throws SQLException 
	{
	    int id;
	    String lname , fname , address, city;
	    Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/database_1","root","root");
			
			PreparedStatement st = con.prepareStatement("insert into employee(eid,lastname,firstname,address,city) values (?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				System.out.println("enter 1 : Add \n 2 : Show \n 3 : Update \n  4 : Delete \n 5 : Show Detail as per ID \n 6: Exit ");
				int op = sc.nextInt();
				
				if(op==1)
				{
					System.out.println("Enter the Id");
					id = sc.nextInt();
					
					System.out.println("Enter the Last name");
					lname = sc.next();
					
					System.out.println("Enter the First name");
					fname = sc.next();
					
					System.out.println("Enter the Address");
					address = sc.next();
					
					System.out.println("Enter the City");
					city = sc.next();
			     
					//System.out.println("Values " + id + " , "  + lname + ", " +fname + ", " +address + " ," + city);
					st.setInt(1,id);
					st.setString(2,lname);
					st.setString(3,fname);
					st.setString(4,address);
					st.setString(5,city);
					st.executeUpdate();//insert,update, delete
					System.out.println("data is saved");
				}
				//show record		
				else if(op==2)
				{
					//read
					st = con.prepareStatement("select * from employee");
					ResultSet rs =st.executeQuery(); //select
			
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3) +"\t" +rs.getString(4) + "\t" +rs.getString(5));
					}
				}
				
				//update record
				else if(op ==3)
				{
					System.out.println("Enter the Id");
					id = sc.nextInt();
					
					System.out.println("Enter the name ,lastname , first name , address ,city for updation");
					
					
				    lname = sc.next();
				    fname = sc.next();
				    address =sc.next();
				    city = sc.next();
				    
				    st = con.prepareStatement("UPDATE employee SET lastname = ?, firstname = ?  address = ? city = ? WHERE id = ?");
				    
				    // set the preparedstatement parameters
				   
				    st.setString(1,lname);
				    st.setString(2,fname);
				    st.setString(3,address);
				    st.setString(4, city);
				    st.setInt(5, id);
				    
				    st.executeUpdate();
				}
			    
				//delete record
				else if(op == 4)
				{ 
					System.out.println("Enter the Id");
					 id = sc.nextInt();
					
					st = con.prepareStatement("DELETE FROM employee WHERE eid = ?");
				    st.setInt(1, id);
					
					st.executeUpdate();
					
				}
				//show particular record based on given id
				else if(op==5)
				{
					//read
					
					System.out.println("Enter the Id");
					id = sc.nextInt();
					 
					st = con.prepareStatement("select * from employee WHERE  eid = ?");
					st.setInt(1, id);
					
					ResultSet rs =st.executeQuery(); //select
			
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3) +"\t" +rs.getString(4) + "\t" +rs.getString(5));
					}
				}
				
				else 
				{
					System.out.println("User has entered wrong choice");
				}
				
			}
			
		}
		
		catch (Exception e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
        
		finally 
		{
			con.close();
		}
	}
}
