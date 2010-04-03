package marco.stahl.goaltracker.client.utilwidgets;

import java.util.Iterator;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class TableRow extends Widget implements HasWidgets{

	private TableRowElement trElement;

	public TableRow() {
		trElement = Document.get().createTRElement();
		setElement(trElement);
	}
	
	public TableRow(String... texts) {
		this();
		for (String text : texts) {
			addCell(text);
		}
	}

	public void addCell(String text) {
		TableCellElement cell = trElement.insertCell(-1);
		cell.setInnerText(text);
	}

	@Override
	public void add(Widget w) {
		trElement.appendChild(w.getElement());
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Widget w) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
