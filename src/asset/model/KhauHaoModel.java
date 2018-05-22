package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.TaiSan;
import asset.util.Database;

public class KhauHaoModel {
	
	public static boolean insert(String maTS, String maCT, double  khauHaoTrongThang, double khauHaoLuyKe, double giaTriConLai) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("INSERT INTO khauhao(MaTS, MaCT, KhauHaoTrongThang, KhauHaoLuyKe, GiaTriConLai) VALUES (?, ?, ?, ?, ?)");
		st.setString(1, maTS);
		st.setString(2, maCT);
		st.setDouble(3, khauHaoTrongThang);
		st.setDouble(4, khauHaoLuyKe);
		st.setDouble(5, giaTriConLai);
		
		return st.executeUpdate() > 0;

	}
	
	/**
	 * Sum Khau hao cua tai san *
	 * 
	 * @return
	 */
	public static long sumKhauHao(String maTS) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"SELECT SUM(KhauHaoTrongThang) FROM khauhao WHERE MaTS = ?;");
		st.setString(1, maTS);
		ResultSet rs = st.executeQuery();

		long sum=0;
		while (rs.next()) {
			sum=rs.getLong(1);
		}
		return sum;
	}
}
