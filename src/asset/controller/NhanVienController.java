/**
 * 
 */
package asset.controller;

import java.util.ArrayList;

import asset.entity.NhanVien;
import asset.model.NhanVienModel;

/**
 * @author Tuan
 *
 */
public class NhanVienController {
	public static ArrayList<NhanVien> selectAll() {
		try {
			return NhanVienModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
