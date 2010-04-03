package marco.stahl.goaltracker.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;

public abstract class AbstractPresenter<T extends Presenter.Display> implements Presenter{
	protected T display;

	public AbstractPresenter(T display) {
		this.display = display;
	}
	
	@Override
	public void go(HasWidgets container) {
		initDisplay();
		container.clear();
		container.add(display.asWidget());		
	}
	
	abstract void initDisplay();
}
