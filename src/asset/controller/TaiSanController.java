package asset.controller;

import java.util.ArrayList;
import asset.entity.TaiSan;
import asset.model.TaiSanModel;

public class TaiSanController {
	public static TaiSan select(String maTS) {
		return TaiSanModel.select(maTS);
	}

	public static ArrayList<TaiSan> search(String key) {
		return TaiSanModel.search(key);
	}
	
	public static ArrayList<TaiSan> selectTop(int top) {
		try {
			return TaiSanModel.selectTop(top);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
