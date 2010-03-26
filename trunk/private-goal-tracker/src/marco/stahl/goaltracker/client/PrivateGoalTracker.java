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

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get("app").add(new GoalTrackerView("Hello"));
	}
}
