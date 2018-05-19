package asset.view.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Combo;

public class frmAddAsset extends Shell {
	private Label lblTnKhchHng;
	private Label label_1;
	private Text txt_MaTS;
	private Text txt_TenTaiSan;
	private Label lblTnTiSn;


	/**
	 * Create the shell.
	 * @param display
	 */
	public frmAddAsset(Display display) {
		super(display, SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(34, 35, 94, 15);
		lblNewLabel.setText("Mã tài sản");
		
		lblTnKhchHng = new Label(this, SWT.NONE);
		lblTnKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnKhchHng.setText("Đơn vị tính");
		lblTnKhchHng.setBounds(244, 35, 94, 15);
		
		label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setText("*");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setBounds(34, 112, 8, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite.setBounds(0, 201, 367, 50);
		
		Button btnLuu = new Button(composite, SWT.NONE);
		btnLuu.setImage(SWTResourceManager.getImage(frmAddAsset.class, "/asset/view/page/save_16x16.png"));
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLuu.setBounds(164, 10, 75, 25);
		btnLuu.setText("L\u01B0u");
		
		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnHuy.setImage(SWTResourceManager.getImage(frmAddAsset.class, "/asset/view/form/cancel_16x16.png"));
		btnHuy.setBounds(266, 10, 75, 25);
		btnHuy.setText("H\u1EE7y");
		
		txt_MaTS = new Text(this, SWT.BORDER);
		txt_MaTS.setEditable(false);
		txt_MaTS.setBounds(34, 56, 168, 21);
		
		txt_TenTaiSan = new Text(this, SWT.BORDER);
		txt_TenTaiSan.setBounds(34, 133, 304, 21);
		
		lblTnTiSn = new Label(this, SWT.NONE);
		lblTnTiSn.setText("Tên tài sản");
		lblTnTiSn.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnTiSn.setBounds(42, 112, 94, 15);
		
		Combo cbbDVT = new Combo(this, SWT.NONE);
		cbbDVT.setBounds(247, 54, 91, 23);
		setTabList(new Control[]{txt_TenTaiSan, composite});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm mới tài sản");
		setSize(373, 280);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
