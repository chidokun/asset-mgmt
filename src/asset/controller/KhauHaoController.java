package asset.controller;

import java.sql.SQLException;

import asset.entity.KhauHao;
import asset.model.KhauHaoModel;

public class KhauHaoController {
	public static KhauHao select(String maTS, String maCT) throws SQLException {
		return KhauHaoModel.select(maTS, maCT);
	}
}
