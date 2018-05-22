/**
 * 
 */
package asset.controller;

import java.util.HashMap;

import asset.model.TKKTModel;

/**
 * @author Tuan
 *
 */
public class TKKTController {
	public static HashMap<Integer, String> selectAll() {
		try {
			return TKKTModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
