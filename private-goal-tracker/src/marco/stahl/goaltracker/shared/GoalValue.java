package marco.stahl.goaltracker.shared;

public class GoalValue {

	private final Goal goal;
	private final double value;
	private final double targetValue;

	public GoalValue(Goal goal, double targetValue, double value) {
		this.goal = goal;
		this.targetValue = targetValue;
		this.value = value;
	}
}