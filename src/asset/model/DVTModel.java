package asset.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.DVT;
import asset.util.Database;

public class DVTModel {
	
	public static ArrayList<DVT> selectAll() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaDVT, TenDVT FROM dvt;");
		ResultSet rs = st.executeQuery();

		ArrayList<DVT> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new DVT(rs.getString(1), rs.getString(2)));
		}
		return arr;
	}
	
	public static DVT select(String maDVT) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaDVT, TenDVT FROM dvt where MaDVT=?;");
		st.setString(1, maDVT);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		DVT dvt = new DVT(rs.getString(1), rs.getString(2));
		return dvt;
	}
}
