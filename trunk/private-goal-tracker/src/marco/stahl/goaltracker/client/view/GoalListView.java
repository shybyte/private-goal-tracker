package marco.stahl.goaltracker.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;

public class GoalListView extends Composite {

	private static GoalListViewUiBinder uiBinder = GWT
			.create(GoalListViewUiBinder.class);

	interface GoalListViewUiBinder extends UiBinder<Grid, GoalListView> {
	}

	public GoalListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	

}
