package marco.stahl.goaltracker.client.factories;

import marco.stahl.goaltracker.client.AppController;
import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter;
import marco.stahl.goaltracker.client.view.MainMenu;
import marco.stahl.goaltracker.client.view.WeeklyGoalValuesView;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class MyModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(AppController.class).in(Singleton.class);
		bind(MainMenu.class).in(Singleton.class);
		bind(WeeklyGoalValuesPresenter.Display.class).to(WeeklyGoalValuesView.class);
	}

}
