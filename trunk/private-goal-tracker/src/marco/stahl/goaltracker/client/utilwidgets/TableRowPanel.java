package marco.stahl.goaltracker.client.utilwidgets;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;

public class TableRowPanel extends Composite {

	private ComfortableTable comfortableTable;
	private Element bodyElement;

	public TableRowPanel() {
		comfortableTable = new ComfortableTable();
		initWidget(comfortableTable);
		bodyElement = comfortableTable.getBodyElement();
	}
	
	public void addTableRow(TableRow tableRow) {
		bodyElement.appendChild(tableRow.getElement());
	}

}
