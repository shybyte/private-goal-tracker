package marco.stahl.goaltracker.client.util;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionUtils {
	public static <E> ArrayList<E> newArrayList() {
		return new ArrayList<E>();
	}

	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}
}
