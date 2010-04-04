package marco.stahl.goaltracker.client.presenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import marco.stahl.goaltracker.client.presenter.EditGoalValuePresenter.Display;
import marco.stahl.goaltracker.shared.Model;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.junit.GWTMockUtilities;
import com.google.gwt.user.client.ui.Button;

public class EditGoalValuePresenterTest {

	private Display view;
	private Model model;
	private EditGoalValuePresenter presenter;
	private Button deleteButton;
	private Button saveButton;
	private Button cancelButton;

	@Before
	public void setUp() throws Exception {		
		GWTMockUtilities.disarm();
		mockView();
		model = mock(Model.class);
		presenter = new EditGoalValuePresenter(view , model);
	}

	private void mockView() {
		view = mock(EditGoalValuePresenter.Display.class);
		deleteButton = mock(Button.class);
		saveButton = mock(Button.class);
		cancelButton = mock(Button.class);
		when(view.getDeleteButton()).thenReturn(deleteButton);
		when(view.getSaveButton()).thenReturn(saveButton);
		when(view.getCancelButton()).thenReturn(cancelButton);
	}

	@Test
	public void hideDeleteButtonIfNewGoal() {
		presenter.loadPage("create-goal");
		presenter.initDisplay();
		verify(deleteButton).setVisible(false);
	}

}
