package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JdbcNew {
	private static final String JDBC = "jdbc:mysql://localhost:3306/";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String register = "com.mysql.cj.jdbc.Driver";
	private static Connection con;
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// registering the driver
		Class.forName(register);
		// Connecting to the DB
		con = DriverManager.getConnection(JDBC, USER, PASS);
		Statement statement = con.createStatement();
		userOption(statement);
	}
	public static void userOption(Statement statement) throws SQLException {
		try {
			int uc = 0;
			do {
				System.out.println("1.Create New Table\n2.InsertDataToTable\n3.SearchEmployee\n4.PrintTable\n5.Update\n6.DeleteDataInTable\n7.Exit");
				uc = scan.nextInt();
				switch (uc) {
				case 1:
					createTable(statement);
					break;
				case 2:
					insertDataToTable(statement);
					break;
				case 3:
					searchEmployee(statement);
					break;
				case 4:
					showAllTable(statement);
					break;
				case 5:
					update(statement);
					break;
				case 6:
					deleteDataInTheTable(statement);
					break;
				case 7:
					System.out.println("Thank you for using our appliaction :)");
					break;
				default:
					System.out.println("Wrong input!!!");
				}
			} while (uc != 7);
			}
			catch(InputMismatchException e) {
				System.out.println("Plss enter only numbers");
				//userOption(statement);
			}
	}

	public static void createDB(Statement statement) throws SQLException, ClassNotFoundException {

		String QueryForCreateDB = "CREATE DATABASE employees";
		statement.executeUpdate(QueryForCreateDB);
		System.out.println("DataBase created successfully");
	}

	public static void createTable(Statement statement) throws SQLException {
		System.out.println("Enter the new table name : ");
		String tableName = scan.next();// getting table name from user
		statement.executeUpdate("use employees");
		String QueryForCreatingTable = "create table if not exists " + tableName + "("
				+ "id int auto_increment primary key," + " name varchar(25)," + " age int," + " salary decimal(10,2))";
		statement.executeUpdate(QueryForCreatingTable);// executing the query
		System.out.println("Table " + tableName + " created successfully...");
	}

	public static void insertDataToTable(Statement statement) throws SQLException {
		System.out.println("In which table you want to add data : ");
		String tableName = scan.next();// getting table name to add data

		System.out.println("Enter employee name : ");
		String name = scan.next();

		System.out.println("Enter age : ");
		int age = scan.nextInt();

		System.out.println("Enter the salary : ");
		double salary = scan.nextDouble();

		statement.executeUpdate("use employees");// selecting database
		String sqlQuery = "insert into " + tableName + " (name,age,salary) values(?,?,?)";// creating query for insert
																							// to table
		try (PreparedStatement st = con.prepareStatement(sqlQuery)) {
			// creating prepared statement
			st.setString(1, name);
			st.setInt(2, age);
			st.setDouble(3, salary);
			int rowsAffected = st.executeUpdate();// executing the statement
			System.out.println("No of rows Affecetd " + rowsAffected);
		}

	}

	public static void searchEmployee(Statement statement) throws SQLException {
		statement.executeUpdate("use employees");
		System.out.println("Enter employee id to search : ");
		int id = scan.nextInt();
		String queryForSearch = "select * from emp where id=" + id;// query for selecting particular row
		ResultSet result = statement.executeQuery(queryForSearch);//Getting the datas of employee using executeQuery method
		if (result.next()) {
			// Print employee details
			System.out.println("Id: " + result.getInt("id"));
			System.out.println("Name: " + result.getString("name"));
			System.out.println("Age: " + result.getInt("age"));
			System.out.println("Salary: " + result.getInt("salary"));
		} else {
			System.out.println("Employee not found with id: " + id);
		}
	}

	public static void showAllTable(Statement statement) throws SQLException {
		System.out.println("Enter table name to show : ");
		String tableName = scan.next();
		String sqlQuery = "select * from " + tableName;//generating query for select entire table
		statement.execute("use employees");//selecting database
		ResultSet result = statement.executeQuery(sqlQuery);//Storing the datas in resultset object
		System.out.println("Id\tName\tAge\tSalary");
		while (result.next()) {
			System.out.print(result.getInt("id") + "\t");
			System.out.print(result.getString("name") + "\t");
			System.out.print(result.getInt("age") + "\t");
			System.out.println(result.getInt("salary"));
		}

	}
	public static void update(Statement statement) throws SQLException {
		System.out.println("Enter table Name : ");
		String tableName=scan.next();
		System.out.println("Enter id to update : ");
		int id=scan.nextInt();
		System.out.println("Which field you have to change : ");
		System.out.println("1.Name\n2.Age\n3.Salary");
		int uc=scan.nextInt();
		String Field="" ;
		switch(uc) {
		case 1:{
			System.out.println("Enter new name : ");
			String name=scan.next();
			Field="name = '"+name+"'";
			break;
		}
		case 2:{
			System.out.println("Enter new age : ");
			int age=scan.nextInt();
			Field="age = "+age;
			break;
		}
		case 3:{
			System.out.println("Enter new salary : ");
			int salary=scan.nextInt();
			Field="salary = "+salary;
			break;
		}
		default:System.out.println("Wrong input");
		}
		
		statement.execute("use employees");//selecting the database
		String queryForUpdate="update "+tableName+" set "+Field+" where id="+id;//generating the query for updation
		int rowsAffecetd=statement.executeUpdate(queryForUpdate);//executing the query for updation
		if(rowsAffecetd>0) {
			System.out.println("Succesfully updated "+rowsAffecetd+" rows");
		}
		else {
			System.out.println("Something went wrong... not updated");
		}
	}
	public static void deleteDataInTheTable(Statement statement) throws SQLException {
		statement.execute("use employees");//selecting the database
		System.out.println("Enter table name:");
		String tableName=scan.next();//Getting table name
		System.out.println("Enter Id no to delete the records : ");
		int id=scan.nextInt();//Getting user id delete the record
		
		String quertToDelete="delete from "+tableName+" where id="+id;//Query for delete particular record
		String QueryToGetName="select * from "+tableName+" where id="+id;//Query to get the name of the employee
		ResultSet result=statement.executeQuery(QueryToGetName);//getting the name of the employee
		String name="";
		if(result.next()) {
		name = result.getString("name");//getting the name from the resultset
		}
		int rows=statement.executeUpdate(quertToDelete);//executing the query
		if(rows>0) {
			System.out.println("All the records of Mr/Mrs "+name+" are deleted");
		}
		else {
			System.out.println("Something went wrong");
		}
		}
	}


