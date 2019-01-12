package util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StdIn {

	private static Scanner scanner;
	
	static {
        carregarScanner();
    }
	
	private static void carregarScanner() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), "UTF-8"));
    }
    
    private static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
    }
	
	public static String readLine() {
        String line;
        try {
            line = scanner.nextLine();
        }
        catch (NoSuchElementException e) {
            line = null;
        }
        return line;
    }
}
