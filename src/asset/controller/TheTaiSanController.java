package asset.controller;

import java.sql.SQLException;

import asset.entity.TheTaiSan;
import asset.model.TheTaiSanModel;

public class TheTaiSanController {
	public static boolean insert(TheTaiSan the) throws SQLException {
		return TheTaiSanModel.insert(the);
	}

	public static String createCode() throws SQLException {
		return TheTaiSanModel.createCode();
	}
	
	public static TheTaiSan select(String maTS) throws SQLException {
		return TheTaiSanModel.select(maTS);
	}
}
