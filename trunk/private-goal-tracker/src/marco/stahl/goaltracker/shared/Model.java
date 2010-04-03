package marco.stahl.goaltracker.shared;

import java.util.List;
import java.util.Map;

import marco.stahl.goaltracker.client.util.CollectionUtils;
import marco.stahl.goaltracker.shared.Goal.Type;


public class Model {
	private int goalIdCounter = 0;
	private List<Goal> goals = CollectionUtils.newArrayList();
	private Map<Week, WeeklyGoalValues> weeklyGoalValuesByWeek = CollectionUtils.newHashMap();

	public List<Goal> getGoals() {
		return goals;
	}

	public WeeklyGoalValues getWeeklyGoalValues(Week week) {
		WeeklyGoalValues weeklyGoalValues = weeklyGoalValuesByWeek.get(week);
		if (weeklyGoalValues == null) {
			weeklyGoalValues = addNewWeek(week);
		}
		return weeklyGoalValues;
	}

	private WeeklyGoalValues addNewWeek(Week week) {
		WeeklyGoalValues weeklyGoalValues = new WeeklyGoalValues(week);
		for (Goal goal : goals) {
			weeklyGoalValues.addGoal(goal);
		}
		weeklyGoalValuesByWeek.put(week, weeklyGoalValues);
		return weeklyGoalValues;
	}

	public void addGoal(Goal goal) {
		goals.add(goal);
		addGoalToWeeksAfter(goal, Week.getCurrentWeek());
	}

	private void addGoalToWeeksAfter(Goal goal, Week currentWeek) {
		for (WeeklyGoalValues weeklyGoalValues : weeklyGoalValuesByWeek
				.values()) {
			if (weeklyGoalValues.getWeek().isLaterOrSameLike(currentWeek)) {
				weeklyGoalValues.addGoal(goal);
			}
		}
	}

	public Goal createGoal(String title, Type type, double targetValue) {
		return new Goal(goalIdCounter++, title, type, targetValue);
	}

}
