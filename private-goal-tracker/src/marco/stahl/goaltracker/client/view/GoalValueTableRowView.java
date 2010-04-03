package marco.stahl.goaltracker.client.view;

import marco.stahl.goaltracker.client.utilwidgets.TableRow;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;

public class GoalValueTableRowView extends Composite {

	private static GoalValueTableRowViewUiBinder uiBinder = GWT
			.create(GoalValueTableRowViewUiBinder.class);

	interface GoalValueTableRowViewUiBinder extends
			UiBinder<TableRow, GoalValueTableRowView> {
	}

	private TableRow tableRow;

	public GoalValueTableRowView() {
		tableRow = uiBinder.createAndBindUi(this);
		initWidget(tableRow);
		tableRow.addCell("Hossa");
		tableRow.addCell("Mossa");
	}


}
