/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class TKKTModel {
	public static HashMap<Integer, String> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaTK, TenTK FROM tkkt;");
		ResultSet rs = st.executeQuery();
		
		HashMap<Integer, String> map = new HashMap<>();
		while(rs.next()) {
			map.put(rs.getInt(1), rs.getString(2));
		}	
		return map;
	}
}
