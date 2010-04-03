package marco.stahl.goaltracker.shared;

public class GoalValue {

	private final Goal goal;
	private double value;
	private double targetValue;

	public GoalValue(Goal goal, double targetValue, double value) {
		this.goal = goal;
		this.targetValue = targetValue;
		this.value = value;
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
	
}
