package asset.model;

import java.util.ArrayList;
import java.util.Date;
import asset.entity.TaiSan;

public class TaiSanModel {

	public static TaiSan select(String maTS) {
		// hard code
		TaiSan ts = new TaiSan();
		ts.setMaTS(maTS);
		ts.setNgaySD(new Date(System.currentTimeMillis()));
		ts.setSoNamKH(3);
		ts.setSoThangSD(36);
		ts.setTenTS("Màn hình laptop");
		return ts;
	}

	public static ArrayList<TaiSan> search(String key) {
		// hard code
		ArrayList<TaiSan> arr = new ArrayList<TaiSan>();
		TaiSan ts = new TaiSan();
		ts.setMaTS("TS0001");
		ts.setNgaySD(new Date(System.currentTimeMillis()));
		ts.setSoNamKH(3);
		ts.setSoThangSD(36);
		ts.setTenTS("Màn hình laptop");

		TaiSan ts1 = new TaiSan();
		ts1.setMaTS("TS0002");
		ts1.setNgaySD(new Date(System.currentTimeMillis()));
		ts1.setSoNamKH(10);
		ts1.setSoThangSD(16);
		ts1.setTenTS("CPU core I7");
		arr.add(ts);
		arr.add(ts1);
		;
		return arr;
	}
}
