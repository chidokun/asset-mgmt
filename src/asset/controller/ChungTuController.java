package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.ChungTu;
import asset.model.ChungTuModel;


public class ChungTuController {
	public static ArrayList<ChungTu> search(String maTS) throws SQLException {
		return ChungTuModel.search(maTS);
	}
}
