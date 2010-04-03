package marco.stahl.goaltracker.client.factories;

import marco.stahl.goaltracker.client.AppController;
import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter;
import marco.stahl.goaltracker.client.view.MainMenu;
import marco.stahl.goaltracker.client.view.WeeklyGoalValuesView;
import marco.stahl.goaltracker.shared.Goal;
import marco.stahl.goaltracker.shared.Model;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class MyModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(AppController.class).in(Singleton.class);
		bind(MainMenu.class).in(Singleton.class);
		bind(WeeklyGoalValuesPresenter.Display.class).to(WeeklyGoalValuesView.class);
	}
	
	@Provides
	Model provideModel(){
		Model model = new Model();
		model.addGoal(model.createGoal("Running",Goal.Type.GOOD_ACTION,10));
		model.addGoal(model.createGoal("Swimming",Goal.Type.GOOD_ACTION,1));
		return model;		
	}

}
