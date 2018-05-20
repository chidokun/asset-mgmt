package asset.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.ChungTu;
import asset.util.Database;

public class ChungTuModel {
	/**
	 * Search vouchers of an asset
	 * 
	 * @return array list of vouchers
	 * @throws SQLException
	 */
	public static ArrayList<ChungTu> search(String maTS) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_ChungTu", maTS);

		ArrayList<ChungTu> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new ChungTu(rs.getString(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
		}

		Database.connect().close();
		return arr;
	}
}
