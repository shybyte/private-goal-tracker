package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.client.pages.EditGoalValuePage;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.Week;
import marco.stahl.goaltracker.shared.WeeklyGoalValues;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
import com.google.inject.Inject;

public class WeeklyGoalValuesPresenter extends
		AbstractPresenter<WeeklyGoalValuesPresenter.Display> {
	public interface Display extends Presenter.Display {
		GoalValueTableRowPresenter.Display addGoalValueRow();
		HasClickHandlers getAddGoalButton();
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
		WeeklyGoalValues weeklyGoalValues = model.getWeeklyGoalValues(Week
				.getCurrentWeek());
		for (GoalValue goalValue : weeklyGoalValues.getValues()) {
			GoalValueTableRowPresenter goalValueTableRowPresenter = new GoalValueTableRowPresenter(
					display.addGoalValueRow(), goalValue, weeklyGoalValues
							.getWeek());
			goalValueTableRowPresenter.initDisplay();
		}
		
		display.getAddGoalButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onAddGoalButton();
			}
		});
	}

	protected void onAddGoalButton() {
		History.newItem(EditGoalValuePage.HISTORY_TOKEN_CREATE);
	}

}
