package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.DVT;
import asset.entity.TaiSan;
import asset.model.DVTModel;
import asset.model.TaiSanModel;

public class DVTController {
	public static ArrayList<DVT> selectAll() throws SQLException {
		return DVTModel.selectAll();
	}
}
