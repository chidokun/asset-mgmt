package asset.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	public static TaiSan select(String maTS, String maPN) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_TaiSan", maTS, maPN);

		rs.next();
		TaiSan ts = new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5),
				rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getDate(10));
		Database.connect().close();
		return ts;
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
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getDate(7)));
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
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getDate(7)));
		}

		Database.connect().close();
		return arr;
	}
}
