/**
 * Quản lý Rạp chiếu phim RPP
 * Author_giaodien: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 * Author_xuly: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package asset.view.page;

import java.util.ArrayList;

import org.eclipse.core.commands.ParameterValuesException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import asset.controller.TaiSanController;
import asset.controller.TheTaiSanController;
import asset.entity.TaiSan;
import asset.entity.TheTaiSan;
import asset.util.Window;
import asset.view.form.frmAddAsset;
import asset.view.form.frmCreateAsset;
import asset.view.form.frmCustomer;
import asset.util.*;

public class pageSearchAsset extends Composite {
	private Text txtTenTaiSan;
	private Button btnTimKiem;
	private Table gridTaiSan;
	private Button btnLapThe;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public pageSearchAsset(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);

		Composite composite = new Composite(this, SWT.NONE);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 280;
		composite.setLayoutData(gd_composite);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblTraCuKha = new Label(composite, SWT.NONE);
		lblTraCuKha.setText("Tra cứu tài sản");
		lblTraCuKha.setForeground(SWTResourceManager.getColor(31, 116, 71));
		lblTraCuKha.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblTraCuKha.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTraCuKha.setBounds(29, 17, 176, 23);

		txtTenTaiSan = new Text(composite, SWT.BORDER);
		txtTenTaiSan.setBounds(29, 85, 228, 25);

		btnTimKiem = new Button(composite, SWT.NONE);
		btnTimKiem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				search();
			}
		});
		btnTimKiem.setText("Tìm kiếm");
		btnTimKiem.setImage(SWTResourceManager.getImage(pageSearchAsset.class, "/asset/view/page/zoom_16x16.png"));
		btnTimKiem.setBounds(171, 131, 86, 30);

		Label lblTnTiSn = new Label(composite, SWT.NONE);
		lblTnTiSn.setBounds(29, 60, 55, 15);
		lblTnTiSn.setText("Tên tài sản");

		Composite composite_1 = new Composite(this, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.marginWidth = 15;
		gl_composite_1.marginTop = 10;
		gl_composite_1.marginBottom = 15;
		composite_1.setLayout(gl_composite_1);
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite_1.widthHint = 841;
		gd_composite_1.heightHint = 427;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnLapThe = new Button(composite_1, SWT.NONE);
		btnLapThe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*
				 * Window.open( new frmCustomer(getDisplay()));
				 */
				try {
					checkAssetSelected();
					String maTS = gridTaiSan.getSelection()[0].getText(1);
					if (TheTaiSanController.select(maTS) == null) {
						Window.open(frmCreateAsset.createNewAssetForm(getDisplay(), "Lập thẻ tài sản",
								TaiSanController.select(maTS)));
					} else {
						boolean result = MessageDialog.openConfirm(getShell(), "Thông báo",
								"Tài sản này đã có thẻ tài sản. Bạn có muốn xem thẻ tài sản này?");
						if (result) {
							Window.open(new frmCreateAsset(getDisplay(), false, "Xem thẻ tài sản",
									TheTaiSanController.select(maTS), TaiSanController.select(maTS)));
						}
					}

				} catch (ParameterValuesException e1) {
					Message.show(e1.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridData gd_btnLapThe = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnLapThe.heightHint = 30;
		gd_btnLapThe.widthHint = 114;
		btnLapThe.setLayoutData(gd_btnLapThe);
		btnLapThe.setText("Lập thẻ tài sản");
		btnLapThe.setImage(SWTResourceManager.getImage(pageSearchAsset.class, "/asset/view/page/print_16x16.png"));
		
		Button btnHienTatCa = new Button(composite_1, SWT.NONE);
		btnHienTatCa.setImage(SWTResourceManager.getImage(pageSearchAsset.class, "/asset/view/page/show_16x16.png"));
		btnHienTatCa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				displayAllAsset();
			}
		});
		btnHienTatCa.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnHienTatCa.setText("Hiện tất cả");

		gridTaiSan = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridTaiSan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});

		GridData gd_gridTaiSan = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_gridTaiSan.widthHint = 695;
		gd_gridTaiSan.heightHint = 143;
		gridTaiSan.setLayoutData(gd_gridTaiSan);
		gridTaiSan.setHeaderVisible(true);
		gridTaiSan.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(gridTaiSan, SWT.NONE);
		tblclmnNewColumn.setWidth(45);
		tblclmnNewColumn.setText("STT");

		TableColumn tblclmnNewColumn_1 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(140);
		tblclmnNewColumn_1.setText("Mã tài sản");

		TableColumn tblclmnNewColumn_2 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(180);
		tblclmnNewColumn_2.setText("Tên tài sản");

		TableColumn tblclmnNewColumn_3 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(160);
		tblclmnNewColumn_3.setText("Nguyên giá");

		TableColumn tblclmnNewColumn_4 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(170);
		tblclmnNewColumn_4.setText("Số năm khấu hao");

		TableColumn tblclmnNewColumn_5 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(170);
		tblclmnNewColumn_5.setText("Ngày sử dụng");

		displayAllAsset();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	/**
	 * Search asset
	 */
	public void search() {
		try {
			validate();
			ArrayList<TaiSan> arr = TaiSanController.search(txtTenTaiSan.getText());

			gridTaiSan.removeAll();
			int stt = 1;
			for (TaiSan ts : arr) {
				TableItem item = new TableItem(gridTaiSan, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), ts.getMaTS(), ts.getTenTS(),
						String.valueOf(ts.getNguyenGia()), String.valueOf(ts.getSoNamKH()),
						DateF.toString((ts.getNgaySD())) });
				stt++;
			}

			gridTaiSan.select(0);
		} catch (ParameterValuesException e) {
			Message.show(e.getMessage(), "Cảnh báo", SWT.ICON_WARNING | SWT.OK, getShell());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validate input for search
	 */
	public void validate() throws ParameterValuesException {
		if (txtTenTaiSan.getText().isEmpty())
			throw new ParameterValuesException("Bạn cần nhập tên tài sản", null);
	}

	/**
	 * Check if asset is selected to create asset form
	 */
	public void checkAssetSelected() throws ParameterValuesException {
		if (gridTaiSan.getItemCount() == 0) {
			throw new ParameterValuesException("Bạn cần tìm kiếm tài sản muốn lập thẻ", null);
		}
		if (gridTaiSan.getSelection()[0] == null) {
			throw new ParameterValuesException("Bạn cần chọn tài sản muốn lập thẻ", null);
		}
	}

	/**
	 * Display all asset
	 */
	public void displayAllAsset() {
		try {
			ArrayList<TaiSan> arr = TaiSanController.selectAll();

			gridTaiSan.removeAll();
			int stt = 1;
			for (TaiSan ts : arr) {
				TableItem item = new TableItem(gridTaiSan, SWT.NONE);
				item.setText(new String[] { String.valueOf(stt), ts.getMaTS(), ts.getTenTS(),
						String.valueOf(ts.getNguyenGia()), String.valueOf(ts.getSoNamKH()),
						DateF.toString((ts.getNgaySD())) });
				stt++;
			}
			gridTaiSan.select(0);
			txtTenTaiSan.setText("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
