package com.cognixia.jumplus.dollarsbankapp.anorthouse.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputParserUtil")
class InputParserUtilTest {
	
	@Nested
	@DisplayName("parseInt()")
	class parseIntUseCases { 

		@Test
		@DisplayName("Catch: Empty")
		final void testParseIntCatchEmpty() {
		    assertThrows(Exception.class, ()-> { 
		    	InputParserUtil.parseInt(""); 
		    });
		}
		
		@Test
		@DisplayName("Catch: Escaped Characters")
		final void testParseIntCatchEscape() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseInt("\t \b  \r \n \f"); 
			});
		}

		@Test
		@DisplayName("Catch: Non-Numbers")
		final void testParseIntCatchNonNum() {
		    assertThrows(Exception.class, ()-> { 
		    	InputParserUtil.parseInt("Passw0rd"); 
		    });
		}
		
		@Test
		@DisplayName("Catch: Double")
		final void testParseIntCatchDouble() {
		    assertThrows(Exception.class, ()-> { 
		    	InputParserUtil.parseInt("100.50"); 
		    });
		}
		
		@Test
		@DisplayName("Catch: Int too big")
		final void testParseIntCatchTooLarge() {
		    assertThrows(Exception.class, ()-> { 
		    	InputParserUtil.parseInt("2200000000");
		    });
		}
		
		@Test
		@DisplayName("Catch: Negative Value")
		final void testParseIntCatchNegative() {
		    assertThrows(Exception.class, ()-> { 
		    	InputParserUtil.parseInt("-100"); 
		    });
		}
		
		@Test
		@DisplayName("Parses Valid Input")
		final void testParseIntValidInput() {
			int expected = 100;
			int actual = 0;
			try {
				actual = InputParserUtil.parseInt("  100 ");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}
	}
	
	@Nested
	@DisplayName("parseDouble()")
	class parseDoubleUseCases { 

		@Test
		@DisplayName("Catch: Empty")
		final void testParseDoubleCatchEmpty() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseDouble(""); 
			});
		}
		
		@Test
		@DisplayName("Catch: Escaped Characters")
		final void testParseDoubleCatchEscape() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseDouble("\t \b  \r \n \f"); 
			});
		}

		@Test
		@DisplayName("Catch: Non-Numbers")
		final void testParseDoubleCatchNonNum() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseDouble("Passw0rd"); 
			});
		}

		@Test
		@DisplayName("Catch: Negative Value")
		final void testParseDoubleCatchNegative() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseDouble("-100"); 
			});
		}

		@Test
		@DisplayName("Parses Double Input")
		final void testParseDoubleValidDouble() {
			double expected = 100.25;
			double actual = 0;
			try {
				actual = InputParserUtil.parseDouble("  100.25 ");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Parses Int Input")
		final void testParseDoubleValidInt() {
			double expected = 100.00;
			double actual = 0;
			try {
				actual = InputParserUtil.parseDouble("  100 ");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}
	}
	
	@Nested
	@DisplayName("parseString()")
	class parseStringUseCases { 
		
		@Test
		@DisplayName("Catch: Empty")
		final void testParseStringCatchEmpty() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseString("   "); 
			});
		}
		
		@Test
		@DisplayName("Catch: Escaped Characters")
		final void testParseStringCatchEscape() {
			assertThrows(Exception.class, ()-> { 
				InputParserUtil.parseString("\t \b  \r \n \f"); 
			});
		}

		@Test
		@DisplayName("Parses Valid Input")
		final void testParseUsername() {
			String expected = "Howdy!";
			String actual = "";
			try {
				actual = InputParserUtil.parseString("  Howdy! ");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}
	}
	
	@Nested
	@DisplayName("parseUsername()")
	class parseUsernameUseCases { 
		
		@Test
		@DisplayName("Formats String to Lower")
		final void testParseUsernameCatchEmpty() {
			String expected = "foobar";
			String actual = "";
			try {
				actual = InputParserUtil.parseUsername("  FooBar ");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}
	}

}
