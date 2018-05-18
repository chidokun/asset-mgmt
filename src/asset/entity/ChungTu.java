package asset.entity;

import java.util.Date;

public class ChungTu {
	private String maCT;
	private Date ngayCT;
	private int thang;
	private int nam;
	private String dienGiai;

	public String getMaCT() {
		return maCT;
	}

	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}

	public Date getNgayCT() {
		return ngayCT;
	}

	public void setNgayCT(Date ngayCT) {
		this.ngayCT = ngayCT;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		this.thang = thang;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public String getDienGiai() {
		return dienGiai;
	}

	public void setDienGiai(String dienGiai) {
		this.dienGiai = dienGiai;
	}

}
