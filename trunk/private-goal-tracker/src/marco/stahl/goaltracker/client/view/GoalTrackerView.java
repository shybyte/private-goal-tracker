/**
 * 
 */
package marco.stahl.goaltracker.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author shybyte
 *
 */
public class GoalTrackerView extends Composite {

	private static GoalTrackerViewUiBinder uiBinder = GWT
			.create(GoalTrackerViewUiBinder.class);

	interface GoalTrackerViewUiBinder extends UiBinder<Widget, GoalTrackerView> {
	}

	@UiField
	Button button;

	public GoalTrackerView(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

}
