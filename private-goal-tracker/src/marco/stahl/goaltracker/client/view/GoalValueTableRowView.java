package marco.stahl.goaltracker.client.view;

import marco.stahl.goaltracker.client.utilwidgets.Cell;
import marco.stahl.goaltracker.client.utilwidgets.TableRow;

import marco.stahl.goaltracker.client.presenter.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class GoalValueTableRowView extends Composite implements GoalValueTableRowPresenter.Display {

	private static GoalValueTableRowViewUiBinder uiBinder = GWT
			.create(GoalValueTableRowViewUiBinder.class);

	interface GoalValueTableRowViewUiBinder extends
			UiBinder<TableRow, GoalValueTableRowView> {
	}

	private TableRow tableRow;

	@UiField
	Cell title;
	
	@UiField
	SpanElement value;

	@UiField
	SpanElement targetValue;
	
	@UiField
	Button plusButton;
	
	@UiField
	Button plusPlusButton;
	
	@UiField
	Button editButton;
	
	public GoalValueTableRowView() {
		tableRow = uiBinder.createAndBindUi(this);
		initWidget(tableRow);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setGoalTitle(String title) {
		this.title.setText(title);
	}

	@Override
	public HasClickHandlers getEditButton() {
		return editButton;
	}

	@Override
	public HasClickHandlers getPlusButton() {
		return plusButton;
	}

	@Override
	public HasClickHandlers getPlusPlusButton() {
		return plusPlusButton;
	}

	@Override
	public void setTargetValue(String targetValue) {
		this.targetValue.setInnerText(targetValue);
	}

	@Override
	public void setValue(String value) {
		this.value.setInnerText(value);
	}

}
