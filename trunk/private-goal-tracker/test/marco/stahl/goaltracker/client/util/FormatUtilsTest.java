package marco.stahl.goaltracker.client.util;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FormatUtilsTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testFormatNatural() {
		assertEquals("1", FormatUtils.formatNatural(1.0));
		assertEquals("1.1", FormatUtils.formatNatural(1.1));
		assertEquals("1000.9", FormatUtils.formatNatural(1000.9));
	}

}
