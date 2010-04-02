package marco.stahl.goaltracker.client;

import marco.stahl.goaltracker.client.factories.GlobalFactory;
import marco.stahl.goaltracker.client.factories.MyGinjector;
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
	
	MyGinjector injector = GlobalFactory.getInjector();
	
	public void onModuleLoad() {
		final GoalTrackerView goalTrackerView = injector.getGoalTrackerView();
		RootPanel.get("app").add(goalTrackerView);
		AppController appController = injector.getAppController();
		appController.go(goalTrackerView.getPageViewPanel());
	}
}
