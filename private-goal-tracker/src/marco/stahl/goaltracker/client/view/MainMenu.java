package marco.stahl.goaltracker.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MainMenu extends Widget {

	private static MainMenuUiBinder uiBinder = GWT
			.create(MainMenuUiBinder.class);

	interface MainMenuUiBinder extends UiBinder<UListElement, MainMenu> {
	}

	public MainMenu() {
		setElement(uiBinder.createAndBindUi(this));
	}


}
