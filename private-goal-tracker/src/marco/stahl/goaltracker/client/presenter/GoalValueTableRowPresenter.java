package marco.stahl.goaltracker.client.presenter;

import marco.stahl.goaltracker.shared.GoalValue;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;


public class GoalValueTableRowPresenter extends AbstractPresenter<GoalValueTableRowPresenter.Display>{
	
	private GoalValue goalValue;

	public interface Display extends Presenter.Display {
		void setGoalTitle(String title);
		void setValue(String value);
		void setTargetValue(String targetValue);
		HasClickHandlers getPlusButton();
		HasClickHandlers getPlusPlusButton();
		HasClickHandlers getEditButton();
	}
	
	public GoalValueTableRowPresenter(Display display, GoalValue goalValue) {
		super(display);
		this.goalValue = goalValue;
	}

	@Override
	void initDisplay() {
		refresh();
		display.getPlusButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {				
				onPlusButton();
			}
		});
		display.getPlusPlusButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				onPlusPlusButton();
			}
		});
		display.getEditButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				inEditButton();
			}
		});
	}

	private void refresh() {
		display.setGoalTitle(goalValue.getGoal().getTitle());
		display.setValue(String.valueOf(goalValue.getValue()));
		display.setTargetValue(String.valueOf(goalValue.getTargetValue()));
	}

	protected void inEditButton() {
	}

	protected void onPlusPlusButton() {
		String numberString = Window.prompt("Please enter the number to add", "");
		goalValue.addValue(Double.parseDouble(numberString));
		refresh();
	}

	protected void onPlusButton() {
		goalValue.addValue(1);
		refresh();
	}

}
