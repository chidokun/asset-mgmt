package asset.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import asset.entity.ChungTu;
import asset.entity.TaiSan;
import asset.util.Database;

public class ChungTuModel {
	public static ArrayList<ChungTu> select(int month, int year) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaCT, NgayCT, Thang, Nam, DienGiai FROM ChungTu where Thang=? and Nam=?;");
		st.setInt(1, month);
		st.setInt(2, year);
		
		ResultSet rs = st.executeQuery();

		ArrayList<ChungTu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ChungTu(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
		}
		return arr;
	}
	
	
	public static boolean insert(String maCT,java.sql.Date ngayCT, int thang, int nam, String dienGiai) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("INSERT INTO chungtu(MaCT, NgayCT, Thang, Nam, DienGiai) VALUES (?, ?, ?, ?, ?)");
		st.setString(1, maCT);
		st.setDate(2, ngayCT);
		st.setInt(3, thang);
		st.setInt(4, nam);
		st.setString(5, dienGiai);
		
		return st.executeUpdate() > 0;

	}
	
	/**
	 * Create a code for new chungtu
	 * 
	 * @return
	 */
	public static String generateId() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_ChungTu (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}
}
