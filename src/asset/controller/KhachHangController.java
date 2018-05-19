/**
 * 
 */
package asset.controller;

import java.util.ArrayList;

import asset.entity.KhachHang;
import asset.model.KhachHangModel;

/**
 * @author Tuan
 *
 */
public class KhachHangController {
	public static ArrayList<KhachHang> selectAll() {
		try {
			return KhachHangModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
