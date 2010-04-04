package marco.stahl.goaltracker.shared;

public class GoalValue {

	private final Goal goal;
	private double value;
	private double targetValue;
	private WeeklyGoalValues weeklyGoalValues;

	public GoalValue(Goal goal, double targetValue, double value,WeeklyGoalValues week) {
		this.goal = goal;
		this.targetValue = targetValue;
		this.value = value;
		this.weeklyGoalValues = week;
	}

	public Goal getGoal() {
		return goal;
	}

	public double getValue() {
		return value;
	}

	public double getTargetValue() {
		return targetValue;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}

	public void addValue(double additionalValue) {
		value += additionalValue;
	}
	
	public WeeklyGoalValues getWeeklyGoalValues() {
		return weeklyGoalValues;
	}
	
}
