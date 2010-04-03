package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.client.util.FormatUtils;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Week;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;

public class GoalValueTableRowPresenter extends
		AbstractPresenter<GoalValueTableRowPresenter.Display> {

	private GoalValue goalValue;
	private final Week week;

	public interface Display extends Presenter.Display {
		void setGoalTitle(String title);

		void setGoalHistoryToken(String token);

		void setValue(String value);

		void setTargetValue(String targetValue);

		HasClickHandlers getPlusButton();

		HasClickHandlers getPlusPlusButton();
	}

	public GoalValueTableRowPresenter(Display display, GoalValue goalValue,
			Week week) {
		super(display);
		this.goalValue = goalValue;
		this.week = week;
	}

	@Override
	void initDisplay() {
		display.setGoalHistoryToken("edit-goal/" + goalValue.getGoal().getId()
				+ "/" + week.getNumber());
		refresh();
		display.getPlusButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onPlusButton();
			}
		});
		display.getPlusPlusButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onPlusPlusButton();
			}
		});
	}

	private void refresh() {
		display.setGoalTitle(goalValue.getGoal().getTitle());
		display.setValue(FormatUtils.formatNatural(goalValue.getValue()));
		display.setTargetValue(FormatUtils.formatNatural(goalValue.getTargetValue()));
	}

	protected void inEditButton() {
	}

	protected void onPlusPlusButton() {
		String numberString = Window.prompt("Please enter the number to add",
				"");
		if (numberString != null) {
			goalValue.addValue(Double.parseDouble(numberString));
			refresh();
		}
	}

	protected void onPlusButton() {
		goalValue.addValue(1);
		refresh();
	}

}
