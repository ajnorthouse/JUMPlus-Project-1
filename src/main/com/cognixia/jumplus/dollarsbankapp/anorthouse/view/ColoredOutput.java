package com.cognixia.jumplus.dollarsbankapp.anorthouse.view;

/**
 * Class containing basic ANSI values to be used with System.out.println() statements. 
 * <p>
 * The codes were found in "Coloured Terminal Output with Java" by Andrew (he/him).
 * <p>
 * @author Alexandre Northouse
 * @see <a href="https://dev.to/awwsmm/coloured-terminal-output-with-java-57l3">Coloured Terminal Output with Java</a>
 */
public class ColoredOutput {
	//Basic text ("foreground") fonts
	public static enum ANSI_FONT_COLOR {
		BLACK("\u001B[30m"),
		RED("\u001B[31m"),
		GREEN("\u001B[32m"),
		YELLOW("\u001B[33m"),
		BLUE("\u001B[34m"),
		PURPLE("\u001B[35m"),
		CYAN("\u001B[36m"),
		WHITE("\u001B[37m"),
		BRIGHT_BLACK("\u001B[90m"),
		BRIGHT_RED("\u001B[91m"),
		BRIGHT_GREEN("\u001B[92m"),
		BRIGHT_YELLOW("\u001B[93m"),
		BRIGHT_BLUE("\u001B[94m"),
		BRIGHT_PURPLE("\u001B[95m"),
		BRIGHT_CYAN("\u001B[96m"),
		BRIGHT_WHITE("\u001B[97m");
		
		public final String value;
		
		ANSI_FONT_COLOR(String value) {
			this.value = value;
		}
	}

	//Basic background fonts
	public static enum ANSI_BACKGROUND_COLOR {
		BLACK("\u001B[40m"),
		RED("\u001B[41m"),
		GREEN("\u001B[42m"),
		YELLOW("\u001B[43m"),
		BLUE("\u001B[44m"),
		PURPLE("\u001B[45m"),
		CYAN("\u001B[46m"),
		WHITE("\u001B[47m"),
		BRIGHT_BLACK("\u001B[100m"),
		BRIGHT_RED("\u001B[101m"),
		BRIGHT_GREEN("\u001B[102m"),
		BRIGHT_YELLOW("\u001B[103m"),
		BRIGHT_BLUE("\u001B[104m"),
		BRIGHT_PURPLE("\u001B[105m"),
		BRIGHT_CYAN("\u001B[106m"),
		BRIGHT_WHITE("\u001B[107m");

		public final String value;
		
		ANSI_BACKGROUND_COLOR(String value) {
			this.value = value;
		}
	}

	//Reset code for ANSI
	public static String ANSI_RESET = "\u001B[0m";

	//Basic implementation of combining ANSI and a string to console
	public static void printAnsiText(ANSI_FONT_COLOR color, String message) {
		System.out.println(color.value + message + ANSI_RESET);
	}
}
