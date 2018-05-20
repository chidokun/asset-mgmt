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
public class PhieuNhapModel {
	public static String generateID() {
		PreparedStatement st;
		try {
			st = Database.connect().prepareStatement("select cast(SUBSTRING(Max(MaPN),3,3) as unsigned) from phieunhap;");
			ResultSet rs = st.executeQuery();	
			rs.next();
			int number = rs.getInt(1);
			return String.format("PN%03d", number);
		} catch (SQLException e) {
			e.printStackTrace();
			return "PN000";
		}	
	}
}
