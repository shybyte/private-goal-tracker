package marco.stahl.goaltracker.client;

import marco.stahl.goaltracker.client.view.GoalTrackerView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PrivateGoalTracker implements EntryPoint {
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	
	public void onModuleLoad() {
		GoalTrackerView goalTrackerView = new GoalTrackerView();
		RootPanel.get("app").add(goalTrackerView);
		AppController appController = new AppController(goalTrackerView.getMainMenu());
		appController.go(goalTrackerView.getPageViewPanel());
	}
}
