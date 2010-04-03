package marco.stahl.goaltracker.shared;

import java.util.List;

import marco.stahl.goaltracker.client.util.CollectionUtils;


public class WeeklyGoalValues {
	private final List<GoalValue> values = CollectionUtils.newArrayList();
	private final Week week;

	public WeeklyGoalValues(Week week) {
		this.week = week;
	}
	
	public WeeklyGoalValues(Week week,List<GoalValue> values) {
		this(week);
		this.values.addAll(values);
	}
	
	public Week getWeek() {
		return week;
	}
	
	public List<GoalValue> getValues() {
		return values;
	}
	
	public void addValue(GoalValue goalValue) {
		values.add(goalValue);
	}

	public void addGoal(Goal goal) {
		addValue(new GoalValue(goal, goal.getDefaultTargetValue(), 0));
	}
	
}
