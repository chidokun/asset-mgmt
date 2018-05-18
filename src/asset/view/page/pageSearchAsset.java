/**
 * Quản lý Rạp chiếu phim RPP
 * Author_giaodien: Hồ Thị Kim Hoàng - hohoang.ag.96@gmail.com
 * Author_xuly: Huỳnh Duy Anh Toàn - anhtoan441996@gmail.com
 */

package asset.view.page;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


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
		gd_composite_1.widthHint = 348;
		gd_composite_1.heightHint = 427;
		composite_1.setLayoutData(gd_composite_1);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		btnLapThe = new Button(composite_1, SWT.NONE);
		btnLapThe.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		GridData gd_btnLapThe = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnLapThe.heightHint = 30;
		gd_btnLapThe.widthHint = 114;
		btnLapThe.setLayoutData(gd_btnLapThe);
		btnLapThe.setText("Lập thẻ tài sản");
		btnLapThe.setImage(SWTResourceManager.getImage(pageSearchAsset.class, "/asset/view/page/print_16x16.png"));
		new Label(composite_1, SWT.NONE);

		gridTaiSan = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		gridTaiSan.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		GridData gd_gridTaiSan = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_gridTaiSan.widthHint = 750;
		gd_gridTaiSan.heightHint = 143;
		gridTaiSan.setLayoutData(gd_gridTaiSan);
		gridTaiSan.setHeaderVisible(true);
		gridTaiSan.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(gridTaiSan, SWT.NONE);
		tblclmnNewColumn.setWidth(34);
		tblclmnNewColumn.setText("STT");

		TableColumn tblclmnNewColumn_1 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("Mã tài sản");

		TableColumn tblclmnNewColumn_2 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(183);
		tblclmnNewColumn_2.setText("Tên tài sản");

		TableColumn tblclmnNewColumn_3 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(146);
		tblclmnNewColumn_3.setText("Nguyên giá");

		TableColumn tblclmnNewColumn_4 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(137);
		tblclmnNewColumn_4.setText("Số năm khấu hao");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(gridTaiSan, SWT.CENTER);
		tblclmnNewColumn_5.setWidth(131);
		tblclmnNewColumn_5.setText("Số ngày sử dụng");


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}