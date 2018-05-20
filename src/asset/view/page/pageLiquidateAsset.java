package asset.view.page;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import asset.controller.HoaDonController;
import asset.controller.KhachHangController;
import asset.controller.KhoController;
import asset.controller.NhanVienController;
import asset.controller.QuyenController;
import asset.controller.TKKTController;
import asset.controller.TaiSanController;
import asset.entity.KhachHang;
import asset.entity.Kho;
import asset.entity.NhanVien;
import asset.entity.Quyen;
import asset.entity.TaiSan;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class pageLiquidateAsset extends Composite {
	private Combo cboMaKho;
	private Combo cboQuyen;
	private Combo cboMaKH;
	private Combo cboHinhThucThanhToan;
	private Combo cboMaNV;
	private Text txtTimKiem;
	private Table tableTaiSan;
	private Text txtSoHoaDon;
	private Text txtTaiKhoanKhach;
	private Text txtTaiKhoan;
	private Text txtTenKho;
	private Text txtTenKhachHang;
	private Text txtTySuatGTGT;
	private Text txtTenTaiKhoan;
	private Text txtMauSo;
	private Text txtKyHieu;
	private Text txtLyDo;
	private Table table_1;
	private Text text_11;
	private Text text_12;
	private HashMap<Integer, String> mapTKKT;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageLiquidateAsset(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.marginRight = 10;
		gl_composite.marginLeft = 10;
		gl_composite.marginHeight = 10;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 292;
		composite.setLayoutData(gd_composite);
		
		Group grpDanhSchTi = new Group(composite, SWT.NONE);
		grpDanhSchTi.setLayout(new GridLayout(2, false));
		grpDanhSchTi.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpDanhSchTi.setText("Danh sách tài sản");
		
		txtTimKiem = new Text(grpDanhSchTi, SWT.BORDER);
		txtTimKiem.setToolTipText("Tìm theo tên");
		GridData gd_txtTimKiem = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTimKiem.heightHint = 20;
		txtTimKiem.setLayoutData(gd_txtTimKiem);
		
		Button btnTimKiem = new Button(grpDanhSchTi, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ArrayList<TaiSan> arrTS = TaiSanController.search(txtTimKiem.getText());
					tableTaiSan.removeAll();
					if(arrTS != null) {
						for (TaiSan ts : arrTS) {
							TableItem item = new TableItem(tableTaiSan, SWT.NONE);
							item.setText(new String[] { ts.getMaTS(), ts.getTenTS() });
						}
						tableTaiSan.select(0);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}	
			}
		});
		btnTimKiem.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/zoom_16x16.png"));
		GridData gd_btnTimKiem = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnTimKiem.widthHint = 100;
		gd_btnTimKiem.heightHint = 30;
		btnTimKiem.setLayoutData(gd_btnTimKiem);
		btnTimKiem.setText("Tìm kiếm");
		
		tableTaiSan = new Table(grpDanhSchTi, SWT.BORDER | SWT.FULL_SELECTION);
		tableTaiSan.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		tableTaiSan.setHeaderVisible(true);
		tableTaiSan.setLinesVisible(true);
		
		TableColumn tblclmnMaTaiSan = new TableColumn(tableTaiSan, SWT.NONE);
		tblclmnMaTaiSan.setWidth(98);
		tblclmnMaTaiSan.setText("Mã tài sản");
		
		TableColumn tblclmnTenTaiSan = new TableColumn(tableTaiSan, SWT.NONE);
		tblclmnTenTaiSan.setWidth(144);
		tblclmnTenTaiSan.setText("Tên tài sản");
		
		Composite composite_2 = new Composite(grpDanhSchTi, SWT.NONE);
		GridLayout gl_composite_2 = new GridLayout(2, false);
		gl_composite_2.marginWidth = 0;
		composite_2.setLayout(gl_composite_2);
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		
		Button btnTaoMoi = new Button(composite_2, SWT.NONE);
		btnTaoMoi.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/add_16x16.png"));
		GridData gd_btnTaoMoi = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnTaoMoi.widthHint = 80;
		gd_btnTaoMoi.heightHint = 30;
		btnTaoMoi.setLayoutData(gd_btnTaoMoi);
		btnTaoMoi.setText("Tạo mới");
		
		Button btnChon = new Button(composite_2, SWT.NONE);
		btnChon.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/yes_16x16.png"));
		GridData gd_btnChon = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnChon.heightHint = 30;
		btnChon.setLayoutData(gd_btnChon);
		btnChon.setText("Chọn vào danh sách");
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.marginLeft = 10;
		gl_composite_1.marginRight = 10;
		gl_composite_1.marginHeight = 10;
		composite_1.setLayout(gl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group grpPhiuNhp = new Group(composite_1, SWT.NONE);
		grpPhiuNhp.setLayout(new GridLayout(2, false));
		grpPhiuNhp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpPhiuNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		grpPhiuNhp.setText("Thanh lý tài sản");
		
		Composite composite_3 = new Composite(grpPhiuNhp, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_3 = new GridLayout(2, false);
		gl_composite_3.verticalSpacing = 10;
		gl_composite_3.horizontalSpacing = 10;
		gl_composite_3.marginRight = 10;
		gl_composite_3.marginLeft = 10;
		gl_composite_3.marginHeight = 10;
		composite_3.setLayout(gl_composite_3);
		GridData gd_composite_3 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_3.heightHint = 288;
		composite_3.setLayoutData(gd_composite_3);
		
		Label lblNewLabel = new Label(composite_3, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setText("Mã kho:");
		
		cboMaKho = new Combo(composite_3, SWT.NONE);
		cboMaKho.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtTenKho.setText((String) cboMaKho.getData(cboMaKho.getText()));
			}
		});
		GridData gd_cboMaKho = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_cboMaKho.heightHint = 22;
		cboMaKho.setLayoutData(gd_cboMaKho);
		
		Label lblSThT = new Label(composite_3, SWT.NONE);
		lblSThT.setText("Số hóa đơn:");
		lblSThT.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtSoHoaDon = new Text(composite_3, SWT.BORDER);
		txtSoHoaDon.setEnabled(false);
		GridData gd_txtSoHoaDon = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtSoHoaDon.heightHint = 20;
		txtSoHoaDon.setLayoutData(gd_txtSoHoaDon);
		
		Label lblQuyn = new Label(composite_3, SWT.NONE);
		lblQuyn.setText("Quyển:");
		lblQuyn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		cboQuyen = new Combo(composite_3, SWT.NONE);
		cboQuyen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] quyen = ((String) cboQuyen.getData(cboQuyen.getText())).split(";");
				txtMauSo.setText(quyen[0]);
				txtKyHieu.setText(quyen[1]);
			}
		});
		cboQuyen.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMKhchHng = new Label(composite_3, SWT.NONE);
		lblMKhchHng.setText("Mã khách hàng:");
		lblMKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Composite composite_7 = new Composite(composite_3, SWT.NONE);
		composite_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_7 = new GridLayout(2, false);
		gl_composite_7.marginWidth = 0;
		gl_composite_7.marginHeight = 0;
		composite_7.setLayout(gl_composite_7);
		composite_7.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		cboMaKH = new Combo(composite_7, SWT.NONE);
		GridData gd_cboMaKH = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_cboMaKH.heightHint = 22;
		cboMaKH.setLayoutData(gd_cboMaKH);
		
		Button btnNewKH = new Button(composite_7, SWT.NONE);
		btnNewKH.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/add_16x16.png"));
		GridData gd_btnNewKH = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewKH.heightHint = 26;
		btnNewKH.setLayoutData(gd_btnNewKH);
		
		Label lblTiKhonKhch = new Label(composite_3, SWT.NONE);
		lblTiKhonKhch.setText("Tài khoản khách:");
		lblTiKhonKhch.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTaiKhoanKhach = new Text(composite_3, SWT.BORDER);
		txtTaiKhoanKhach.setEnabled(false);
		GridData gd_txtTaiKhoanKhach = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTaiKhoanKhach.heightHint = 20;
		txtTaiKhoanKhach.setLayoutData(gd_txtTaiKhoanKhach);
		
		Label lblSHan = new Label(composite_3, SWT.NONE);
		lblSHan.setText("Tài khoản:");
		lblSHan.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTaiKhoan = new Text(composite_3, SWT.BORDER);
		txtTaiKhoan.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				try {
					String number = txtTaiKhoan.getText().substring(1);
					txtTenTaiKhoan.setText(mapTKKT.get(Integer.parseInt(number)));
				} catch (Exception e) {
					e.printStackTrace();
					txtTenTaiKhoan.setText("");
				}
			}
		});
		GridData gd_txtTaiKhoan = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTaiKhoan.heightHint = 20;
		txtTaiKhoan.setLayoutData(gd_txtTaiKhoan);
		
		Label lblHnhThcThanh_1 = new Label(composite_3, SWT.NONE);
		lblHnhThcThanh_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblHnhThcThanh_1.setText("Hình thức thanh toán:");
		lblHnhThcThanh_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		cboHinhThucThanhToan = new Combo(composite_3, SWT.NONE);
		GridData gd_cboHinhThucThanhToan = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_cboHinhThucThanhToan.heightHint = 20;
		cboHinhThucThanhToan.setLayoutData(gd_cboHinhThucThanhToan);
		
		Label lblLDo = new Label(composite_3, SWT.NONE);
		lblLDo.setText("Lý do:");
		lblLDo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtLyDo = new Text(composite_3, SWT.BORDER);
		GridData gd_txtLyDo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtLyDo.heightHint = 20;
		txtLyDo.setLayoutData(gd_txtLyDo);
		
		Composite composite_4 = new Composite(grpPhiuNhp, SWT.NONE);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_4 = new GridLayout(2, false);
		gl_composite_4.verticalSpacing = 10;
		gl_composite_4.marginRight = 10;
		gl_composite_4.marginLeft = 10;
		gl_composite_4.marginHeight = 10;
		gl_composite_4.horizontalSpacing = 10;
		composite_4.setLayout(gl_composite_4);
		GridData gd_composite_4 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite_4.heightHint = 258;
		composite_4.setLayoutData(gd_composite_4);
		
		Label lblTnKho = new Label(composite_4, SWT.NONE);
		lblTnKho.setText("Tên kho:");
		lblTnKho.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTenKho = new Text(composite_4, SWT.BORDER);
		txtTenKho.setEnabled(false);
		GridData gd_txtTenKho = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTenKho.heightHint = 20;
		txtTenKho.setLayoutData(gd_txtTenKho);
		
		Label lblNgyLp = new Label(composite_4, SWT.NONE);
		lblNgyLp.setText("Ngày phát hành:");
		lblNgyLp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		DateTime dateNgayLap = new DateTime(composite_4, SWT.BORDER);
		GridData gd_dateNgayLap = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dateNgayLap.heightHint = 25;
		dateNgayLap.setLayoutData(gd_dateNgayLap);
		
		Label lblMuS = new Label(composite_4, SWT.NONE);
		lblMuS.setText("Mẫu số:");
		lblMuS.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Composite composite_8 = new Composite(composite_4, SWT.NONE);
		composite_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		composite_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_8 = new GridLayout(3, false);
		gl_composite_8.marginWidth = 0;
		gl_composite_8.marginHeight = 0;
		composite_8.setLayout(gl_composite_8);
		
		txtMauSo = new Text(composite_8, SWT.BORDER);
		txtMauSo.setEnabled(false);
		GridData gd_txtMauSo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtMauSo.heightHint = 20;
		txtMauSo.setLayoutData(gd_txtMauSo);
		
		Label lblKHiu = new Label(composite_8, SWT.NONE);
		lblKHiu.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		lblKHiu.setText("Ký hiệu:");
		lblKHiu.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtKyHieu = new Text(composite_8, SWT.BORDER);
		txtKyHieu.setEnabled(false);
		GridData gd_txtKyHieu = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtKyHieu.heightHint = 20;
		txtKyHieu.setLayoutData(gd_txtKyHieu);
		
		Label lblTnKhchHng = new Label(composite_4, SWT.NONE);
		lblTnKhchHng.setText("Tên khách hàng:");
		lblTnKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTenKhachHang = new Text(composite_4, SWT.BORDER);
		txtTenKhachHang.setEnabled(false);
		GridData gd_txtTenKhachHang = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTenKhachHang.heightHint = 20;
		txtTenKhachHang.setLayoutData(gd_txtTenKhachHang);
		
		Label lblTSutGtgt = new Label(composite_4, SWT.NONE);
		lblTSutGtgt.setText("Tỷ suất GTGT (%):");
		lblTSutGtgt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTySuatGTGT = new Text(composite_4, SWT.BORDER);
		txtTySuatGTGT.setText("10");
		GridData gd_txtTySuatGTGT = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTySuatGTGT.heightHint = 20;
		txtTySuatGTGT.setLayoutData(gd_txtTySuatGTGT);
		
		Label lblTnTiKhon = new Label(composite_4, SWT.NONE);
		lblTnTiKhon.setText("Tên tài khoản:");
		lblTnTiKhon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		txtTenTaiKhoan = new Text(composite_4, SWT.BORDER);
		txtTenTaiKhoan.setEnabled(false);
		GridData gd_txtTenTaiKhoan = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTenTaiKhoan.heightHint = 20;
		txtTenTaiKhoan.setLayoutData(gd_txtTenTaiKhoan);
		
		Label lblNgyThanhTon = new Label(composite_4, SWT.NONE);
		lblNgyThanhTon.setText("Ngày thanh toán:");
		lblNgyThanhTon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		DateTime dateNgayThanhToan = new DateTime(composite_4, SWT.BORDER);
		GridData gd_dateNgayThanhToan = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dateNgayThanhToan.heightHint = 25;
		dateNgayThanhToan.setLayoutData(gd_dateNgayThanhToan);
		
		Label lblMNhnVin = new Label(composite_4, SWT.NONE);
		lblMNhnVin.setText("Mã nhân viên:");
		lblMNhnVin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		cboMaNV = new Combo(composite_4, SWT.NONE);
		cboMaNV.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_5 = new Composite(grpPhiuNhp, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_5 = new GridLayout(2, false);
		gl_composite_5.marginBottom = 5;
		gl_composite_5.verticalSpacing = 10;
		gl_composite_5.marginRight = 10;
		gl_composite_5.marginLeft = 10;
		gl_composite_5.marginHeight = 0;
		gl_composite_5.horizontalSpacing = 10;
		composite_5.setLayout(gl_composite_5);
		composite_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		table_1 = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("TKDU");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Mã tài sản");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Nguyên giá");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("ĐVT");
		
		TableColumn tblclmnSLng = new TableColumn(table_1, SWT.NONE);
		tblclmnSLng.setWidth(100);
		tblclmnSLng.setText("Số lượng");
		
		TableColumn tblclmnNgySDng = new TableColumn(table_1, SWT.NONE);
		tblclmnNgySDng.setWidth(100);
		tblclmnNgySDng.setText("Ngày sử dụng");
		
		TableColumn tblclmnSNmKh = new TableColumn(table_1, SWT.NONE);
		tblclmnSNmKh.setWidth(100);
		tblclmnSNmKh.setText("Số năm KH");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Mã nhân viên");
		
		
		Composite composite_6 = new Composite(grpPhiuNhp, SWT.NONE);
		GridLayout gl_composite_6 = new GridLayout(2, false);
		gl_composite_6.verticalSpacing = 0;
		gl_composite_6.marginWidth = 0;
		gl_composite_6.marginHeight = 0;
		gl_composite_6.horizontalSpacing = 0;
		composite_6.setLayout(gl_composite_6);
		GridData gd_composite_6 = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		gd_composite_6.heightHint = 128;
		composite_6.setLayoutData(gd_composite_6);
		composite_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Composite composite_9 = new Composite(composite_6, SWT.NONE);
		composite_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_9 = new GridLayout(2, false);
		gl_composite_9.verticalSpacing = 10;
		gl_composite_9.marginRight = 10;
		gl_composite_9.marginLeft = 10;
		gl_composite_9.marginHeight = 0;
		gl_composite_9.horizontalSpacing = 10;
		composite_9.setLayout(gl_composite_9);
		composite_9.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Label lblTiKhon = new Label(composite_9, SWT.NONE);
		lblTiKhon.setText("Tài khoản:");
		lblTiKhon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_11 = new Text(composite_9, SWT.BORDER);
		GridData gd_text_11 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_11.heightHint = 20;
		text_11.setLayoutData(gd_text_11);
		
		Label lblTiSn = new Label(composite_9, SWT.NONE);
		lblTiSn.setText("Tài sản:");
		lblTiSn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		text_12 = new Text(composite_9, SWT.BORDER);
		GridData gd_text_12 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_12.heightHint = 20;
		text_12.setLayoutData(gd_text_12);
		
		Label lblSTinBng = new Label(composite_9, SWT.NONE);
		lblSTinBng.setText("Số tiền bằng chữ:");
		lblSTinBng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_3 = new Label(composite_9, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setText("Mã kho:");
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Composite composite_11 = new Composite(composite_9, SWT.NONE);
		composite_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_11 = new GridLayout(2, false);
		gl_composite_11.verticalSpacing = 0;
		gl_composite_11.marginWidth = 0;
		gl_composite_11.marginHeight = 0;
		gl_composite_11.horizontalSpacing = 10;
		composite_11.setLayout(gl_composite_11);
		composite_11.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		Button btnNewButton_1 = new Button(composite_11, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/save_16x16.png"));
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 100;
		gd_btnNewButton_1.heightHint = 30;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("Lưu và in");
		
		Button btnNewButton_3 = new Button(composite_11, SWT.NONE);
		btnNewButton_3.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/refresh_16x16.png"));
		GridData gd_btnNewButton_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_3.widthHint = 80;
		gd_btnNewButton_3.heightHint = 30;
		btnNewButton_3.setLayoutData(gd_btnNewButton_3);
		btnNewButton_3.setText("Hoàn lại");
	
		
		Composite composite_10 = new Composite(composite_6, SWT.NONE);
		composite_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_10 = new GridLayout(2, false);
		gl_composite_10.verticalSpacing = 10;
		gl_composite_10.marginRight = 10;
		gl_composite_10.marginLeft = 10;
		gl_composite_10.marginHeight = 0;
		gl_composite_10.horizontalSpacing = 10;
		composite_10.setLayout(gl_composite_10);
		GridData gd_composite_10 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite_10.widthHint = 250;
		composite_10.setLayoutData(gd_composite_10);
		
		Label lblTinHng = new Label(composite_10, SWT.NONE);
		lblTinHng.setText("Tiền hàng:");
		lblTinHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_6 = new Label(composite_10, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label_6.setText("Tài khoản:");
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblPh = new Label(composite_10, SWT.NONE);
		lblPh.setText("Phí:");
		lblPh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_7 = new Label(composite_10, SWT.NONE);
		label_7.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label_7.setText("Tài khoản:");
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblCng = new Label(composite_10, SWT.NONE);
		lblCng.setText("Cộng:");
		lblCng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_8 = new Label(composite_10, SWT.NONE);
		label_8.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label_8.setText("Tài khoản:");
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblThuGtgt = new Label(composite_10, SWT.NONE);
		lblThuGtgt.setText("Thuế GTGT:");
		lblThuGtgt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_9 = new Label(composite_10, SWT.NONE);
		label_9.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_9.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_9.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label_9.setText("Tài khoản:");
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label lblTrGi = new Label(composite_10, SWT.NONE);
		lblTrGi.setText("Trị giá:");
		lblTrGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Label label_10 = new Label(composite_10, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		label_10.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		label_10.setText("Tài khoản:");
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		initialize();
	}
	
	private void initialize() {
		//load tai san
		ArrayList<TaiSan> arrTS = TaiSanController.selectTop(50);
		tableTaiSan.removeAll();
		if(arrTS != null) {
			for (TaiSan ts : arrTS) {
				TableItem item = new TableItem(tableTaiSan, SWT.NONE);
				item.setText(new String[] { ts.getMaTS(), ts.getTenTS() });
			}
			tableTaiSan.select(0);
		}
		
		//load kho
		ArrayList<Kho> arrKho = KhoController.selectAll();
		cboMaKho.removeAll();
		for (Kho i : arrKho) {
			cboMaKho.add(i.getMaKho());
			cboMaKho.setData(i.getMaKho(), i.getTenKho());
		}
		cboMaKho.select(0);
		txtTenKho.setText((String) cboMaKho.getData(cboMaKho.getText()));
		
		//generate hoa don
		txtSoHoaDon.setText(HoaDonController.generateId());
		
		//load quyen
		ArrayList<Quyen> arrQuyen = QuyenController.selectAll();
		cboQuyen.removeAll();
		for (Quyen i : arrQuyen) {
			cboQuyen.add(i.getQuyen());
			cboQuyen.setData(i.getQuyen(), i.getMauSo() + ";" + i.getKyHieu());
		}
		cboQuyen.select(0);
		String[] quyen = ((String) cboQuyen.getData(cboQuyen.getText())).split(";");
		txtMauSo.setText(quyen[0]);
		txtKyHieu.setText(quyen[1]);
		
		//load khachHang
		ArrayList<KhachHang> arrKhachHang = KhachHangController.selectAll();
		cboMaKH.removeAll();
		for (KhachHang i : arrKhachHang) {
			cboMaKH.add(i.getMaKH());
			cboMaKH.setData(i.getMaKH(), i);
		}
		cboMaKH.select(0);
		KhachHang kh = (KhachHang) cboMaKH.getData(cboMaKH.getText());
		txtTenKhachHang.setText(kh.getTenKH());
		txtTaiKhoanKhach.setText(kh.getSoTK());
		
		//load TKKT
		mapTKKT = TKKTController.selectAll();
		
		//load hinh thuc
		cboHinhThucThanhToan.add("Tiền mặt");
		cboHinhThucThanhToan.add("Chuyển khoảng");
		cboHinhThucThanhToan.select(0);
		
		//generate hoa don
		txtSoHoaDon.setText(HoaDonController.generateId());
		
		//load nhan vien
		ArrayList<NhanVien> arrNV = NhanVienController.selectAll();
		cboMaNV.removeAll();
		for (NhanVien i : arrNV) {
			cboMaNV.add(i.getMaNV());
		}
		cboMaNV.select(0);		
	}


	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
