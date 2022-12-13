import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCConnect {

	Statement statement= null;
	Scanner sc = new Scanner(System.in);
	int choice = 0,del_id = 0,up_id = 0,up_choice=0;
	String dynamic_set = null;

	public void getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeesDB", "root", "");
			statement = connection.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}	 
	}
	public void addCustomer() throws SQLException {

		System.out.println("Enter id");
		long id = sc.nextLong();

		System.out.println("Enter accno");
		long accNo = sc.nextLong();

		System.out.println("Enter balance");
		long accBalance = sc.nextLong();

		System.out.println("Enter name");
		String name = sc.next();


		String query = "insert into customer values("+id+ ","+accNo+ "," + accBalance + ",'"+ name+"')";

		statement.execute(query);

		boolean result =  getCustomerById(id);

		if(result == true) {
			System.out.println("customer added successfully!");
		}
		else {
			System.out.println("Failure in addition of the customer");
		}
	}
	public boolean getCustomerById(long id) throws SQLException {

		String query  = "select * from customer where id="+id;

		ResultSet rs= statement.executeQuery(query);

		return rs.next();

	}

    public void deleteCustomer() throws SQLException
    {
    	
    	System.out.println("Please Enter the Customer Id which you want to delete : ");
    	del_id = sc.nextInt();
    	boolean result =  getCustomerById(del_id);
    	if(result == false) {
			System.out.println("customer " +del_id +" doesnt exist!");
			return;
		}
    	String query  = "delete from customer where id="+del_id;
    	statement.execute(query);
          result =  getCustomerById(del_id);
    	if(result == false) {
			System.out.println("customer " +del_id +" Deleted successfully!");
			return;
		}
		else {
			System.out.println("Failure in deletion of the customer");
		}
    	
    }
    public void Display_table() throws SQLException
    {
    	String query  = "select * from customer";
		ResultSet rs= statement.executeQuery(query);
		System.out.println("All Customers Data");
		System.out.println("--------------------------------------------------");
        while(rs.next()) {
        	System.out.println(rs.getLong(1)+"\t"+rs.getLong(2)+"\t"+rs.getLong(3)+"\t"+rs.getString(4)+"\t");
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
    
    public void update_display() throws SQLException
    {
    	System.out.println("Please Enter the Customer Id which you want to update : ");
    	up_id = sc.nextInt();
    	boolean result =  getCustomerById(up_id);
    	if(result == false) {
			System.out.println("customer " +up_id +" doesn't exist!");
			return;
		}
    	System.out.println("Please Enter the choice that you want to update");
    	System.out.println("1.AccountNumber");
    	System.out.println("2.Balance");
    	System.out.println("3.Name");
    	System.out.println("4.Exit from Update Menu");
    	
    	up_choice = sc.nextInt();
    	
    	switch (up_choice) {
		case 1:
			System.out.println("please Enter Account Number that needs to be Updated");
			long accNo = sc.nextLong();
			dynamic_set = "accountNumber ="+accNo;
			break;
		case 2:
			System.out.println("please Enter Balance that needs to be Updated");
			long accBalance = sc.nextLong();
			dynamic_set = "balance ="+accBalance;
			break;
		case 3:
			System.out.println("please Enter Name that needs to be Updated");
			String name = sc.next();
			dynamic_set = "name ='"+name+"'";
			break;
		case 4:
			
			break;
		default:
			System.out.println("Please Enter Valid Entries");
			update_display();
			break;
		}
    	
    }
    public void updateCustomer() throws SQLException
    {
    	update_display();	
    	String query  = "Update customer set "+ dynamic_set +" where id="+up_id;
    	System.out.println(query);
    	statement.execute(query);
    	boolean result =  getCustomerById(up_id);
    	if(result == true) {
			System.out.println("customer " +up_id +" has been updated successfully!");
		}
		else {
			System.out.println("Failure in updating the customer");
		}
    	
    }

	public void Display(boolean d) throws SQLException
	{
		if(d)
		{
			System.out.println("******************JDBC CONNECTION******************");
			//System.out.println("***************************************************");
			System.out.println("**  1.Add Entry");
			System.out.println("**  2.Delete Entry");
			System.out.println("**  3.Table Information");
			System.out.println("**  4.Update Entry");
			System.out.println("**  5.Exit");
			System.out.println("***************************************************");
			System.out.println("Please Enter the Choice  :");
		}
		else
		{
			System.out.println("Please Enter the Valid values(1/2/3/4/5)");  
		}
		choice = sc.nextInt();
		select(choice);
	}

	public void select(int choice) throws SQLException
	{
		switch (choice) {
		case 1:
			System.out.println("*****************ADD ENTRY*******************");
			addCustomer();
			Display(true);
			break;
		case 2:
			System.out.println("*****************DELETE ENTRY****************");
			deleteCustomer();
			Display(true);
			break;
		case 3:
			System.out.println("*****************Table information****************");
			Display_table();
			Display(true);
			break;
		case 4:
			System.out.println("*****************UPDATE ENTRY****************");
			updateCustomer();
			Display(true);
			break;
		case 5:
			System.out.println("Exiting the Interface");
			break;
		default:
			Display(false);
			break;
		}
	}
	public static void main(String[] args) throws SQLException {
		JDBCConnect j = new JDBCConnect();
		j.getDBConnection();
		j.Display(true);
	}

}
