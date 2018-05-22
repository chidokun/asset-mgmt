/**
 * 
 */
package asset.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import asset.entity.HoaDon;
import asset.entity.PhieuNhap;
import asset.entity.TaiSan;
import asset.model.HoaDonModel;
import asset.model.PhieuNhapModel;
import asset.model.TaiSanModel;

/**
 * @author Tuan
 *
 */
public class PhieuNhapController {
	public static String generateID() {
		return PhieuNhapModel.generateID();
	}
	
	public static boolean insert(PhieuNhap pn, HoaDon hd, ArrayList<TaiSan> arr) throws SQLException {
		
		PhieuNhapModel.insert(pn);
		HoaDonModel.insert(hd);
		for(TaiSan i : arr) {
			TaiSanModel.updateForImport(i.getMaTS(), i.getTaiKhoanDU());
		}
		return true;

	}
}
