package BasicWebApp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Rack extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JDBCTutorialUtilities myJDBCTutorialUtilities;
	    Connection myConnection = null;
	    ArrayList<String> racksData = new ArrayList<String>();
	      try {
	        System.out.println("Reading properties file " + "properties/mysql-build-properties.xml");
	        myJDBCTutorialUtilities = new JDBCTutorialUtilities("properties/mysql-build-properties.xml");
	      } catch (Exception e) {
	        System.err.println("Problem reading properties file " + "properties/mysql-build-properties.xml");
	        e.printStackTrace();
	        return;
	      }
	    

	    try {
	      myConnection = myJDBCTutorialUtilities.getConnection();

	      Statement stmt = null;
	      String query = "SELECT * FROM racks";
	      
	      try {
	        stmt = myConnection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);

	        while (rs.next()) {
	          int rackID = rs.getInt("id");
	          String slot0 = rs.getString("slot0");
	          String slot1 = rs.getString("slot1");
	          String slot2 = rs.getString("slot2");
	          String slot3 = rs.getString("slot3");
	          String rackData = ("Rack: " + rackID + " Slot 0: " + slot0 + " Slot 1: " + slot1 + " Slot 2: " + slot2 + " Slot 3: " + slot3);
	          racksData.add(rackData);
	        }

	      } catch (SQLException e) {
	        JDBCTutorialUtilities.printSQLException(e);
	      } finally {
	        if (stmt != null) { stmt.close(); }
	      }
	      
	    } catch (SQLException e) {
	      JDBCTutorialUtilities.printSQLException(e);
	    } catch (Exception e) {
	      e.printStackTrace(System.err);
	    } finally {
	      JDBCTutorialUtilities.closeConnection(myConnection);
	    }
		req.setAttribute("racks.data",racksData );
		req.getRequestDispatcher("/index.jsp").forward(req,resp);
	}
}
