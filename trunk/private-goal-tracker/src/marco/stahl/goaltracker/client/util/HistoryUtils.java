package marco.stahl.goaltracker.client.util;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;

public class HistoryUtils {

	public static String[] pathElements(String token) {
		return token.split("/");
	}

	public static void bindHistoryBackTo(HasClickHandlers cancelButton) {
		cancelButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				History.back();
			}
		});
	}
	
}
