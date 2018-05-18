package asset.view.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

public class pageLiquidateAsset extends Composite {
	private Table table;
	private Table table_1;
	private Table table_2;
	private Text textDienGiai;
	private Text textSoChungTu;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public pageLiquidateAsset(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.verticalSpacing = 10;
		gridLayout.marginRight = 10;
		gridLayout.marginLeft = 10;
		gridLayout.marginHeight = 10;
		setLayout(gridLayout);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 165;
		composite.setLayoutData(gd_composite);
		
		Group grpThong = new Group(composite, SWT.NONE);
		GridLayout gl_grpThong = new GridLayout(6, false);
		gl_grpThong.verticalSpacing = 15;
		gl_grpThong.horizontalSpacing = 10;
		grpThong.setLayout(gl_grpThong);
		grpThong.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpThong.setText("Th\u00F4ng tin chung");
		
		Label lbThang = new Label(grpThong, SWT.NONE);
		lbThang.setText("Th\u00E1ng");
		
		Combo comboThang = new Combo(grpThong, SWT.NONE);
		comboThang.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lbNam = new Label(grpThong, SWT.NONE);
		lbNam.setAlignment(SWT.RIGHT);
		GridData gd_lbNam = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lbNam.widthHint = 84;
		gd_lbNam.minimumWidth = 100;
		lbNam.setLayoutData(gd_lbNam);
		lbNam.setText("N\u0103m");
		
		Combo comboNam = new Combo(grpThong, SWT.NONE);
		comboNam.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Button btnTimKiem = new Button(grpThong, SWT.NONE);
		GridData gd_btnTimKiem = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_btnTimKiem.widthHint = 100;
		btnTimKiem.setLayoutData(gd_btnTimKiem);
		btnTimKiem.setText("T\u00ECm ki\u1EBFm");
		
		Button btnIn = new Button(grpThong, SWT.NONE);
		GridData gd_btnIn = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnIn.widthHint = 100;
		btnIn.setLayoutData(gd_btnIn);
		btnIn.setText("In");
		
		Label lbDienGiai = new Label(grpThong, SWT.NONE);
		lbDienGiai.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lbDienGiai.setText("Di\u1EC5n gi\u1EA3i");
		
		textDienGiai = new Text(grpThong, SWT.BORDER);
		textDienGiai.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		Button btnThemMoi = new Button(grpThong, SWT.NONE);
		GridData gd_btnThemMoi = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 5, 1);
		gd_btnThemMoi.widthHint = 100;
		btnThemMoi.setLayoutData(gd_btnThemMoi);
		btnThemMoi.setText("Th\u00EAm m\u1EDBi");
		
		Button btnTinh = new Button(grpThong, SWT.NONE);
		GridData gd_btnTinh = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnTinh.widthHint = 100;
		btnTinh.setLayoutData(gd_btnTinh);
		btnTinh.setText("T\u00EDnh");
		new Label(grpThong, SWT.NONE);
		new Label(grpThong, SWT.NONE);
		new Label(grpThong, SWT.NONE);
		new Label(grpThong, SWT.NONE);
		new Label(grpThong, SWT.NONE);
		new Label(grpThong, SWT.NONE);
		
		Group grpThong_1 = new Group(composite, SWT.NONE);
		GridLayout gl_grpThong_1 = new GridLayout(2, false);
		gl_grpThong_1.verticalSpacing = 10;
		gl_grpThong_1.horizontalSpacing = 10;
		grpThong_1.setLayout(gl_grpThong_1);
		GridData gd_grpThong_1 = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_grpThong_1.heightHint = 156;
		gd_grpThong_1.widthHint = 400;
		grpThong_1.setLayoutData(gd_grpThong_1);
		grpThong_1.setText("Th\u00F4ng tin ch\u1EE9ng t\u1EEB");
		
		Label lblNewLabel_3 = new Label(grpThong_1, SWT.NONE);
		lblNewLabel_3.setText("Ng\u00E0y ch\u1EE9ng t\u1EEB");
		
