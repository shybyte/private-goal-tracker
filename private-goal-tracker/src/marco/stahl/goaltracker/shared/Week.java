package marco.stahl.goaltracker.shared;

import java.util.Date;

public class Week {
	private final int number;
	
	private Week(Date date) {
		this(weeknumberOfDate(date));
	}
	
	private Week(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	private static int weeknumberOfDate(Date date) {
		return 0;
	}
	
	public static Week forDate(Date date) {
		return new Week(date);
	}

	public boolean isLaterOrSameLike(Week currentWeek) {
		return number>=currentWeek.number;
	}
	
	public static Week getCurrentWeek() {
		return Week.forDate(new Date());
	}

	@Override
	public int hashCode() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Week other = (Week) obj;
		if (number != other.number)
			return false;
		return true;
	}

	public static Week forNumber(int week) {
		return new Week(week);
	}
	
	
}
