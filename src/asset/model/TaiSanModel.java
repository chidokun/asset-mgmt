package asset.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import asset.entity.TaiSan;
import asset.util.Database;

public class TaiSanModel {

	/**
	 * Select an asset
	 * 
	 * @param maTS
	 * @return
	 * @throws SQLException
	 */
	public static TaiSan select(String maTS) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_TaiSan", maTS);

		rs.next();
		TaiSan ts = new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5),
				rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11));
		Database.connect().close();
		return ts;
	}

	public static ArrayList<TaiSan> selectTop(int top) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaTS, TenTS FROM taisan LIMIT 0, ?;");
		st.setInt(1, top);
		ResultSet rs = st.executeQuery();

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2)));
		}
		return arr;
	}

	/**
	 * Search asset
	 * 
	 * @return array list of asset
	 * @throws SQLException
	 */
	public static ArrayList<TaiSan> search(String key) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuTaiSan", key);

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Select all asset
	 * 
	 * @return array list of asset
	 * @throws SQLException
	 */
	public static ArrayList<TaiSan> selectAll() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuTaiSan", "");

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
		}

		Database.connect().close();
		return arr;
	}
	
	/**
	 * Add an asset
	 * 
	 * @param ts
	 * @return
	 */
	public static boolean insert(TaiSan ts) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemTaiSan", ts.getMaTS(), ts.getTenTS(), ts.getSoNamKH(), 
				ts.getNgaySD(), ts.getSoThangSD(), ts.getMaDVT(), ts.getTrangThai(), ts.getNguyenGia(), ts.getSl()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể tạo mới tài sản " + ts.getMaTS());
	}
	
	/**
	 * Create a code for new asset
	 * 
	 * @return
	 */
	public static String generateId() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_TaiSan (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}
	
	public static boolean updateForExport(String maTS, int sl) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"UPDATE taisan SET SL=SL-? WHERE MaTS=?");
		st.setInt(1, sl);
		st.setString(2, maTS);
		
		return st.executeUpdate() > 0;
	}
}
