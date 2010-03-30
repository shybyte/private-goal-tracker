package marco.stahl.goaltracker.client;

import marco.stahl.goaltracker.client.presenter.Presenter;
import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter;
import marco.stahl.goaltracker.client.view.MainMenu;
import static marco.stahl.goaltracker.client.view.MainMenu.MenuItem.*;
import marco.stahl.goaltracker.client.view.WeeklyGoalValuesView;
import marco.stahl.goaltracker.shared.Model;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String>, Presenter {

	private HasWidgets container;
	private Model model;
	private final MainMenu mainMenu;

	public AppController(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
		History.addValueChangeHandler(this);
		model = new Model();
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
			return new WeeklyGoalValuesPresenter(model,new WeeklyGoalValuesView()); 
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
