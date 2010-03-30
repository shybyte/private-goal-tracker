package marco.stahl.goaltracker.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class GoalTrackerView extends Composite {

	private static GoalTrackerViewUiBinder uiBinder = GWT
			.create(GoalTrackerViewUiBinder.class);

	interface GoalTrackerViewUiBinder extends UiBinder<Widget, GoalTrackerView> {
	}

	@UiField
	MainMenu mainMenu;
	
	@UiField
	SimplePanel pageViewPanel;
	
	public GoalTrackerView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	
	public SimplePanel getPageViewPanel() {
		return pageViewPanel;
	}
	
}
