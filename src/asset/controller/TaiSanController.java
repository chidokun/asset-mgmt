package asset.controller;

import java.util.ArrayList;
import asset.entity.TaiSan;
import asset.model.TaiSanModel;

public class TaiSanController {
	public static TaiSan select(String maTS) {
		return TaiSanModel.select(maTS);
	}

	public static ArrayList<TaiSan> search(String key) {
		;
		return TaiSanModel.search(key);
	}
}
