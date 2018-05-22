package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.ChungTu;
import asset.entity.TaiSan;
import asset.model.ChungTuModel;
import asset.model.KhachHangModel;
import asset.model.TaiSanModel;

public class ChungTuController {

	public static ArrayList<ChungTu> select(int thang, int nam) {
		try {
			return ChungTuModel.select(thang, nam);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insert(String maCT,java.sql.Date ngayCT, int thang, int nam, String dienGiai) {
		try {
			return ChungTuModel.insert(maCT, ngayCT, thang, nam, dienGiai);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String generateId() throws SQLException {
		return ChungTuModel.generateId();
	}
}
