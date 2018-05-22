package asset.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import asset.entity.TheTaiSan;
import asset.util.Database;

public class TheTaiSanModel {

	/**
	 * Add an asset form
	 * 
	 * @param kh
	 * @return
	 */
	public static boolean insert(TheTaiSan the) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemTheTaiSan", the.getMaThe(), the.getNgayLap(), the.getBoPhanSD(),
				the.getMaTS(), the.getNamDinhChi(), the.getLyDoDinhChi()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể tạo mới thẻ tài sản " + the.getMaThe());
	}

	/**
	 * Create a code for new asset form
	 * 
	 * @return
	 */
	public static String createCode() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_TheTaiSan (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}

	/**
	 * Select asset form of an asset
	 * 
	 * @return TheTaiSan
	 */
	public static TheTaiSan select(String maTS) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"SELECT MaThe, NgayLap, BoPhanSD, MaTS, NamDinhChi, LyDoDinhChi" + " FROM thetaisan Where MaTS = ?;");
		st.setString(1, maTS);
		ResultSet rs = st.executeQuery();
		if (!rs.next()) {
			return null;
		}
		TheTaiSan the = new TheTaiSan(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5),
				rs.getString(6));
		return the;
	}

}
