package marco.stahl.goaltracker.client;

import static org.junit.Assert.*;

import marco.stahl.goaltracker.shared.Goal;
import marco.stahl.goaltracker.shared.GoalValue;
import marco.stahl.goaltracker.shared.Model;
import marco.stahl.goaltracker.shared.Week;
import marco.stahl.goaltracker.shared.WeeklyGoalValues;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = new Model();
	}

	@Test
	public void addedGoalsAreAddedToCurrentAndFollowingWeeks() {
		Goal newGoal = model.createGoal("Running", Goal.Type.GOOD_ACTION, 10);
		model.addGoal(newGoal);
		WeeklyGoalValues thisWeek = model.getWeeklyGoalValues(Week.getCurrentWeek());
		assertTrue(containsGoal(thisWeek, newGoal));
	}
	
	private static boolean containsGoal(WeeklyGoalValues weeklyGoalValues,Goal goal) {
		for (GoalValue goalValue : weeklyGoalValues.getValues()) {
			if (goalValue.getGoal().equals(goal)) {
				return true;
			}
		}
		return false;
		
	}


}
