package marco.stahl.goaltracker.client;

import static marco.stahl.goaltracker.client.view.MainMenu.MenuItem.*;
import marco.stahl.goaltracker.client.factories.MyGinjector;
import marco.stahl.goaltracker.client.presenter.Presenter;
import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter;
import marco.stahl.goaltracker.client.view.MainMenu;
import marco.stahl.goaltracker.shared.Model;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;

public class AppController implements ValueChangeHandler<String>, Presenter {

	private HasWidgets container;
	private Model model;
	private final MainMenu mainMenu;
	private final MyGinjector myGinjector;

	@Inject
	public AppController(MainMenu mainMenu,Model model,MyGinjector myGinjector) {
		this.mainMenu = mainMenu;
		this.model = model;
		this.myGinjector = myGinjector;
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
		
		mainMenu.display(token);

	}

	private Presenter getPresenterFromToken(String token) {
		if (GOAL_LIST.belongsTo(token)) {
			WeeklyGoalValuesPresenter weeklyGoalValuesPresenter = myGinjector.getWeeklyGoalValuesPresenter();
			weeklyGoalValuesPresenter.bind(model);
			return weeklyGoalValuesPresenter; 
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
