package asset.controller;

import java.util.ArrayList;

import asset.entity.Kho;
import asset.model.*;

public class KhoController {
	public static ArrayList<Kho> selectAll() {
		try {
			return KhoModel.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
