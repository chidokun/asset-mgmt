/**
 * Asset Management
 */
package asset;

import org.eclipse.swt.widgets.*;
import asset.util.*;
import asset.view.*;

public class Application {
	private static Display display = Display.getDefault();
	private static frmMain shellMain; 

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Settings.load();
			shellMain = new frmMain(display);
			Window.open(shellMain);
		} catch (Exception e) {
			
		}
	}
}