		DateTime dateTime = new DateTime(grpThong_1, SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lbSoChungTu = new Label(grpThong_1, SWT.NONE);
		lbSoChungTu.setText("S\u1ED1 ch\u1EE9ng t\u1EEB");
		
		textSoChungTu = new Text(grpThong_1, SWT.BORDER);
		textSoChungTu.setEnabled(false);
		textSoChungTu.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group grpThong_2 = new Group(composite_1, SWT.NONE);
		grpThong_2.setLayout(new GridLayout(1, false));
		grpThong_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpThong_2.setText("Th\u00F4ng tin chung");
		
		table = new Table(grpThong_2, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.widthHint = 1122;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(217);
		tblclmnNewColumn.setText("M\u00E3 ch\u1EE9ng t\u1EEB");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(136);
		tblclmnNewColumn_1.setText("Ng\u00E0y ch\u1EE9ng t\u1EEB");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(142);
		tblclmnNewColumn_2.setText("Th\u00E1ng");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(118);
		tblclmnNewColumn_7.setText("N\u0103m");
		
		TableColumn tblclmnDinGii = new TableColumn(table, SWT.NONE);
		tblclmnDinGii.setWidth(1168);
		tblclmnDinGii.setText("Di\u1EC5n gi\u1EA3i");
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setLayout(new GridLayout(1, false));
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Group grpThong_3 = new Group(composite_2, SWT.NONE);
		grpThong_3.setLayout(new GridLayout(1, false));
		grpThong_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpThong_3.setText("Th\u00F4ng tin chi ti\u1EBFt");
		
		TabFolder tabFolder = new TabFolder(grpThong_3, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		TabItem tbtmThngTinKhu = new TabItem(tabFolder, SWT.NONE);
		tbtmThngTinKhu.setText("Th\u00F4ng tin kh\u1EA5u hao");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tbtmThngTinKhu.setControl(composite_3);
		composite_3.setLayout(new GridLayout(1, false));
		
		table_1 = new Table(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_3.setWidth(114);
		tblclmnNewColumn_3.setText("M\u00E3 t\u00E0i s\u1EA3n");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_4.setWidth(299);
		tblclmnNewColumn_4.setText("T\u00EAn t\u00E0i s\u1EA3n");
		
		TableColumn tblclmnBPhnS = new TableColumn(table_1, SWT.NONE);
		tblclmnBPhnS.setWidth(184);
		tblclmnBPhnS.setText("B\u1ED9 ph\u1EADn s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnNewColumn_8 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_8.setWidth(134);
		tblclmnNewColumn_8.setText("Nguy\u00EAn gi\u00E1");
		
		TableColumn tblclmnNgySDng = new TableColumn(table_1, SWT.NONE);
		tblclmnNgySDng.setWidth(131);
		tblclmnNgySDng.setText("Ng\u00E0y s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnSThngS = new TableColumn(table_1, SWT.NONE);
		tblclmnSThngS.setWidth(134);
		tblclmnSThngS.setText("S\u1ED1 th\u00E1ng s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnSThng = new TableColumn(table_1, SWT.NONE);
		tblclmnSThng.setWidth(159);
		tblclmnSThng.setText("S\u1ED1 th\u00E1ng \u0111\u00E3 s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnKhuHaoHng = new TableColumn(table_1, SWT.NONE);
		tblclmnKhuHaoHng.setWidth(160);
		tblclmnKhuHaoHng.setText("Kh\u1EA5u hao h\u00E1ng th\u00E1ng");
		
		TableColumn tblclmnKhuHaoTrong = new TableColumn(table_1, SWT.NONE);
		tblclmnKhuHaoTrong.setWidth(158);
		tblclmnKhuHaoTrong.setText("Kh\u1EA5u hao trong th\u00E1ng");
		
		TableColumn tblclmnKhuHaoLy = new TableColumn(table_1, SWT.NONE);
		tblclmnKhuHaoLy.setWidth(128);
		tblclmnKhuHaoLy.setText("Kh\u1EA5u hao l\u0169y k\u1EBF");
		
		TableColumn tblclmnGiTrCn = new TableColumn(table_1, SWT.NONE);
		tblclmnGiTrCn.setWidth(164);
		tblclmnGiTrCn.setText("Gi\u00E1 tr\u1ECB c\u00F2n l\u1EA1i");
		
		TabItem tbtmTiSn = new TabItem(tabFolder, SWT.NONE);
		tbtmTiSn.setText("T\u00E0i s\u1EA3n \u0111\u00E3 kh\u1EA5u hao h\u1EBFt");
		
		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmTiSn.setControl(composite_4);
		composite_4.setLayout(new GridLayout(1, false));
		
		table_2 = new Table(composite_4, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		table_2.setHeaderVisible(true);
		table_2.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_5.setWidth(198);
		tblclmnNewColumn_5.setText("M\u00E3 t\u00E0i s\u1EA3n");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_6.setWidth(460);
		tblclmnNewColumn_6.setText("T\u00EAn t\u00E0i s\u1EA3n");
		
		TableColumn tblclmnBPhnS_1 = new TableColumn(table_2, SWT.NONE);
		tblclmnBPhnS_1.setWidth(193);
		tblclmnBPhnS_1.setText("B\u1ED9 ph\u1EADn s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnNguynGi = new TableColumn(table_2, SWT.NONE);
		tblclmnNguynGi.setWidth(171);
		tblclmnNguynGi.setText("Nguy\u00EAn gi\u00E1");
		
		TableColumn tblclmnNewColumn_9 = new TableColumn(table_2, SWT.NONE);
		tblclmnNewColumn_9.setWidth(216);
		tblclmnNewColumn_9.setText("Ng\u00E0y s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnSThngS_1 = new TableColumn(table_2, SWT.NONE);
		tblclmnSThngS_1.setWidth(240);
		tblclmnSThngS_1.setText("S\u1ED1 th\u00E1ng s\u1EED d\u1EE5ng");
		
		TableColumn tblclmnSThng_1 = new TableColumn(table_2, SWT.NONE);
		tblclmnSThng_1.setWidth(283);
		tblclmnSThng_1.setText("S\u1ED1 th\u00E1ng \u0111\u00E3 s\u1EED d\u1EE5ng");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
