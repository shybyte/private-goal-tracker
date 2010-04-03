package marco.stahl.goaltracker.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public abstract interface Presenter {
	public interface Display {
		Widget asWidget();
	}

	public abstract void go(final HasWidgets container);
}
