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
public class QuyenModel {
	public static ArrayList<Quyen> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT Quyen, MauSo, KyHieu FROM quyen;");
		ResultSet rs = st.executeQuery();
		
		ArrayList<Quyen> arr = new ArrayList<>();
		while(rs.next()) {
			arr.add(new Quyen(rs.getString(1), rs.getString(2), rs.getString(3)));
		}	
		return arr;
	}
}
