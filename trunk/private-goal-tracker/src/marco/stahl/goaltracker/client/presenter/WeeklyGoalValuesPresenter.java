package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.client.view.GoalTrackerView;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.WeeklyGoalValues;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class WeeklyGoalValuesPresenter implements Presenter
{
	public interface Display {
		Widget asWidget();
	}
	
	private Model model;
	private final Display display;

	public WeeklyGoalValuesPresenter(Model model,Display display) {
		this.model = model;
		this.display = display;		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

}
