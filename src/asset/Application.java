/**
 * Asset Management
 */
package asset;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.*;
import asset.util.*;
import asset.view.*;
import asset.view.form.*;

public class Application {
	private static Display display = Display.getDefault();
	private static frmMain shellMain; 
	private static int result;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Settings.load();
			shellMain = new frmMain(display);
			shellMain.setMaximized(true);
			
			
			if (ketNoiCSDL())
				Window.open(shellMain);
			else
				ketNoiLai();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Kiểm tra kết nối CSDL
	 * 
	 * @return
	 */
	public static boolean ketNoiCSDL() {
		try {
			Database.load();
			Database.connect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * Hiển thị giao diện kết nối lại CSDL
	 */
	public static void ketNoiLai() {
		// hiện form kết nối lại
		frmKetNoiCSDL shell = new frmKetNoiCSDL(display);
		shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent arg0) {
				result = shell.result;
			}
		});

		Window.open(shell);

		switch (result) {
		case SWT.OK:
			Message.show("Vui lòng khởi động lại chương trình", "Khởi động lại chương trình",
					SWT.ICON_INFORMATION | SWT.OK, shellMain);

			break;
		case SWT.CANCEL:
			Message.show("Bạn có thể cài đặt lại kết nối cơ sở dữ liệu khi chạy lại chương trình.",
					"Kết nối cơ sở dữ liệu", SWT.ICON_INFORMATION | SWT.OK, shellMain);
		}
	}
}
