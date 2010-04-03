package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.shared.GoalValue;


public class GoalValueTableRowPresenter extends AbstractPresenter<GoalValueTableRowPresenter.Display>{
	
	private GoalValue goalValue;

	public interface Display extends Presenter.Display {
		void setGoalTitle(String title);
	}
	
	public GoalValueTableRowPresenter(Display display, GoalValue goalValue) {
		super(display);
		this.goalValue = goalValue;
	}

	@Override
	void initDisplay() {
		display.setGoalTitle(goalValue.getGoal().getTitle());
	}

}
