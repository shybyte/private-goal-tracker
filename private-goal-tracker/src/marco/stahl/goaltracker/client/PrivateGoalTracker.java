package marco.stahl.goaltracker.client;

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
		AppController appController = new AppController();
		appController.go(RootPanel.get("app"));
	}
}
