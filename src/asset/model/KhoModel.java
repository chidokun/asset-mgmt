/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.*;
import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class KhoModel {
	public static ArrayList<Kho> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaKho, TenKho FROM kho;");
		ResultSet rs = st.executeQuery();
		
		ArrayList<Kho> arr = new ArrayList<>();
		while(rs.next()) {
			arr.add(new Kho(rs.getString(1), rs.getString(2)));
		}	
		return arr;
	}
}
