package lesson10.labsolns.prob4a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import lesson10.lecture.jdbc.read_trywithres.ConnectManager;

public class ZipUpdate {
	
    private static final Logger LOG = Logger.getLogger(ZipUpdate.class.getName()); 
    private String readZipQuery = "SELECT id, zip FROM Customer WHERE zip LIKE '5%' AND LENGTH(RTRIM(zip)) = 5";
    private String updateZipQuery = "UPDATE Customer SET zip = ? WHERE id = ?";
    		
    public static void main(String[] args) {
    	ZipUpdate zu = new ZipUpdate();
    	zu.updateZips();
    }
	/**
	 * Extracts from Customer table all records with first digit of zip equal to 5.
	 * Updates each of these zips to zip-1000.
	 * 
	 * Reading zips does not require a transaction, but updating the batch of
	 * records found is done within a transaction
	 */
	public void updateZips() {
		String outputMessage = "The Customers with ids in the list %s were successfully updated." +
				" Number of rows modified: %d";
		try {
			List<IdZip> list = readRecords();
			int num = doUpdates(list);
			System.out.printf(outputMessage, idZipToId(list).toString(), num);
		} catch(SQLException e) {
			for(Throwable t : e) {
				System.out.println("* " + t.getMessage());
			}
		}
	}
	
	private List<Integer> idZipToId(List<IdZip> list) {
		return list.stream().map(idzip -> idzip.getId()).collect(Collectors.toList());
	}
	private List<IdZip> readRecords() throws SQLException {
		List<IdZip> retVal = new ArrayList<>();
		try(Connection conn = ConnectManager.getConnection()) {
			Statement stat = conn.createStatement();
			//using this try/catch to (partially) handle exceptions
			//involving statements and executing queries -- such
			//exceptions are logged and then re-thrown
			try {
				ResultSet rs = stat.executeQuery(readZipQuery);				
				while(rs.next()) {
					retVal.add(new IdZip(rs.getInt("id"), rs.getString("zip").trim()));
				}					
			} catch(SQLException e) {
				//log exception
				StringBuilder sb = new StringBuilder();
				
				//SQLException now implements Iterable, so 
				//it is possible to iterate through chained 
				//exceptions like this
				for(Throwable t : e) {
					sb.append("+ " + t.getMessage()+ "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			}
		}
		LOG.info("Records found: " + retVal);
		return retVal;	
	}
	
	private int doUpdates(List<IdZip> list) throws SQLException {
		int numrows = 0;
		//Step 1: Get Connection, manage using try-with-resournces
		try(Connection conn = ConnectManager.getConnection()) {
			try {
				
				//Step 2: Use Connection to create PreparedStatements
				List<PreparedStatement> statements = prepareStatements(conn, list);
				
			
				//Step 3: begin transaction
				conn.setAutoCommit(false);	
				
				//Step 4: execute queries
				for(PreparedStatement s : statements) {
					numrows += performUpdate(s);
				}
				
				//Step 5: commit (if queries fail, this line won't execute)
				conn.commit();
				LOG.info("" + numrows + " updated");
				
				
			} catch(SQLException e) {
				//Step 5: if an operation fails, rollback
				conn.rollback();
				//log exception
				StringBuilder sb = new StringBuilder();
				for(Throwable t : e) {
					sb.append("+ " + e.getMessage()+ "\n");
				}
				LOG.warning("SQLException thrown:\n" + sb.toString());
				throw e;
			} finally{ 
				//Step 6: restore default state of autoCommit (no cleanup necessary)
				conn.setAutoCommit(true);
				
			}
		}
		return numrows;
	}
	
	private List<PreparedStatement> prepareStatements(Connection conn, List<IdZip> list)
			throws SQLException {
		List<PreparedStatement> ret = new ArrayList<>();
		for(IdZip ob : list) {
			PreparedStatement updateStatement = conn.prepareStatement(updateZipQuery);
			updateStatement.setString(1, ob.getZip() + "-1000");
			updateStatement.setInt(2, ob.getId());
			ret.add(updateStatement);
		}
		return ret;
	}
	
	private int performUpdate(PreparedStatement stmt) throws SQLException {
		int numRows = stmt.executeUpdate();
		return numRows;
	}
}
