package marco.stahl.goaltracker.client.view;

import marco.stahl.goaltracker.client.presenter.WeeklyGoalValuesPresenter.Display;
import marco.stahl.goaltracker.client.utilwidgets.TableRowPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class WeeklyGoalValuesView extends Composite implements Display {

	private static WeeklyGoalValuesViewUiBinder uiBinder = GWT
			.create(WeeklyGoalValuesViewUiBinder.class);

	interface WeeklyGoalValuesViewUiBinder extends
			UiBinder<Widget, WeeklyGoalValuesView> {
	}

	@UiField
	TableRowPanel tableRowPanel;
	
	@UiField
	Button addGoal;
	
	@Inject
	public WeeklyGoalValuesView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public marco.stahl.goaltracker.client.presenter.GoalValueTableRowPresenter.Display addGoalValueRow() {
		GoalValueTableRowView goalValueTableRowView = new GoalValueTableRowView();
		tableRowPanel.add(goalValueTableRowView);
		return goalValueTableRowView;
	}

	@Override
	public HasClickHandlers getAddGoalButton() {
		return addGoal;
	}
}
