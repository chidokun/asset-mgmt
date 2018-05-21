package asset.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import asset.entity.Ban;
import asset.util.Database;

public class BanModel {
	public static boolean insert(Ban b) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"INSERT INTO ban(SoHD, MaTS, SL, GiaBan, TaiKhoanDU) VALUES (?,?,?,?,?)");
		st.setString(1, b.getSoHD());
		st.setString(2, b.getMaTS());
		st.setInt(3, b.getSl());
		st.setInt(4, b.getGiaBan());
		st.setString(5, b.getTKDUTaiSan());
		
		return st.executeUpdate() > 0;
	}
}
