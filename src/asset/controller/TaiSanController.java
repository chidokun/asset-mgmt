package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.TaiSan;
import asset.model.TaiSanModel;

public class TaiSanController {
	public static TaiSan select(String maTS, String maPN) throws SQLException {
		return TaiSanModel.select(maTS, maPN);
	}

	public static ArrayList<TaiSan> search(String key) throws SQLException {
		return TaiSanModel.search(key);
	}
	
	public static ArrayList<TaiSan> selectAll() throws SQLException {
		return TaiSanModel.selectAll();
	}
}
