package marco.stahl.goaltracker.client.utilwidgets;

import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class TableRowPanel extends ComplexPanel {

	private ComfortableTable comfortableTable;

	public TableRowPanel() {
		comfortableTable = new ComfortableTable();
		setElement(comfortableTable.getElement());
	}

	public void addTableRow(Widget tableRow) {
		add(tableRow);
	}

	@Override
	public void add(Widget w) {
		add(w, comfortableTable.getBodyElement());
	}

}
