/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.NhanVien;
import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class NhanVienModel {
	public static ArrayList<NhanVien> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaNV FROM nhanvien;");
		ResultSet rs = st.executeQuery();
		
		ArrayList<NhanVien> arr = new ArrayList<>();
		while(rs.next()) {
			arr.add(new NhanVien(rs.getString(1)));
		}	
		return arr;
	}
}
