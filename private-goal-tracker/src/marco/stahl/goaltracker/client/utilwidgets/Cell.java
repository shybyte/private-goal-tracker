package marco.stahl.goaltracker.client.utilwidgets;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class Cell extends ComplexPanel {
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
		add(w, getElement());
	}

	
}
