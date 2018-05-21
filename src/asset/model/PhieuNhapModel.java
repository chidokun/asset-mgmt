/**
 * 
 */
package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import asset.entity.PhieuNhap;
import asset.util.Database;

/**
 * @author Tuan
 *
 */
public class PhieuNhapModel {
	public static String generateID() {
		PreparedStatement st;
		try {
			st = Database.connect().prepareStatement("select cast(SUBSTRING(Max(MaPN),3,3) as unsigned) from phieunhap;");
			ResultSet rs = st.executeQuery();	
			rs.next();
			int number = rs.getInt(1);
			return String.format("PN%03d", number+1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "PN000";
		}	
	}
	
	public static boolean insert(PhieuNhap pn) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemPhieuNhap", pn.getMaPN(), pn.getNgayLap(), pn.getLyDo(),
				pn.getTaiKhoanChinh(), pn.getThueGTGT(), pn.getMaNV(), pn.getMaKH(), pn.getMaKho()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể tạo mới phiếu nhập " + pn.getMaPN());
	}
}
