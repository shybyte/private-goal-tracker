package marco.stahl.goaltracker.client.utilwidgets;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.user.client.ui.Widget;

public class TableRow extends Widget{

	private TableRowElement trElement;

	public TableRow() {
		trElement = Document.get().createTRElement();
		setElement(trElement);
	}
	
	public TableRow(String... texts) {
		this();
		for (String text : texts) {
			TableCellElement cell = trElement.insertCell(-1);
			cell.setInnerText(text);
		}
	}
	
}
