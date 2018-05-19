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

public class frmCustomer extends Shell {
	private Text txt_SoTK;
	private Label lblTnKhchHng;
	private Label label_1;
	private Text txt_TenKH;
	private Text txt_MaKH;
	private Text txt_DiaChi;
	private Label label;
	private Label label_2;
	private Label label_3;
	private Label label_4;

	/**
	 * Launch the application.
	 * @param args
	 */
/*	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			frmCustomer shell = new frmCustomer(display);
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
	}*/

	/**
	 * Create the shell.
	 * @param display
	 */
	public frmCustomer(Display display) {
		super(display, SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(null);
		
		txt_SoTK = new Text(this, SWT.BORDER);
		txt_SoTK.setBounds(244, 133, 168, 21);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(34, 35, 94, 15);
		lblNewLabel.setText("M\u00E3 kh\u00E1ch h\u00E0ng");
		
		lblTnKhchHng = new Label(this, SWT.NONE);
		lblTnKhchHng.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTnKhchHng.setText("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblTnKhchHng.setBounds(252, 35, 94, 15);
		
		label_1 = new Label(this, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setText("*");
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setBounds(34, 112, 8, 15);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(245, 245, 245));
		composite.setBounds(0, 201, 444, 50);
		
		Button btnLuu = new Button(composite, SWT.NONE);
		btnLuu.setImage(SWTResourceManager.getImage(frmCustomer.class, "/asset/view/page/save_16x16.png"));
		btnLuu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnLuu.setBounds(244, 10, 75, 25);
		btnLuu.setText("L\u01B0u");
		
		Button btnHuy = new Button(composite, SWT.NONE);
		btnHuy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnHuy.setImage(SWTResourceManager.getImage(frmCustomer.class, "/asset/view/form/cancel_16x16.png"));
		btnHuy.setBounds(338, 10, 75, 25);
		btnHuy.setText("H\u1EE7y");
		
		txt_TenKH = new Text(this, SWT.BORDER);
		txt_TenKH.setBounds(244, 56, 168, 21);
		
		txt_MaKH = new Text(this, SWT.BORDER);
		txt_MaKH.setEditable(false);
		txt_MaKH.setBounds(34, 56, 168, 21);
		
		txt_DiaChi = new Text(this, SWT.BORDER);
		txt_DiaChi.setBounds(34, 133, 168, 21);
		
		label = new Label(this, SWT.NONE);
		label.setText("\u0110\u1ECBa ch\u1EC9");
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(42, 112, 94, 15);
		
		label_2 = new Label(this, SWT.NONE);
		label_2.setText("*");
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setBounds(244, 35, 8, 15);
		
		label_3 = new Label(this, SWT.NONE);
		label_3.setText("*");
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setBounds(244, 112, 8, 15);
		
		label_4 = new Label(this, SWT.NONE);
		label_4.setText("S\u1ED1 t\u00E0i kho\u1EA3n");
		label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_4.setBounds(252, 112, 94, 15);
		setTabList(new Control[]{txt_DiaChi, txt_TenKH, txt_SoTK, composite});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Thêm mới khách hàng");
		setSize(450, 280);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
