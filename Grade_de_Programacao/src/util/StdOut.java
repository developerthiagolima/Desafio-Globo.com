package util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StdOut {

	private static PrintWriter out;
	
	static {
        try {
            out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        }
        catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }
	
	public static void println(Object x) {
        out.println(x);
    }
	
}
