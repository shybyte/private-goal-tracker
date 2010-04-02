package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.shared.Model;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class WeeklyGoalValuesPresenter implements Presenter
{
	public interface Display {
		Widget asWidget();
	}
	
	private Model model;
	private final Display display;

	@Inject
	public WeeklyGoalValuesPresenter(Display display) {
		this.display = display;		
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	public void bind(Model model) {
		this.model = model;
	}

}
