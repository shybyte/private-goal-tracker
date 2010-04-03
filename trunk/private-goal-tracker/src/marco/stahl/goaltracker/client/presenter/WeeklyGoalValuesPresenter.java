package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.Week;

import com.google.inject.Inject;

public class WeeklyGoalValuesPresenter extends
		AbstractPresenter<WeeklyGoalValuesPresenter.Display> {
	public interface Display extends Presenter.Display {
		GoalValueTableRowPresenter.Display addGoalValueRow();
	}

	private Model model;

	@Inject
	public WeeklyGoalValuesPresenter(Display display) {
		super(display);
	}

	public void bind(Model model) {
		this.model = model;
	}

	@Override
	void initDisplay() {
		for (GoalValue goalValue : model.getWeeklyGoalValues(
				Week.getCurrentWeek()).getValues()) {
			GoalValueTableRowPresenter goalValueTableRowPresenter = new GoalValueTableRowPresenter(
					display.addGoalValueRow(), goalValue);
			goalValueTableRowPresenter.initDisplay();
		}
	}

}
