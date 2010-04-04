package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.client.util.FormatUtils;
import marco.stahl.goaltracker.client.util.HistoryUtils;
import marco.stahl.goaltracker.client.util.StringUtil;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.Week;
import marco.stahl.goaltracker.shared.Goal.Type;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasValue;

public class EditGoalValuePresenter extends
		AbstractPresenter<EditGoalValuePresenter.Display> {

	public static final String HISTORY_TOKEN_EDIT = "edit-goal";
	public static final String HISTORY_TOKEN_CREATE = "create-goal";
	private GoalValue goalValue;
	private final Model model;

	public interface Display extends Presenter.Display {
		void setPageTitle(String title);

		HasValue<String> getGoalTitle();

		HasValue<String> getDefaultTargetValue();

		HasClickHandlers getCancelButton();

		HasClickHandlers getSaveButton();

		Button getDeleteButton();
	}

	public EditGoalValuePresenter(Display display, Model model) {
		super(display);
		this.model = model;
	}

	@Override
	void initDisplay() {
		if (newGoal()) {
			display.setPageTitle("Add Goal");
		} else {
			display.getGoalTitle().setValue(goalValue.getGoal().getTitle());
		}
		display.getDeleteButton().setVisible(!newGoal());
		display.getSaveButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onSaveButton();
			}
		});
		display.getDeleteButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onDeleteButton();
			}
		});
		HistoryUtils.bindHistoryBackTo(display.getCancelButton());
	}

	protected void onDeleteButton() {
		model.deleteGoal(goalValue);
		History.back();
	}

	private boolean newGoal() {
		return goalValue == null;
	}

	public void loadPage(String token) {
		if (token.startsWith(HISTORY_TOKEN_EDIT)) {
			goalValue = goalValueForHistoryToken(token);
		}
	}

	protected void onSaveButton() {
		String goalTitle = StringUtil.ensureNotEmpty(display.getGoalTitle()
				.getValue(), "No Title");
		double defaultTargetTime = FormatUtils.parseDouble(display
				.getDefaultTargetValue().getValue(), 1);
		if (newGoal()) {
			model.addGoal(model.createGoal(goalTitle, Type.GOOD_TIME,
					defaultTargetTime));
		} else {
			goalValue.getGoal().setTitle(goalTitle);
			goalValue.getGoal().setDefaultTargetValue(defaultTargetTime);
		}
		History.back();
	}

	private GoalValue goalValueForHistoryToken(String token) {
		String[] pathElements = HistoryUtils.pathElements(token);
		int goalId = Integer.parseInt(pathElements[1]);
		int weekNumber = Integer.parseInt(pathElements[2]);
		return model.getWeeklyGoalValues(Week.forNumber(weekNumber)).getValue(
				goalId);
	}

	public static String historyToken(GoalValue goalValue) {
		return HISTORY_TOKEN_EDIT + "/" + goalValue.getGoal().getId() + "/"
				+ goalValue.getWeeklyGoalValues().getWeek().getNumber();
	}
}
