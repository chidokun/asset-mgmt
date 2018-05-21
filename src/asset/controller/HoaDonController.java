/**
 * 
 */
package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.Ban;
import asset.entity.HoaDon;
import asset.model.BanModel;
import asset.model.HoaDonModel;
import asset.model.TaiSanModel;

/**
 * @author Tuan
 *
 */
public class HoaDonController {
	public static String generateId() {
		return HoaDonModel.generateId();
	}
	
	public static boolean insert(HoaDon hd) {
		try {
			return HoaDonModel.insert(hd);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean insertHoaDonBan(HoaDon hd, ArrayList<Ban> arr) {
		try {
			HoaDonModel.insert(hd);
			for(Ban i : arr) {
				BanModel.insert(i);
				TaiSanModel.updateForExport(i.getMaTS(), i.getSl());
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
