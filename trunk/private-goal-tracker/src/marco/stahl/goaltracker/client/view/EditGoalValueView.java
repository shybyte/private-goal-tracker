package marco.stahl.goaltracker.client.view;

import marco.stahl.goaltracker.client.presenter.EditGoalValuePresenter.Display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditGoalValueView extends Composite implements Display {

	private static EditGoalValueViewUiBinder uiBinder = GWT
			.create(EditGoalValueViewUiBinder.class);

	interface EditGoalValueViewUiBinder extends
			UiBinder<Widget, EditGoalValueView> {
	}

	@UiField
	TextBox goalTitle;
	
	@UiField
	TextBox defaultTargetValue;
	
	
	
	@UiField
	Button saveButton;
	
	@UiField
	Button cancelButton;
	
	@UiField
	Button deleteButton;
	
	@UiField
	HeadingElement pageTitle;
	

	public EditGoalValueView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPageTitle(String title) {
		pageTitle.setInnerText(title);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	public TextBox getGoalTitle() {
		return goalTitle;
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}
	
	public Button getDeleteButton() {
		return deleteButton;
	}

	@Override
	public HasValue<String> getDefaultTargetValue() {
		return defaultTargetValue;
	}
	

}
