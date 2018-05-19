/**
 * 
 */
package asset.controller;

import java.util.ArrayList;

import asset.entity.Quyen;
import asset.model.QuyenModel;

/**
 * @author Tuan
 *
 */
public class QuyenController {
	public static ArrayList<Quyen> selectAll() {
		try {
			return QuyenModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
