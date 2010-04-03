package marco.stahl.goaltracker.client.utilwidgets;

import java.util.Iterator;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TableRowPanel extends Composite implements HasWidgets{

	private ComfortableTable comfortableTable;
	private Element bodyElement;

	public TableRowPanel() {
		comfortableTable = new ComfortableTable();
		initWidget(comfortableTable);
		bodyElement = comfortableTable.getBodyElement();
	}
	
	public void addTableRow(Widget tableRow) {
		bodyElement.appendChild(tableRow.getElement());
	}

	@Override
	public void add(Widget w) {
		addTableRow(w);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<Widget> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Widget w) {
		throw new UnsupportedOperationException();
	}

}
