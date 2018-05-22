package asset.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

import asset.controller.*;
import asset.entity.*;
import asset.util.DateF;
import asset.util.MathF;
import asset.util.Message;
import asset.util.Window;
import asset.view.form.frmAddAsset;
import asset.view.form.frmCustomer;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class pageImportAsset extends Composite {
	private Combo cboMaKho;
	private Combo cboQuyen;
	private Combo cboMaKH;
	private Combo cboHinhThucThanhToan;
	private Combo cboMaNV;
	private Text txtSoPhieuNhap;
	private Text txtTaiKhoanKhach;
	private Text txtTaiKhoan;
	private Text txtSoHoaDon;
	private Text txtTenKho;
	private Text txtTenKhachHang;
	private Text txtTySuatGTGT;
	private Text txtTenTaiKhoan;
	private Text txtMauSo;
	private Text txtKyHieu;
	private Text txtLyDo;
	private Text txtTongTien;
	private Text txtTienThue;
	private Text txtSoTienBangChu;
	private Text txtTriGia;
	private Table tableDSTS;
	private DateTime dateNgayLap;
	private DateTime dateNgayPhatHanh;
	private HashMap<Integer, String> mapTKKT;
	private DateTime dateNgayThanhToan;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageImportAsset(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

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
		grpPhiuNhp.setText("Phiếu nhập");

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
		gd_composite_3.heightHint = 320;
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
		lblSThT.setText("Số phiếu nhập:");
		lblSThT.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtSoPhieuNhap = new Text(composite_3, SWT.BORDER);
		txtSoPhieuNhap.setEnabled(false);
		GridData gd_txtSoPhieuNhap = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtSoPhieuNhap.heightHint = 20;
		txtSoPhieuNhap.setLayoutData(gd_txtSoPhieuNhap);

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
		cboMaKH.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				KhachHang kh = (KhachHang) cboMaKH.getData(cboMaKH.getText());
				txtTenKhachHang.setText(kh.getTenKH());
				txtTaiKhoanKhach.setText(kh.getSoTK());
			}
		});
		GridData gd_cboMaKH = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_cboMaKH.heightHint = 22;
		cboMaKH.setLayoutData(gd_cboMaKH);

		Button btnNewKH = new Button(composite_7, SWT.NONE);
		btnNewKH.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Window.open(new frmCustomer(getDisplay()));

				String maKH = frmCustomer.maKH;
				if (!maKH.equals("")) {
					try {
						KhachHang kh = KhachHangController.select(maKH);
						cboMaKH.add(kh.getMaKH());
						cboMaKH.setData(kh.getMaKH(), kh);
						int size = cboMaKH.getItemCount();
						cboMaKH.select(size - 1);
						txtTenKhachHang.setText(kh.getTenKH());
						txtTaiKhoanKhach.setText(kh.getSoTK());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
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

		Label lblHnhThcThanh = new Label(composite_3, SWT.NONE);
		lblHnhThcThanh.setText("Số hóa đơn:");
		lblHnhThcThanh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

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
		GridData gd_txtLyDo = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
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
		gd_composite_4.heightHint = 292;
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
		lblNgyLp.setText("Ngày lập:");
		lblNgyLp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		dateNgayLap = new DateTime(composite_4, SWT.BORDER);
		GridData gd_dateNgayLap = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dateNgayLap.heightHint = 25;
		dateNgayLap.setLayoutData(gd_dateNgayLap);

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

		Label lblNgyPhtHnh = new Label(composite_4, SWT.NONE);
		lblNgyPhtHnh.setText("Ngày phát hành:");
		lblNgyPhtHnh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		dateNgayPhatHanh = new DateTime(composite_4, SWT.BORDER);
		GridData gd_dateNgayPhatHanh = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dateNgayPhatHanh.heightHint = 25;
		dateNgayPhatHanh.setLayoutData(gd_dateNgayPhatHanh);

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

		Label lblNgyThanhTon = new Label(composite_4, SWT.NONE);
		lblNgyThanhTon.setText("Ngày thanh toán:");
		lblNgyThanhTon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		dateNgayThanhToan = new DateTime(composite_4, SWT.BORDER);
		GridData gd_dateNgayThanhToan = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_dateNgayThanhToan.heightHint = 25;
		dateNgayThanhToan.setLayoutData(gd_dateNgayThanhToan);

		Label lblMNhnVin = new Label(composite_4, SWT.NONE);
		lblMNhnVin.setText("Mã nhân viên:");
		lblMNhnVin.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		cboMaNV = new Combo(composite_4, SWT.NONE);
		cboMaNV.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		cboMaNV.select(0);

		Composite composite_5 = new Composite(grpPhiuNhp, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_5 = new GridLayout(2, false);
		gl_composite_5.verticalSpacing = 10;
		gl_composite_5.marginRight = 10;
		gl_composite_5.marginLeft = 10;
		gl_composite_5.horizontalSpacing = 10;
		composite_5.setLayout(gl_composite_5);
		composite_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Button btnThemTaiSan = new Button(composite_5, SWT.NONE);
		btnThemTaiSan.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/add_16x16.png"));
		btnThemTaiSan.setText("Thêm tài sản");
		btnThemTaiSan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Window.open(new frmAddAsset(getDisplay()));

				Text textTKDU = new Text(tableDSTS, SWT.NONE);

				String maTS = frmAddAsset.maTS;
				if (!maTS.equals("")) {
					try {
						TaiSan ts = TaiSanController.select(maTS);
						TableItem item = new TableItem(tableDSTS, SWT.NONE);

						TableEditor editor = new TableEditor(tableDSTS);
						textTKDU.addModifyListener(new ModifyListener() {
							public void modifyText(ModifyEvent arg0) {
								try {
									String number = textTKDU.getText().substring(1);
									item.setText(1, mapTKKT.get(Integer.parseInt(number)));
								} catch (Exception e) {
									e.printStackTrace();
									item.setText(1, "");
								}
							}
						});
						editor.grabHorizontal = true;
						editor.setEditor(textTKDU, item, 0);

						item.setText(2, ts.getMaTS());
						item.setText(3, ts.getTenTS());
						item.setText(4, ts.getNguyenGia() + "");
						item.setText(5, DVTController.select(ts.getMaDVT()).getTenDVT());
						item.setText(6, ts.getSl() + "");
						item.setText(7, DateF.toString(ts.getNgaySD()));
						item.setText(8, String.valueOf(ts.getSoNamKH()));
						item.setText(9, ts.getSl() * ts.getNguyenGia() + "");
						tableDSTS.select(0);
					} catch (Exception ex) {
						ex.printStackTrace();
						Message.show("Có lỗi xảy ra2!", "Lỗi", SWT.ICON_ERROR | SWT.OK, getShell());
					}
				}

			}
		});
		new Label(composite_5, SWT.NONE);

		tableDSTS = new Table(composite_5, SWT.BORDER | SWT.FULL_SELECTION);
		tableDSTS.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		tableDSTS.setHeaderVisible(true);
		tableDSTS.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("TKDU");

		TableColumn tblclmnTnTiKhon = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnTnTiKhon.setWidth(100);
		tblclmnTnTiKhon.setText("Tên tài khoản");

		TableColumn tblclmnNewColumn_1 = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Mã tài sản");

		TableColumn tblclmnNewColumn_4 = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("Tên tài sản");

		TableColumn tblclmnNewColumn_2 = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Nguyên giá");

		TableColumn tblclmnNewColumn_3 = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("ĐVT");

		TableColumn tblclmnSLng = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnSLng.setWidth(100);
		tblclmnSLng.setText("Số lượng");

		TableColumn tblclmnNgySDng = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnNgySDng.setWidth(100);
		tblclmnNgySDng.setText("Ngày sử dụng");

		TableColumn tblclmnSNmKh = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnSNmKh.setWidth(100);
		tblclmnSNmKh.setText("Số năm KH");

		TableColumn tblclmnThnhTin = new TableColumn(tableDSTS, SWT.NONE);
		tblclmnThnhTin.setWidth(100);
		tblclmnThnhTin.setText("Thành tiền");

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

		Label lblTrGi = new Label(composite_9, SWT.NONE);
		lblTrGi.setText("Trị giá:");
		lblTrGi.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtTriGia = new Text(composite_9, SWT.BORDER);
		txtTriGia.setEditable(false);
		txtTriGia.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		txtTriGia.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_txtTriGia = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTriGia.heightHint = 20;
		txtTriGia.setLayoutData(gd_txtTriGia);

		Label lblSTinBng = new Label(composite_9, SWT.NONE);
		lblSTinBng.setText("Số tiền bằng chữ:");
		lblSTinBng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtSoTienBangChu = new Text(composite_9, SWT.BORDER);
		txtSoTienBangChu.setEditable(false);
		txtSoTienBangChu.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		txtSoTienBangChu.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_txtSoTienBangChu = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtSoTienBangChu.heightHint = 25;
		txtSoTienBangChu.setLayoutData(gd_txtSoTienBangChu);

		Composite composite_11 = new Composite(composite_9, SWT.NONE);
		composite_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_composite_11 = new GridLayout(3, false);
		gl_composite_11.verticalSpacing = 0;
		gl_composite_11.marginWidth = 0;
		gl_composite_11.marginHeight = 0;
		gl_composite_11.horizontalSpacing = 10;
		composite_11.setLayout(gl_composite_11);
		composite_11.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		Button btnTinhTien = new Button(composite_11, SWT.NONE);
		btnTinhTien.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					long tongTien = 0;
					TableItem[] items = tableDSTS.getItems();
					for (TableItem i : items) {
						tongTien += Long.parseLong(i.getText(9));
					}
					double thue = Integer.parseInt(txtTySuatGTGT.getText()) * tongTien / 100.0;
					long triGia = (long) Math.ceil(tongTien + thue);
					txtTriGia.setText(String.valueOf(triGia));
					txtTongTien.setText(String.valueOf(tongTien));
					txtTienThue.setText(String.valueOf(thue));
					txtSoTienBangChu.setText(MathF.readNum(triGia));
				} catch (Exception ex) {
					ex.printStackTrace();
					txtTriGia.setText("");
					txtTongTien.setText("");
					txtTienThue.setText("");
					txtSoTienBangChu.setText("");
					Message.show("Có lỗi xảy ra", "Lỗi", SWT.ICON_ERROR | SWT.OK, getShell());
				}
			}
		});
		btnTinhTien.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		GridData gd_btnTinhTien = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnTinhTien.heightHint = 30;
		btnTinhTien.setLayoutData(gd_btnTinhTien);
		btnTinhTien.setText("Tính tiền");
		btnTinhTien.setImage(
				SWTResourceManager.getImage(pageExportAsset.class, "/asset/view/page/fullstackedline_16x16.png"));

		Button btnNewButton_1 = new Button(composite_11, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				save();

			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/save_16x16.png"));
		GridData gd_btnNewButton_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 100;
		gd_btnNewButton_1.heightHint = 30;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("Lưu và in");

		Button btnNewButton_3 = new Button(composite_11, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_3
				.setImage(SWTResourceManager.getImage(pageImportAsset.class, "/asset/view/page/refresh_16x16.png"));
		GridData gd_btnNewButton_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_3.widthHint = 80;
		gd_btnNewButton_3.heightHint = 30;
		btnNewButton_3.setLayoutData(gd_btnNewButton_3);
		btnNewButton_3.setText("Hoàn lại");
		new Label(composite_11, SWT.NONE);
		new Label(composite_11, SWT.NONE);
		new Label(composite_11, SWT.NONE);

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
		gd_composite_10.widthHint = 300;
		composite_10.setLayoutData(gd_composite_10);

		Label lblTongTien = new Label(composite_10, SWT.NONE);
		lblTongTien.setText("Tổng tiền hàng:");
		lblTongTien.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtTongTien = new Text(composite_10, SWT.BORDER);
		txtTongTien.setEditable(false);
		txtTongTien.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		txtTongTien.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_txtTongTien = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTongTien.heightHint = 20;
		txtTongTien.setLayoutData(gd_txtTongTien);

		Label lblThueGTGT = new Label(composite_10, SWT.NONE);
		lblThueGTGT.setText("Thuế GTGT:");
		lblThueGTGT.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		txtTienThue = new Text(composite_10, SWT.BORDER);
		txtTienThue.setEditable(false);
		txtTienThue.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		txtTienThue.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_txtTienThue = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtTienThue.heightHint = 20;
		txtTienThue.setLayoutData(gd_txtTienThue);
		initialize();
	}

	/**
	 * Kiểm tra thông tin đầy đủ chưa
	 */
	public boolean kiemTraDayDu() {

		if (txtLyDo.getText().isEmpty()) {
			Message.show("Mời bạn nhập lý do", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;
		}
		if (txtTaiKhoan.getText().isEmpty()) {
			Message.show("Mời bạn nhập tài khoản", "Thông báo", SWT.OK | SWT.ICON_INFORMATION, getShell());
			return false;

		}
		return true;
	}

	private void save() {
		if (kiemTraDayDu()) {
			try {
				PhieuNhap pn = new PhieuNhap();
				HoaDon hd = new HoaDon();
				ArrayList<TaiSan> arr = new ArrayList<>();

				pn.setMaPN(txtSoPhieuNhap.getText());
				pn.setNgayLap(DateF.toDate(dateNgayLap.getYear(), dateNgayLap.getMonth(), dateNgayLap.getDay()));
				pn.setLyDo(txtLyDo.getText());
				pn.setTaiKhoanChinh(txtTaiKhoan.getText());
				pn.setThueGTGT(Integer.parseInt(txtTySuatGTGT.getText()));
				pn.setMaKH((String) cboMaKH.getText());
				pn.setMaNV((String) cboMaNV.getText());
				pn.setMaKho((String) cboMaKho.getText());

				hd.setSoHD(txtSoHoaDon.getText());
				hd.setNgayPhatHanh(DateF.toDate(dateNgayPhatHanh.getYear(), dateNgayPhatHanh.getMonth(),
						dateNgayPhatHanh.getDay()));
				hd.setNgayThanhToan(DateF.toDate(dateNgayThanhToan.getYear(), dateNgayThanhToan.getMonth(),
						dateNgayThanhToan.getDay()));
				hd.setHinhThucThanhToan(cboHinhThucThanhToan.getText());
				hd.setThueGTGT(Integer.parseInt(txtTySuatGTGT.getText()));
				hd.setTongTien(Integer.parseInt(txtTongTien.getText()));
				hd.setQuyen(cboQuyen.getText());
				hd.setMaKho(cboMaKho.getText());
				hd.setMaKH(cboMaKH.getText());
				hd.setMaNV(cboMaNV.getText());
				hd.setLyDo(txtLyDo.getText());
				hd.setTaiKhoanChinh(txtTaiKhoan.getText());

				TableItem[] items = tableDSTS.getItems();
				for (TableItem i : items) {
					TaiSan ts = TaiSanController.select(i.getText(2));
					ts.setTaiKhoanDU(i.getText(0));
				}

				if (PhieuNhapController.insert(pn, hd, arr)) {
					Message.show("Lưu phiếu nhập thành công", "Thành công", SWT.ICON_INFORMATION | SWT.OK, getShell());

					// in
				} else {
					Message.show("Lưu phiếu nhập không thành công", "Thất bại", SWT.ICON_ERROR | SWT.OK, getShell());
				}
			} catch (Exception e) {
				e.printStackTrace();
				Message.show("Lưu phiếu nhập không thành công", "Thất bại", SWT.ICON_ERROR | SWT.OK, getShell());
			}
		}
	}

	private void initialize() {
		// generate id
		txtSoPhieuNhap.setText(PhieuNhapController.generateID());

		// load kho
		ArrayList<Kho> arrKho = KhoController.selectAll();
		cboMaKho.removeAll();
		for (Kho i : arrKho) {
			cboMaKho.add(i.getMaKho());
			cboMaKho.setData(i.getMaKho(), i.getTenKho());
		}
		cboMaKho.select(0);
		txtTenKho.setText((String) cboMaKho.getData(cboMaKho.getText()));

		// load quyen
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

		// load khachHang
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

		// load TKKT
		mapTKKT = TKKTController.selectAll();

		// load hinh thuc
		cboHinhThucThanhToan.add("Tiền mặt");
		cboHinhThucThanhToan.add("Chuyển khoản");
		cboHinhThucThanhToan.select(0);

		// generate hoa don
		txtSoHoaDon.setText(HoaDonController.generateId());

		// load nhan vien
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
