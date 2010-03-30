package marco.stahl.goaltracker.shared;

import java.util.List;

import com.google.common.collect.Lists;

public class Model {
	private List<Goal> goals = Lists.newArrayList();
	private List<WeeklyGoalValues> weeklyGoalValues = Lists.newArrayList();
	
	public List<Goal> getGoals() {
		return goals;
	}
	
	public List<WeeklyGoalValues> getWeeklyGoalValues() {
		return weeklyGoalValues;
	}
	
}
