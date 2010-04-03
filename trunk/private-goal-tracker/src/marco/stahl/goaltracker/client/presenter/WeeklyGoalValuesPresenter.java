package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.shared.Model;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class WeeklyGoalValuesPresenter extends AbstractPresenter<WeeklyGoalValuesPresenter.Display>
{
	public interface Display extends Presenter.Display{
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
		
	}

}
