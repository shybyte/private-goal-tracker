package marco.stahl.goaltracker.client.pages;

import marco.stahl.goaltracker.client.presenter.Presenter;
import marco.stahl.goaltracker.client.util.FormatUtils;
import marco.stahl.goaltracker.client.util.HistoryUtils;
import marco.stahl.goaltracker.client.util.StringUtil;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.Week;
import marco.stahl.goaltracker.shared.Goal.Type;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditGoalValuePage extends Composite implements Presenter.Display {

	public static final String HISTORY_TOKEN_EDIT = "edit-goal";
	public static final String HISTORY_TOKEN_CREATE = "create-goal";
	private GoalValue goalValue;
	private final Model model;

	private static EditGoalValuePageUiBinder uiBinder = GWT
			.create(EditGoalValuePageUiBinder.class);

	interface EditGoalValuePageUiBinder extends
			UiBinder<Widget, EditGoalValuePage> {
	}

	@UiField
	TextBox goalTitle;

	@UiField
	TextBox defaultTargetValue;

	@UiField
	Button saveButton;

	@UiField
	Button cancelButton;

	@UiField
	Button deleteButton;

	@UiField
	HeadingElement pageTitle;

	public EditGoalValuePage(Model model) {
		initWidget(uiBinder.createAndBindUi(this));
		this.model = model;		
	}

	void initDisplay() {
		if (newGoal()) {
			pageTitle.setInnerText("Add Goal");
		} else {
			goalTitle.setValue(goalValue.getGoal().getTitle());
		}
		deleteButton.setVisible(!newGoal());
		HistoryUtils.bindHistoryBackTo(cancelButton);
	}

	private boolean newGoal() {
		return goalValue == null;
	}

	public void loadPage(String token) {
		if (token.startsWith(HISTORY_TOKEN_EDIT)) {
			goalValue = goalValueForHistoryToken(token);
		}
		initDisplay();
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

	@UiHandler("deleteButton")
	void onClickDeleteButton(ClickEvent e) {
		model.deleteGoal(goalValue);
		History.back();
	}

	@UiHandler("saveButton")
	void onClickSaveButton(ClickEvent e) {
		String goalTitle = StringUtil.ensureNotEmpty(this.goalTitle.getValue(),
				"No Title");
		double defaultTargetTime = FormatUtils.parseDouble(defaultTargetValue
				.getValue(), 1);
		if (newGoal()) {
			model.addGoal(model.createGoal(goalTitle, Type.GOOD_TIME,
					defaultTargetTime));
		} else {
			goalValue.getGoal().setTitle(goalTitle);
			goalValue.getGoal().setDefaultTargetValue(defaultTargetTime);
		}
		History.back();
	}

	@Override
	public Widget asWidget() {
		return this;
	}
}
