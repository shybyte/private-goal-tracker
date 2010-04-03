package marco.stahl.goaltracker.client.utilwidgets;

import java.util.Iterator;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class Cell extends Widget implements HasWidgets, HasText {
	private TableCellElement cellElement;

	public Cell() {
		cellElement = Document.get().createTDElement();
		setElement(cellElement);
	}

	public void setText(String text) {
		cellElement.setInnerText(text);
	}

	@Override
	public void add(Widget w) {
		cellElement.appendChild(w.getElement());
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

	@Override
	public String getText() {
		return null;
	}
}
