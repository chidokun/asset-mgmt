/**
 * 
 */
package asset.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import asset.entity.KhachHang;
import asset.entity.TaiSan;
import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class KhachHangModel {
	
	
	/**
	 * Select an customer
	 * 
	 * @param maKH
	 * @return
	 * @throws SQLException
	 */
	public static KhachHang select(String maKH) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_KhachHang", maKH);

		rs.next();
		KhachHang kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		Database.connect().close();
		return kh;
	}
	
	public static ArrayList<KhachHang> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaKH, TenKH, DiaChi, SoTK FROM khachhang;");
		ResultSet rs = st.executeQuery();
		
		ArrayList<KhachHang> arr = new ArrayList<>();
		while(rs.next()) {
			arr.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}	

		return arr;
	}
	
	/**
	 * Create a code for new customer
	 * 
	 * @return
	 */
	public static String generateId() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_KhachHang (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}
	
	/**
	 * Add an customer
	 * 
	 * @param ts
	 * @return
	 */
	public static boolean insert(KhachHang kh) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemKhachHang", kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), 
				kh.getSoTK()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể tạo mới khách hàng " + kh.getMaKH());
	}
}
