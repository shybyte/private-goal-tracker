package marco.stahl.goaltracker.client.factories;

import com.google.gwt.core.client.GWT;

public class GlobalFactory {
	private static final MyGinjector injector = GWT.create(MyGinjector.class);
	
	public static MyGinjector getInjector() {
		return injector;
	}
}
