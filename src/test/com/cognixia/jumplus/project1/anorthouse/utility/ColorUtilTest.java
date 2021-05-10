package com.cognixia.jumplus.project1.anorthouse.utility;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.cognixia.jumplus.project1.anorthouse.utility.ColorUtil;
import com.cognixia.jumplus.project1.anorthouse.utility.ColorUtil.ANSI_BACKGROUND_COLOR;
import com.cognixia.jumplus.project1.anorthouse.utility.ColorUtil.ANSI_FONT_COLOR;

@DisplayName("ColorUtil Tests")
class ColorUtilTest {
	
	@Nested
	@DisplayName("combineAnsi()")
	class combineAnsiUseCases { 

		@Test
		@DisplayName("Empty String, White Font & Background")
		final void testCombineAnsiEmptyString() {
			String expected = "\u001B[37m\u001B[47m\u001B[0m";
			String actual = ColorUtil.combineAnsi(ANSI_FONT_COLOR.WHITE, ANSI_BACKGROUND_COLOR.WHITE, "");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Single Dash, Yellow Font, Blue Background")
		final void testCombineAnsiSingleDash() {
			String expected = "\u001B[33m\u001B[44m-\u001B[0m";
			String actual = ColorUtil.combineAnsi(ANSI_FONT_COLOR.YELLOW, ANSI_BACKGROUND_COLOR.BLUE, "-");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Green Font, Red Background")
		final void testCombineAnsi() {
			String expected = "\u001B[32m\u001B[41mThis is Green and Red!\u001B[0m";
			String actual = ColorUtil.combineAnsi(ANSI_FONT_COLOR.GREEN, ANSI_BACKGROUND_COLOR.RED, "This is Green and Red!");
			assertEquals(expected, actual);
		}

	}
	
	@Nested
	@DisplayName("combineAnsiFont()")
	class combineAnsiFontUseCases { 

		@Test
		@DisplayName("Empty String, White Font")
		final void testCombineAnsiFontEmptyString() {
			String expected = "\u001B[37m\u001B[0m";
			String actual = ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.WHITE, "");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Single Space, Yellow Font")
		final void testCombineAnsiFontSingleSpace() {
			String expected = "\u001B[33m \u001B[0m";
			String actual = ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.YELLOW, " ");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Green Font")
		final void testCombineAnsiFont() {
			String expected = "\u001B[32mThis is Green!\u001B[0m";
			String actual = ColorUtil.combineAnsiFont(ANSI_FONT_COLOR.GREEN, "This is Green!");
			assertEquals(expected, actual);
		}
		
	}
	
	@Nested
	@DisplayName("combineAnsiBackground()")
	class combineAnsiBackgroundUseCases { 

		@Test
		@DisplayName("Empty String, White Background")
		final void testCombineAnsiBackgroundEmptyString() {
			String expected = "\u001B[47m\u001B[0m";
			String actual = ColorUtil.combineAnsiBackGround(ANSI_BACKGROUND_COLOR.WHITE, "");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Single Dash, Blue Background")
		final void testCombineAnsiBackgroundSingleDash() {
			String expected = "\u001B[44m-\u001B[0m";
			String actual = ColorUtil.combineAnsiBackGround(ANSI_BACKGROUND_COLOR.BLUE, "-");
			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Red Background")
		final void testCombineAnsiBackground() {
			String expected = "\u001B[41mThis is Red!\u001B[0m";
			String actual = ColorUtil.combineAnsiBackGround(ANSI_BACKGROUND_COLOR.RED, "This is Red!");
			assertEquals(expected, actual);
		}
		
	}
}
