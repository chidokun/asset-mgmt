package asset.view.form;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CBanner;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import asset.controller.DVTController;
import asset.controller.TaiSanController;
import asset.controller.TheTaiSanController;
import asset.entity.DVT;
import asset.entity.TaiSan;
import asset.util.DateF;
import asset.util.Message;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;

public class frmAddAsset extends Shell {
	private Label lblTnKhchHng;
	private Label label_1;
	private Text txt_MaTS;
	private Text txt_TenTaiSan;
	private Label lblTnTiSn;
	private Combo cbbDVT;
	private Label lblSLng;
	private Label label_2;
	private Text txt_SoLuong;
	private Label lblNgySDng;
	private Label label_3;
	private Label lblSNmKhu;
	private Label label_4;
	private Text txt_SoNamKH;
	private Label lblNguynGi;
	private Label label_5;
	private Text txt_NguyenGia;
	private Label lblSThng;
	private Text txt_SoThangSD;
	private Label lblTrngThi;
	private Combo cb_TrangThai;
	private DateTime dt_NgaySD;
	public static String maTS;

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmAddAsset(Display display) {
		super(display, SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		maTS = "";
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(34, 35, 94, 15);
		lblNewLabel.setText("Mã tài sản");

		lblTnKhchHng = new Label(this, SWT.NONE);
		lblTnKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnKhchHng.setText("Đơn vị tính");
		lblTnKhchHng.setBounds(247, 35, 94, 15);

		label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setText("*");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setBounds(34, 100, 8, 15);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite.setBounds(0, 356, 435, 50);

		Button btnLuu = new Button(composite, SWT.NONE);
		btnLuu.setImage(SWTResourceManager.getImage(frmAddAsset.class, "/asset/view/page/save_16x16.png"));
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (luu()) {
					maTS = txt_MaTS.getText();
					close();
				}
			}
		});
		btnLuu.setBounds(250, 10, 75, 25);
		btnLuu.setText("L\u01B0u");

		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnHuy.setImage(SWTResourceManager.getImage(frmAddAsset.class, "/asset/view/form/cancel_16x16.png"));
		btnHuy.setBounds(331, 10, 75, 25);
		btnHuy.setText("H\u1EE7y");
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});

		txt_MaTS = new Text(this, SWT.BORDER);
		txt_MaTS.setEditable(false);
		txt_MaTS.setBounds(34, 56, 168, 21);

		txt_TenTaiSan = new Text(this, SWT.BORDER);
		txt_TenTaiSan.setBounds(34, 121, 168, 21);

		lblTnTiSn = new Label(this, SWT.NONE);
		lblTnTiSn.setText("Tên tài sản");
		lblTnTiSn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnTiSn.setBounds(42, 100, 94, 15);

		cbbDVT = new Combo(this, SWT.NONE);
		cbbDVT.setBounds(247, 54, 157, 23);

		lblSLng = new Label(this, SWT.NONE);
		lblSLng.setText("Số lượng");
		lblSLng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSLng.setBounds(255, 100, 94, 15);

		label_2 = new Label(this, SWT.NONE);
		label_2.setText("*");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(247, 100, 8, 15);

		txt_SoLuong = new Text(this, SWT.BORDER);
		txt_SoLuong.setBounds(247, 121, 157, 21);
		txt_SoLuong.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					if (!Character.isDigit(e.text.charAt(i))) {
						e.doit = false;
						return;
					}
				}
			}
		});

		lblNgySDng = new Label(this, SWT.NONE);
		lblNgySDng.setText("Ngày sử dụng");
		lblNgySDng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNgySDng.setBounds(42, 169, 94, 15);

		label_3 = new Label(this, SWT.NONE);
		label_3.setText("*");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(34, 169, 8, 15);

		lblSNmKhu = new Label(this, SWT.NONE);
		lblSNmKhu.setText("Số năm KH");
		lblSNmKhu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSNmKhu.setBounds(255, 169, 94, 15);

		label_4 = new Label(this, SWT.NONE);
		label_4.setText("*");
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(247, 169, 8, 15);

		txt_SoNamKH = new Text(this, SWT.BORDER);
		txt_SoNamKH.setBounds(247, 189, 157, 21);

		txt_SoNamKH.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				// TODO Auto-generated method stub
				if (txt_SoNamKH.getText().equals("")) {
					txt_SoThangSD.setText("0");
				} else {
					try {
						txt_SoThangSD.setText(String.valueOf(Integer.parseInt(txt_SoNamKH.getText()) * 12));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		txt_SoNamKH.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				int valueSoNamKH;
				if (txt_SoNamKH.getText().equals("")) {
					valueSoNamKH = 0;
				} else {
					valueSoNamKH = Integer.parseInt(txt_SoNamKH.getText());
				}
				for (int i = 0; i < e.text.length(); i++) {
					try {
						if (!Character.isDigit(e.text.charAt(i)) || valueSoNamKH > 999999999) {
							e.doit = false;
							return;
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});

		lblNguynGi = new Label(this, SWT.NONE);
		lblNguynGi.setText("Nguyên giá");
		lblNguynGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNguynGi.setBounds(42, 233, 94, 15);

		label_5 = new Label(this, SWT.NONE);
		label_5.setText("*");
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(34, 233, 8, 15);

		txt_NguyenGia = new Text(this, SWT.BORDER);
		txt_NguyenGia.setBounds(34, 254, 168, 21);
		txt_NguyenGia.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					if (!Character.isDigit(e.text.charAt(i))) {
						e.doit = false;
						return;
					}
				}
			}
		});

		lblSThng = new Label(this, SWT.NONE);
		lblSThng.setText("Số tháng sử dụng");
		lblSThng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblSThng.setBounds(247, 233, 94, 15);

		txt_SoThangSD = new Text(this, SWT.BORDER);
		txt_SoThangSD.setText("0");
		txt_SoThangSD.setEditable(false);
		txt_SoThangSD.setBounds(247, 254, 157, 21);
		txt_SoThangSD.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					if (!Character.isDigit(e.text.charAt(i))) {
						e.doit = false;
						return;
					}
				}
			}
		});

		lblTrngThi = new Label(this, SWT.NONE);
		lblTrngThi.setText("Trạng thái");
		lblTrngThi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTrngThi.setBounds(34, 301, 94, 15);

		cb_TrangThai = new Combo(this, SWT.NONE);
		cb_TrangThai.setBounds(34, 322, 168, 23);

		dt_NgaySD = new DateTime(this, SWT.BORDER);
		dt_NgaySD.setBounds(34, 190, 168, 24);
		setTabList(new Control[] { cbbDVT, txt_TenTaiSan, txt_SoLuong, dt_NgaySD, txt_SoNamKH, txt_NguyenGia,
				cb_TrangThai });
		createContents();

		display();
	}
	
	public boolean kiemTraDayDu() {

		if (txt_TenTaiSan.getText().isEmpty()) {
			Message.show("Mời bạn nhập tên tài sản", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		if (txt_SoLuong.getText().isEmpty()) {
			Message.show("Mời bạn nhập số lượng", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		if (txt_SoNamKH.getText().isEmpty()) {
			Message.show("Mời bạn nhập số năm khấu hao", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		if (txt_NguyenGia.getText().isEmpty()) {
			Message.show("Mời bạn nhập nguyên giá", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		return true;
	}
	
	public boolean luu() {
		if (kiemTraDayDu()){
			TaiSan ts = new TaiSan();
			ts.setMaTS(txt_MaTS.getText());
			ts.setTenTS(txt_TenTaiSan.getText());
			ts.setMaDVT((String) cbbDVT.getData(cbbDVT.getText()));
			ts.setSoNamKH(Integer.parseInt(txt_SoNamKH.getText()));
			ts.setSl(Integer.parseInt(txt_SoLuong.getText()));
			ts.setNgaySD(DateF.toDate(dt_NgaySD.getYear(), dt_NgaySD.getMonth() + 1, dt_NgaySD.getDay()));
			ts.setNguyenGia(Integer.parseInt(txt_NguyenGia.getText()));
			ts.setSoThangSD(Integer.parseInt(txt_SoThangSD.getText()));
			ts.setTrangThai(cb_TrangThai.getSelectionIndex());
			try {
				if (!TaiSanController.insert(ts))
					throw new SQLException();

				Message.show("Lưu thông tin tài sản thành công", "Thành công" + ts.getNguyenGia(),
						SWT.OK | SWT.ICON_INFORMATION, getShell());
				return true;
			} catch (Exception e1) {
				e1.printStackTrace();
				Message.show("Không thể lưu thông tin tài sản", "Lỗi", SWT.OK | SWT.ICON_ERROR, getShell());
			}
		}
		return false;
	}

	/**
	 * Display information of asset
	 */
	private void display() {

		cb_TrangThai.add("Đang sử dụng");
		cb_TrangThai.add("Đã khấu hao hết");
		cb_TrangThai.select(0);

		// load data DVT and generate MaTS
		try {
			txt_MaTS.setText(TaiSanController.generateId());
			ArrayList<DVT> arr = DVTController.selectAll();
			for (DVT i : arr) {
				cbbDVT.add(i.getTenDVT());
				cbbDVT.setData(i.getTenDVT(), i.getMaDVT());
			}
			cbbDVT.select(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm mới tài sản");
		setSize(441, 435);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
