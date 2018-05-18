package asset.view.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;

public class frmCreateAsset extends Shell {
	private Text txtSoThe;
	private Text txtNamSD;
	private Text txtBoPhanSD;
	private Text txtMaTS;
	private Text txtLyDoDinhChi;
	private Text txtNgayLap;
	private Text txtTenTaiSan;
	private Text txtNguyenGia;
	private Text txtNamDinhChi;
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			frmCreateAsset shell = new frmCreateAsset(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmCreateAsset(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.MAX | SWT.TITLE);
		setSize(665, 576);
		setModified(true);
		setTouchEnabled(true);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setImage(SWTResourceManager.getImage(frmCreateAsset.class, "/asset/view/form/imgVe_64p.png"));
		lblNewLabel.setBounds(56, 10, 69, 64);

		Label lblVuiLngNhp = new Label(this, SWT.NONE);
		lblVuiLngNhp.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblVuiLngNhp.setBounds(135, 40, 180, 15);
		lblVuiLngNhp.setText("Vui lòng nhập đầy đủ thông tin");

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel_1.setBounds(56, 80, 90, 15);
		lblNewLabel_1.setText("Số thẻ");

		txtSoThe = new Text(this, SWT.BORDER);
		txtSoThe.setEnabled(false);
		txtSoThe.setBounds(152, 77, 151, 21);

		Label lblNmSDng = new Label(this, SWT.NONE);
		lblNmSDng.setText("Năm sử dụng");
		lblNmSDng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNmSDng.setBounds(56, 166, 90, 15);

		txtNamSD = new Text(this, SWT.BORDER);
		txtNamSD.setEnabled(false);
		txtNamSD.setBounds(152, 163, 151, 21);

		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Bộ phận sử dụng");
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(56, 212, 90, 15);

		txtBoPhanSD = new Text(this, SWT.BORDER);
		txtBoPhanSD.setBounds(152, 209, 151, 21);

		Label label = new Label(this, SWT.NONE);
		label.setText("Mã tài sản");
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(56, 124, 90, 15);

		txtMaTS = new Text(this, SWT.BORDER);
		txtMaTS.setEnabled(false);
		txtMaTS.setBounds(152, 121, 151, 21);

		Label lblLDonh = new Label(this, SWT.NONE);
		lblLDonh.setText("Lý do đình chỉ");
		lblLDonh.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblLDonh.setBounds(56, 255, 90, 15);

		txtLyDoDinhChi = new Text(this, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtLyDoDinhChi.setBounds(152, 255, 450, 47);

		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Ngày lập");
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setBounds(355, 83, 90, 15);

		txtNgayLap = new Text(this, SWT.BORDER);
		txtNgayLap.setEnabled(false);
		txtNgayLap.setBounds(451, 80, 151, 21);

		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Tên tài sản");
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(355, 127, 90, 15);

		txtTenTaiSan = new Text(this, SWT.BORDER);
		txtTenTaiSan.setEnabled(false);
		txtTenTaiSan.setBounds(451, 124, 151, 21);

		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Nguyên giá");
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(355, 169, 90, 15);

		txtNguyenGia = new Text(this, SWT.BORDER);
		txtNguyenGia.setEnabled(false);
		txtNguyenGia.setBounds(451, 166, 151, 21);

		Label label_5 = new Label(this, SWT.NONE);
		label_5.setText("Năm đình chỉ");
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setBounds(355, 212, 90, 15);

		txtNamDinhChi = new Text(this, SWT.BORDER);
		txtNamDinhChi.setBounds(451, 209, 151, 21);

		Composite composite = new Composite(this, SWT.NONE);
		composite.setBounds(0, 491, 661, 56);

		Button btnLuuIn = new Button(composite, SWT.NONE);
		btnLuuIn.setImage(SWTResourceManager.getImage(frmCreateAsset.class, "/asset/view/page/save_16x16.png"));
		btnLuuIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLuuIn.setBounds(448, 10, 94, 33);
		btnLuuIn.setText("Lưu và in");

		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.setImage(SWTResourceManager.getImage(frmCreateAsset.class, "/asset/view/page/cancel_16x16.png"));
		btnHuy.setBounds(550, 10, 94, 33);
		btnHuy.setText("Hủy bỏ");

		table = new Table(this, SWT.BORDER | SWT.MULTI);
		table.setBounds(24, 328, 611, 136);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setWidth(0);

		TableColumn columnSoHieuCT = new TableColumn(table, SWT.NONE);
		columnSoHieuCT.setWidth(100);
		columnSoHieuCT.setText("Số hiệu chứng từ");

		TableColumn columnNgay = new TableColumn(table, SWT.NONE);
		columnNgay.setWidth(100);
		columnNgay.setText("Ngày");

		TableColumn columnDienGiai = new TableColumn(table, SWT.NONE);
		columnDienGiai.setText("Diễn giải");
		columnDienGiai.setWidth(100);

		TableColumn columnNam = new TableColumn(table, SWT.NONE);
		columnNam.setWidth(100);
		columnNam.setText("Năm");

		TableColumn columnGiaTriHaoMon = new TableColumn(table, SWT.NONE);
		columnGiaTriHaoMon.setWidth(100);
		columnGiaTriHaoMon.setText("Giá trị hao mòn");

		TableColumn columnCongDon = new TableColumn(table, SWT.NONE);
		columnCongDon.setWidth(100);
		columnCongDon.setText("Cộng dồn");

		for (int i = 0; i < 10; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
		}

		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		table.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {
							final int column = i;
							final Text text = new Text(table, SWT.NONE);
							Listener textListener = new Listener() {
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, text.getText());
										text.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, text.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											text.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};
							text.addListener(SWT.FocusOut, textListener);
							text.addListener(SWT.Traverse, textListener);
							editor.setEditor(text, item, i);
							text.setText(item.getText(i));
							text.selectAll();
							text.setFocus();
							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Lập thẻ tài sản");
		setSize(677, 576);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
