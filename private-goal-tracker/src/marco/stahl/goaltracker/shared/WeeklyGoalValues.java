package marco.stahl.goaltracker.shared;

import java.util.Iterator;
import java.util.List;

import marco.stahl.goaltracker.client.util.CollectionUtils;


public class WeeklyGoalValues {
	private final List<GoalValue> values = CollectionUtils.newArrayList();
	private final Week week;
	private final Model model;

	public WeeklyGoalValues(Week week,final Model model) {
		this.week = week;
		this.model = model;
	}
	
	public WeeklyGoalValues(Week week,List<GoalValue> values,Model model) {
		this(week,model);
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
		addValue(new GoalValue(goal, goal.getDefaultTargetValue(), 0,this));
	}

	public GoalValue getValue(int goalId) {
		for (GoalValue goalValue : values) {
			if (goalValue.getGoal().getId() == goalId) {
				return goalValue;
			}
		}
		return null;
	}

	public void removeGoalFor(Goal goal) {
		Iterator<GoalValue> iterator = values.iterator();
		while (iterator.hasNext()) {
			GoalValue value = iterator.next();
			if (value.getGoal().equals(goal)) {
				iterator.remove();
			}
		}
			
		
	}
	
}
