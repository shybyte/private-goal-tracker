package marco.stahl.goaltracker.client.factories;

import marco.stahl.goaltracker.client.AppController;
import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter;
import marco.stahl.goaltracker.client.view.GoalTrackerView;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(MyModule.class)
public interface MyGinjector extends Ginjector {
	GoalTrackerView getGoalTrackerView();
	AppController getAppController();
	WeeklyGoalValuesPresenter getWeeklyGoalValuesPresenter();
}
