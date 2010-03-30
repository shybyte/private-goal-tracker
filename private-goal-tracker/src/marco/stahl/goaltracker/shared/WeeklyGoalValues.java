package marco.stahl.goaltracker.shared;

import java.util.List;

public class WeeklyGoalValues {
	private final List<GoalValue> values;
	private final Week week;

	public WeeklyGoalValues(Week week,List<GoalValue> values) {
		this.week = week;
		this.values = values;
	}
	
	public Week getWeek() {
		return week;
	}
	
	public List<GoalValue> getValues() {
		return values;
	}
	
}
