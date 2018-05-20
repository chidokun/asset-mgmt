/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class HoaDonModel {
	
	public static String generateId() {
		PreparedStatement st;
		try {
			st = Database.connect().prepareStatement("select cast(SUBSTRING(Max(SoHD),3,3) as unsigned) from hoadon;");
			ResultSet rs = st.executeQuery();	
			rs.next();
			int number = rs.getInt(1);
			return String.format("HD%03d", number);
		} catch (SQLException e) {
			e.printStackTrace();
			return "HD000";
		}	
	}

}
