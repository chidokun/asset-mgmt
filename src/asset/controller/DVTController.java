package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.DVT;
import asset.model.DVTModel;

public class DVTController {
	public static ArrayList<DVT> selectAll() throws SQLException {
		return DVTModel.selectAll();
	}
	
	public static DVT select(String maDVT) {
		try {
			return DVTModel.select(maDVT);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
