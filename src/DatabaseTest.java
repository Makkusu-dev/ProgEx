import java.sql.*;
/*
 * Establishes a connection to the local Database (database.db), and executes a few SQL queries for testing purposes.
 */
public class DatabaseTest {

	public static void main(String[] args) {
		Connection c = null;
		Statement stmt = null;
		try {

			Class.forName("org.sqlite.JDBC");											//Connecting to the database
			c = DriverManager.getConnection("jdbc:sqlite:Test.db");
			
		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}

		System.out.println("Database connection established.");

		try {
			
			stmt = c.createStatement();													//Creating a basic table named "Patient" with a few parameters
			String sql = "CREATE TABLE Mensch" +
						 "(ID INT PRIMARY KEY     NOT NULL," +
						 " NAME           TEXT    NOT NULL)";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();																	//Closing database connection (for testing purposes)

		} catch (Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		
		System.out.println("Table created!");
		
	    try {
	    	
	        c = DriverManager.getConnection("jdbc:sqlite:Test.db");					//Reinitializing database connection
	        c.setAutoCommit(false);														//AutoCommit=FALSE (manual commit needed)

	        stmt = c.createStatement();													//Defining a statement
	        
	        String sql = "INSERT INTO Mensch (ID,NAME) " +								//SQL insert statement for populating the new table with some data
	        			 "VALUES (1, 'Der Weihnachtsmann');"; 
	        stmt.executeUpdate(sql);													//Executing statement
       
       		sql = "INSERT INTO Mensch (ID,NAME) " +
       			  "VALUES (2, 'Bear Grylls');";
       		stmt.executeUpdate(sql);													//Executing statement
       		
            stmt.close();
            c.commit();																	//Committing
            
          } catch (Exception e) {
  			System.out.println(e);
  			System.exit(0);
  		}
	        
	    System.out.println("Data inserted!");
	    
	    try {
	    	
	        stmt = c.createStatement();													//SELECT statement with a loop for listing all table entries
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM Mensch;" );
	        while ( rs.next() ) {
	           int id = rs.getInt("id");
	           String  name = rs.getString("name");
	           System.out.println( "ID = " + id );
	           System.out.println( "NAME = " + name );
	           System.out.println();
	        }
	        
	        rs.close();
	        stmt.close();
	        c.close();																	//Closing database connection
	           
          } catch (Exception e) {
  			System.out.println(e);
  			System.exit(0);
  		}
	    
	    try {
	    	
	        c = DriverManager.getConnection("jdbc:sqlite:Test.db");					//Reinitializing database connection
	        c.setAutoCommit(false);

	        stmt = c.createStatement();
	        String sql = "UPDATE Mensch set name = 'Tot' where ID=1;";					//Updating a data set
	        stmt.executeUpdate(sql);
	        
	        sql = "DELETE FROM Mensch where ID=2;";									//Deleting a data set
	        stmt.executeUpdate(sql);
	        
	        c.commit();
	        
	        ResultSet rs = stmt.executeQuery( "SELECT * FROM Mensch;" );				//Another SELECT statement for listing all table entries
	        while ( rs.next() ) {
	           int id = rs.getInt("id");
	           String  name = rs.getString("name");
	           System.out.println( "ID = " + id );
	           System.out.println( "NAME = " + name );
	           System.out.println();
	        }
	        
	        rs.close();
	        stmt.close();
	        c.close();																	//Closing database connection (weil's so viel Spaﬂ macht)
	           
          } catch (Exception e) {
  			System.out.println(e);
  			System.exit(0);
  		}
	    
	    try {
	    	
	        c = DriverManager.getConnection("jdbc:sqlite:Test.db");					//Reinitializing database connection
	        c.setAutoCommit(false);
	        
	        stmt = c.createStatement();
	        String sql = "DROP TABLE Mensch;";											//Dropping the table "Patient"
	        stmt.executeUpdate(sql);
	        
	        c.commit();
	        c.close();																	//Closing database connection
	        
	    } catch (Exception e) {
	    	System.out.println(e);
	    	System.exit(0);
	    }
		
	}

}
