/**
 * Asset Management
 */

package asset.view;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import asset.view.page.pageLiquidateAsset;
import asset.view.page.pageExportAsset;
import asset.view.page.pageImportAsset;
import asset.view.page.pageDepreciationAsset;
import asset.view.page.pageSearchAsset;
import asset.util.Window;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;



public class frmMain extends Shell {
	public static boolean isLogout = false;
	private Composite toolToolbar;
	private CTabFolder tabFolder;
	private CTabItem tabItem;
	private Composite composite;
	private CLabel lblNhapTaiSan;
	private CLabel lblBanTaiSan;
	private CLabel lblThanhLyTaiSan;
	private CLabel lblTinhKhauHao;
	private CLabel lblLapThe;


	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public frmMain(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		isLogout = false;
		setSize(1038, 604);
		setText("Quản lý Tài sản");
		setMinimumSize(new Point(1300, 700));
		setBackground(SWTResourceManager.getColor(230, 230, 230));
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		gridLayout.horizontalSpacing = 0;
		setLayout(gridLayout);

		Composite ribbon = new Composite(this, SWT.NONE);
		ribbon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_ribbon = new GridLayout(1, false);
		gl_ribbon.verticalSpacing = 0;
		gl_ribbon.marginWidth = 0;
		gl_ribbon.marginHeight = 0;
		gl_ribbon.horizontalSpacing = 0;
		ribbon.setLayout(gl_ribbon);
		GridData gd_ribbon = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_ribbon.heightHint = 64;
		ribbon.setLayoutData(gd_ribbon);

		toolToolbar = new Composite(ribbon, SWT.NONE);
		GridLayout gl_toolToolbar = new GridLayout(5, false);
		gl_toolToolbar.marginLeft = 7;
		gl_toolToolbar.marginWidth = 0;
		gl_toolToolbar.marginHeight = 7;
		toolToolbar.setLayout(gl_toolToolbar);
		GridData gd_toolToolbar = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_toolToolbar.heightHint = 49;
		toolToolbar.setLayoutData(gd_toolToolbar);
		toolToolbar.setBackground(SWTResourceManager.getColor(240, 240, 240));
		
		lblNhapTaiSan = new CLabel(toolToolbar, SWT.NONE);
		lblNhapTaiSan.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblNhapTaiSan);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblNhapTaiSan);
			}
		});
		lblNhapTaiSan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblNhapTaiSan);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblNhapTaiSan);
				Window.openPageInTab(tabFolder, new pageImportAsset(tabFolder, SWT.NONE), "Nhập Tài sản");
			}
		});
		GridData gd_lblNhapTaiSan = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_lblNhapTaiSan.heightHint = 50;
		gd_lblNhapTaiSan.widthHint = 140;
		lblNhapTaiSan.setLayoutData(gd_lblNhapTaiSan);
		lblNhapTaiSan.setText("Nhập Tài sản");
		lblNhapTaiSan.setImage(SWTResourceManager.getImage(frmMain.class, "/asset/view/buy_32.png"));
		lblNhapTaiSan.setBackground(SWTResourceManager.getColor(240, 240, 240));
		
		lblBanTaiSan = new CLabel(toolToolbar, SWT.NONE);
		lblBanTaiSan.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblBanTaiSan);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblBanTaiSan);
			}
		});
		lblBanTaiSan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblBanTaiSan);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblBanTaiSan);
				Window.openPageInTab(tabFolder, new pageExportAsset(tabFolder, SWT.NONE), "Bán Tài sản");
			}
		});
		lblBanTaiSan.setImage(SWTResourceManager.getImage(frmMain.class, "/asset/view/sell_32.png"));
		GridData gd_lblBanTaiSan = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblBanTaiSan.heightHint = 50;
		gd_lblBanTaiSan.widthHint = 132;
		lblBanTaiSan.setLayoutData(gd_lblBanTaiSan);
		lblBanTaiSan.setText("Bán Tài sản");
		
		lblThanhLyTaiSan = new CLabel(toolToolbar, SWT.NONE);
		lblThanhLyTaiSan.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblThanhLyTaiSan);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblThanhLyTaiSan);
			}
		});
		lblThanhLyTaiSan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblThanhLyTaiSan);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblThanhLyTaiSan);
				Window.openPageInTab(tabFolder, new pageLiquidateAsset(tabFolder, SWT.NONE), "Thanh lý Tài sản");
			}
		});
		lblThanhLyTaiSan.setImage(SWTResourceManager.getImage(frmMain.class, "/asset/view/out_32.png"));
		GridData gd_lblThanhLyTaiSan = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblThanhLyTaiSan.heightHint = 50;
		gd_lblThanhLyTaiSan.widthHint = 150;
		lblThanhLyTaiSan.setLayoutData(gd_lblThanhLyTaiSan);
		lblThanhLyTaiSan.setText("Thanh lý Tài sản");
		
		lblTinhKhauHao = new CLabel(toolToolbar, SWT.NONE);
		lblTinhKhauHao.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblTinhKhauHao);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblTinhKhauHao);
			}
		});
		lblTinhKhauHao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblTinhKhauHao);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblTinhKhauHao);
				Window.openPageInTab(tabFolder, new pageDepreciationAsset(tabFolder, SWT.NONE), "Khấu hao Tài sản");
			}
		});
		lblTinhKhauHao.setImage(SWTResourceManager.getImage(frmMain.class, "/asset/view/cal_32.png"));
		GridData gd_lblTinhKhauHao = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTinhKhauHao.heightHint = 50;
		gd_lblTinhKhauHao.widthHint = 186;
		lblTinhKhauHao.setLayoutData(gd_lblTinhKhauHao);
		lblTinhKhauHao.setText("Tính khấu hao Tài sản");
		
		lblLapThe = new CLabel(toolToolbar, SWT.NONE);
		lblLapThe.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseEnterColor(lblLapThe);
			}
			@Override
			public void mouseExit(MouseEvent e) {
				mouseExitColor(lblLapThe);
			}
		});
		lblLapThe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				mouseDownColor(lblLapThe);
			}
			@Override
			public void mouseUp(MouseEvent e) {
				mouseEnterColor(lblLapThe);
				Window.openPageInTab(tabFolder, new pageSearchAsset(tabFolder, SWT.NONE), "Lập thẻ tài sản");
			}
		});
		lblLapThe.setImage(SWTResourceManager.getImage(frmMain.class, "/asset/view/card_32.png"));
		GridData gd_lblLapThe = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblLapThe.heightHint = 50;
		gd_lblLapThe.widthHint = 146;
		lblLapThe.setLayoutData(gd_lblLapThe);
		lblLapThe.setText("Lập thẻ Tài sản");

		tabFolder = new CTabFolder(this, SWT.CLOSE | SWT.FLAT);
		tabFolder.setSelectionBackground(SWTResourceManager.getColor(241, 241, 241));
		tabFolder.setTabHeight(26);
		tabFolder.setBackground(SWTResourceManager.getColor(230, 230, 230));
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("Chào mừng");

		composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void mouseEnterColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(220, 220, 220));
	}

	public void mouseExitColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(240, 240, 240));
	}

	public void mouseDownColor(CLabel item) {
		item.setBackground(SWTResourceManager.getColor(200, 200, 200));
	}
}
