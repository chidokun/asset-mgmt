/**
 * 
 */
package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.KhachHang;
import asset.entity.TaiSan;
import asset.model.KhachHangModel;
import asset.model.TaiSanModel;

/**
 * @author Tuan
 *
 */
public class KhachHangController {
	public static KhachHang select(String maKH) throws SQLException {
		return KhachHangModel.select(maKH);
	}
	public static ArrayList<KhachHang> selectAll() {
		try {
			return KhachHangModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insert(KhachHang kh) throws SQLException {
		return KhachHangModel.insert(kh);
	}

	public static String generateId() throws SQLException {
		return KhachHangModel.generateId();
	}
}
