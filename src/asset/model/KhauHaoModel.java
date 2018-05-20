package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asset.entity.KhauHao;
import asset.util.Database;

public class KhauHaoModel {
	public static KhauHao select(String maTS, String maCT) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaTS, MaCT, KhauHaoTrongThang, KhauHaoLuyKe, GiaTriConLai"
				+ " FROM khauhao Where MaTS = ? and MaCT = ?;");
		st.setString(1, maTS);
		st.setString(2, maCT);
		ResultSet rs = st.executeQuery();

		rs.next();
		KhauHao kh = new KhauHao(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getLong(4), rs.getLong(5));
		return kh;
	}
}
