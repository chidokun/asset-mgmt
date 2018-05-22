/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asset.entity.HoaDon;
import asset.util.Database;
import asset.util.DateF;

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
			return String.format("HD%03d", number + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "HD000";
		}
	}

	public static boolean insert(HoaDon hd) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"INSERT INTO hoadon(SoHD, NgayPhatHanh, NgayThanhToan, HinhThucThanhToan, ThueGTGT, TongTien, Quyen, MaKho, MaKH, MaNV, LyDo, TaiKhoanChinh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, hd.getSoHD());
		st.setString(2, DateF.toStandardString(hd.getNgayPhatHanh()));
		st.setString(3, DateF.toStandardString(hd.getNgayThanhToan()));
		st.setString(4, hd.getHinhThucThanhToan());
		st.setInt(5, hd.getThueGTGT());
		st.setInt(6, hd.getTongTien());
		st.setString(7, hd.getQuyen());
		st.setString(8, hd.getMaKho());
		st.setString(9, hd.getMaKH());
		st.setString(10, hd.getMaNV());
		st.setString(11, hd.getLyDo());
		st.setString(12, hd.getTaiKhoanChinh());

		return st.executeUpdate() > 0;
	}

}
