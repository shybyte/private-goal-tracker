package marco.stahl.goaltracker.client.pages;

import static org.mockito.Mockito.*;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.gwt.tdd.util.MockitoGWTMockUtilities;

import org.junit.Before;
import org.junit.Test;

public class EditGoalValuePresenterTest {

	private Model model;
	private EditGoalValuePage page;

	@Before
	public void setUp() throws Exception {		
		MockitoGWTMockUtilities.disarm();
		model = mock(Model.class);
		page = new EditGoalValuePage(model);
	}

	@Test
	public void hideDeleteButtonIfNewGoal() {
		page.loadPage("create-goal");
		verify(page.deleteButton).setVisible(false);
	}

}
