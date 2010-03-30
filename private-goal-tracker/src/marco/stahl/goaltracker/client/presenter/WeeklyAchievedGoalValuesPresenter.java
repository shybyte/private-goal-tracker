package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.client.view.GoalListView;
import marco.stahl.goaltracker.client.view.GoalTrackerView;
import marco.stahl.goaltracker.shared.WeeklyGoalValues;

import com.google.gwt.user.client.ui.HasWidgets;

public class WeeklyAchievedGoalValuesPresenter implements Presenter
{
	private final WeeklyGoalValues achievedGoalValues;

	public WeeklyAchievedGoalValuesPresenter(WeeklyGoalValues achievedGoalValues) {
		this.achievedGoalValues = achievedGoalValues;		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(new GoalTrackerView());
	}

}
