package marco.stahl.goaltracker.shared;

public class Goal {

	public enum Type {
		MAX_VALUE, MAX_TIME, MIN_VALUE, MIN_TIME;
	}

	private int id;

	private String title;
	private Type type;

	public Goal(int id, String title, Type type) {
		this.id = id;
		this.title = title;
		this.type = type;
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

}
