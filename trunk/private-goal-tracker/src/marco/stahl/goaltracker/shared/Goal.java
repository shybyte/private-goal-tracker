package marco.stahl.goaltracker.shared;

public class Goal {

	public enum Type {
		GOOD_ACTION, GOOD_TIME, BAD_ACTION, WASTED_TIME;
	}

	private int id;

	private String title;
	private Type type;
	private double defaultTargetValue;

	public Goal(int id, String title, Type type,double defaultTargetValue) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.defaultTargetValue = defaultTargetValue;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getDefaultTargetValue() {
		return defaultTargetValue;
	}

	public void setDefaultTargetValue(double defaultTargetValue) {
		this.defaultTargetValue = defaultTargetValue;
	}

}
