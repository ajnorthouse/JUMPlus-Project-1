package com.cognixia.jumplus.project1.anorthouse.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.project1.anorthouse.utility.RegexUtil;

@DisplayName("RegexUtil Tests")
class RegexUtilTest {

	@Nested
	@DisplayName("checkPassword()")
	class CheckPasswordUseCases {
		@Test
		@DisplayName("Catch: Password too short")
		final void testCheckPasswordTooShort() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("P@ssw0r"); 
		    });
		}

		@Test
		@DisplayName("Catch: Missing special char")
		final void testCheckPasswordMissingSpecial() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("Passw0rd"); 
		    });
		}

		@Test
		@DisplayName("Catch: Missing number")
		final void testCheckPasswordMissingNum() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("P@ssword"); 
		    });
		}

		@Test
		@DisplayName("Catch: Missing upper-case char")
		final void testCheckPasswordMissingUpper() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("p@ssw0rd"); 
		    });
		}

		@Test
		@DisplayName("Catch: Missing lower-case char")
		final void testCheckPasswordMissingLower() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("P@SSW0RD"); 
		    });
		}
	}

	@Nested
	@DisplayName("checkContactNumber()")
	class CheckContactNumberUseCases {
		@Test
		@DisplayName("Valid Input")
		final void testValidContactNumber() {
			String expected = "3333333333";
			String actual = "";
			try {
				actual = RegexUtil.checkContactNumber("(333) 333 - 3333");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}
		
		@Test
		@DisplayName("Extended Input")
		final void testExtendedContactNumber() {
			String expected = "13333333333";
			String actual = "";
			try {
				actual = RegexUtil.checkContactNumber("1 (333) 333 - 3333");
			} catch (Exception e) { };
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Catch: Too Long")
		final void testBadContactNumber() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("33-333-333-3333"); 
		    });
		}
	}

	@Nested
	@DisplayName("checkUsername()")
	class CheckUsernameUseCases {
		@Test
		@DisplayName("Catch: Too Short")
		final void testShortUserName() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("FooBar"); 
		    });
		}

		@Test
		@DisplayName("Catch: No Letters")
		final void testUsernameNoLetters() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("70081401"); 
		    });
		}

		@Test
		@DisplayName("Catch: No Numbers")
		final void testUsernameNoNumbers() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("FooBarol"); 
		    });
		}

		@Test
		@DisplayName("Catch: Has Special Character")
		final void testUsernameSpecialChar() {
		    assertThrows(Exception.class, ()-> { 
		    	RegexUtil.checkContactNumber("FooBar_01"); 
		    });
		}
	}
	
}
