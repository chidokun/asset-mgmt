package asset.controller;

import java.util.ArrayList;

import asset.entity.KhauHao;
import asset.model.KhauHaoModel;


public class KhauHaoController {
	public static boolean insert(String maTS, String maCT, double  khauHaoTrongThang, double khauHaoLuyKe, double giaTriConLai) {
		try {
			return KhauHaoModel.insert(maTS, maCT, khauHaoTrongThang, khauHaoLuyKe, giaTriConLai);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static long sumKhauHao(String maTS) {
		try {
			return KhauHaoModel.sumKhauHao(maTS);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
