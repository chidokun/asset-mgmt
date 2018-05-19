package asset.model;

import java.sql.CallableStatement;
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
		if (Database.callStoredUpdate("sp_ThemTheTaiSan", the.getMaThe(), the.getNgayLap(), the.getBoPhanSD(), the.getMaTS()) > 0) {
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
	
}
