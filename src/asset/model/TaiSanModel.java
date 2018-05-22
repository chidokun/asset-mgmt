package asset.model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import asset.entity.TaiSan;
import asset.entity.TaiSanKhauHao;
import asset.entity.TheTaiSan;
import asset.util.Database;

public class TaiSanModel {

	/**
	 * Select an asset
	 * 
	 * @param maTS
	 * @return
	 * @throws SQLException
	 */
	public static TaiSan select(String maTS) throws SQLException {
		ResultSet rs = Database.callStored("sp_LayThongTin_TaiSan", maTS);

		rs.next();
		TaiSan ts = new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5),
				rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
		Database.connect().close();
		return ts;
	}

	public static ArrayList<TaiSan> selectTop(int top) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement("SELECT MaTS, TenTS FROM taisan LIMIT 0, ?;");
		st.setInt(1, top);
		ResultSet rs = st.executeQuery();

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2)));
		}
		return arr;
	}

	/**
	 * Search asset
	 * 
	 * @return array list of asset
	 * @throws SQLException
	 */
	public static ArrayList<TaiSan> search(String key) throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuTaiSan", key);

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Select all asset
	 * 
	 * @return array list of asset
	 * @throws SQLException
	 */
	public static ArrayList<TaiSan> selectAll() throws SQLException {
		ResultSet rs = Database.callStored("sp_TraCuuTaiSan", "");

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5)));
		}

		Database.connect().close();
		return arr;
	}

	/**
	 * Add an asset
	 * 
	 * @param ts
	 * @return
	 */
	public static boolean insert(TaiSan ts) throws SQLException {
		if (Database.callStoredUpdate("sp_ThemTaiSan", ts.getMaTS(), ts.getTenTS(), ts.getSoNamKH(), ts.getNgaySD(),
				ts.getSoThangSD(), ts.getMaDVT(), ts.getTrangThai()) > 0) {
			Database.connect().close();
			return true;
		} else
			throw new SQLException("Không thể tạo mới tài sản " + ts.getMaTS());
	}

	/**
	 * Create a code for new asset
	 * 
	 * @return
	 */
	public static String generateId() throws SQLException {
		CallableStatement st = Database.connect().prepareCall("{call sp_TaoMa_TaiSan (?)}");
		st.registerOutParameter(1, Types.VARCHAR);
		st.execute();
		return st.getString(1);
	}

	/**
	 * Select asset het khau hao *
	 * 
	 * @return
	 */
	public static ArrayList<TaiSanKhauHao> selectHetKhauHao() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"SELECT ts.MaTS, ts.TenTS, tts.BoPhanSD, ts.NguyenGia, ts.NgaySD, ts.SoThangSD FROM taisan ts, thetaisan tts WHERE ts.MaTS = tts.MaTS and ts.TrangThai = 1;");
		ResultSet rs = st.executeQuery();

		ArrayList<TaiSanKhauHao> arr = new ArrayList<>();
		while (rs.next()) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date now = new Date();
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(rs.getDate(5));
			Calendar endCalendar = new GregorianCalendar();
			endCalendar.setTime(now);
			int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
			int soThangDaSuDung = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
			arr.add(new TaiSanKhauHao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
					rs.getInt(6), soThangDaSuDung));
		}
		return arr;
	}

	/**
	 * Select asset by maCT *
	 * 
	 * @return
	 */
	public static ArrayList<TaiSanKhauHao> selectAssetByMaCT(String maCT) throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"SELECT  DISTINCT ts.MaTS, ts.TenTS, tts.BoPhanSD, ts.NguyenGia, ts.NgaySD, ts.SoThangSD, kh.KhauHaoTrongThang, kh.KhauHaoLuyKe, kh.GiaTriConLai, ts.SoThangSD, ct.Thang, ct.Nam FROM taisan ts, thetaisan tts, khauhao kh, ChungTu ct WHERE ts.MaTS = tts.MaTS and ts.TrangThai = 0 and kh.MaTS = ts.MaTS and kh.MaCT = ct.maCT and kh.MaCT = ?;");
		st.setString(1, maCT);
		ResultSet rs = st.executeQuery();

		ArrayList<TaiSanKhauHao> arr = new ArrayList<>();
		while (rs.next()) {
			Calendar startCalendar = new GregorianCalendar();
			startCalendar.setTime(rs.getDate(5));
			int diffYear = rs.getInt(12) - startCalendar.get(Calendar.YEAR);
			int soThangDaSuDung = diffYear * 12 + rs.getInt(11) - startCalendar.get(Calendar.MONTH) - 1;
			long khauHaoHangThang = rs.getInt(4) / rs.getInt(10);
			arr.add(new TaiSanKhauHao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5),
					rs.getInt(6), soThangDaSuDung, khauHaoHangThang, rs.getLong(7), rs.getLong(8), rs.getLong(9)));
		}
		return arr;
	}

	/**
	 * Select asset het khau hao *
	 * 
	 * @return
	 */
	public static ArrayList<TaiSan> selectTaiSanConKhauHao() throws SQLException {
		PreparedStatement st = Database.connect().prepareStatement(
				"SELECT MaTS, TenTS, SoNamKH, NgaySD, SoThangSD, MaDVT, TrangThai, NguyenGia, MaPN, SL FROM taisan WHERE TrangThai = 0;");
		ResultSet rs = st.executeQuery();

		ArrayList<TaiSan> arr = new ArrayList<>();
		while (rs.next()) {
			arr.add(new TaiSan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getInt(5),
					rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10)));
		}
		return arr;
	}

}
