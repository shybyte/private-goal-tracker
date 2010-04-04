package marco.stahl.goaltracker.client.util;


public class FormatUtils {
	public static String formatNatural(double number) {
		if (isNearlyInteger(number)) {
			return Integer.toString((int) number);			
		} else {
			return Double.toString(number);
		}
	}

	private static boolean isNearlyInteger(double number) {
		return Math.abs(Math.floor(number)-number)<0.000001;
	}
	
	public static double parseDouble(String s,double defaultValue) {
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}
}
