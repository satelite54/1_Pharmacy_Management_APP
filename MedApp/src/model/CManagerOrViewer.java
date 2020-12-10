package model;

public class CManagerOrViewer {
	private static CManagerOrViewer printer = null;

	private static int ManagerOrViewerstatic;

	public static CManagerOrViewer getInstance() {
		if(printer == null) {
			printer = new CManagerOrViewer();
		}
		return printer;
	}

	public int getManagerOrViewer() {
		return ManagerOrViewerstatic;
	}
	public void setManagerOrViewer(int ManagerOrViewer) {
		ManagerOrViewerstatic = ManagerOrViewer;
	}
}