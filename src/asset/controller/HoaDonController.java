/**
 * 
 */
package asset.controller;

import java.sql.SQLException;

import asset.entity.HoaDon;
import asset.model.HoaDonModel;

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
}
