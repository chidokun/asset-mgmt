/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.KhachHang;
import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class KhachHangModel {
	
	public static ArrayList<KhachHang> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaKH, TenKH, DiaChi, SoTK FROM khachhang;");
		ResultSet rs = st.executeQuery();
		
		ArrayList<KhachHang> arr = new ArrayList<>();
		while(rs.next()) {
			arr.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}	
		return arr;
	}
}
