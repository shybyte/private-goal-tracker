package marco.stahl.goaltracker.client;

import marco.stahl.goaltracker.client.utilwidgets.TableRow;
import marco.stahl.goaltracker.client.utilwidgets.TableRowPanel;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class WidgetGallery implements EntryPoint {

	@Override
	public void onModuleLoad() {
		TableRowPanel tableRowPanel = new TableRowPanel();
		tableRowPanel.addTableRow(new TableRow("Hu","Toll"));
		tableRowPanel.addTableRow(new TableRow("Huhuhuhu","Toll","Supi!"));
		RootPanel.get().add(tableRowPanel);
	}

}
