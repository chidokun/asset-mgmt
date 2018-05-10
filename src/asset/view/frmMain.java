/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
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
import org.eclipse.swt.widgets.Label;



public class frmMain extends Shell {
	public static boolean isLogout = false;
	private Composite toolToolbar;
	private CTabFolder tabFolder;
	private CTabItem tabItem;
	private Composite composite;


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
		setMinimumSize(new Point(136, 50));
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
		gd_ribbon.heightHint = 50;
		ribbon.setLayoutData(gd_ribbon);

		toolToolbar = new Composite(ribbon, SWT.NONE);
		GridLayout gl_toolToolbar = new GridLayout(1, false);
		gl_toolToolbar.marginBottom = 5;
		gl_toolToolbar.verticalSpacing = 0;
		gl_toolToolbar.marginWidth = 0;
		gl_toolToolbar.marginHeight = 0;
		gl_toolToolbar.horizontalSpacing = 0;
		toolToolbar.setLayout(gl_toolToolbar);
		GridData gd_toolToolbar = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_toolToolbar.heightHint = 49;
		toolToolbar.setLayoutData(gd_toolToolbar);
		toolToolbar.setBackground(SWTResourceManager.getColor(220, 220, 220));

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
}
