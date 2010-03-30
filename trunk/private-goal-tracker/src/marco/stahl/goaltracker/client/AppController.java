package marco.stahl.goaltracker.client;

import java.util.List;

import marco.stahl.goaltracker.client.presenter.Presenter;
import marco.stahl.goaltracker.client.presenter.WeeklyAchievedGoalValuesPresenter;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Week;
import marco.stahl.goaltracker.shared.WeeklyGoalValues;

import com.google.common.collect.Lists;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String>, Presenter {

	private HasWidgets container;

	public AppController() {
		History.addValueChangeHandler(this);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();

		if (token == null) {
			return;
		}

		Presenter presenter = getPresenterFromToken(token);
		
		if (presenter != null) {
			presenter.go(container);
		}

	}

	private Presenter getPresenterFromToken(String token) {
		if ("list".equals(token)) {
			List<GoalValue> list = Lists.newArrayList();
			return new WeeklyAchievedGoalValuesPresenter(new WeeklyGoalValues(new Week(1), list)); 
		}
		return null;
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		showFirstPage();
	}

	private void showFirstPage() {
		String token = History.getToken();
		if (token == null || "".equals(token)) {
			History.newItem("list");
		} else {
			History.fireCurrentHistoryState();
		}
	}
}
