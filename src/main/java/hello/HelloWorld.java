package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.TimeZone;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("*** jvm ***");
		System.out.println(Charset.defaultCharset().displayName());
		System.out.println(TimeZone.getDefault());
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.vendor"));
		System.out.println(new Date());
		System.out.println("******");

		Class<HelloWorld> clazz = HelloWorld.class;
		String expected = "AêñüC";
		String result = null;

		try {
			System.out.println("*** Reading ISO file ***");
			result = readFile(clazz.getResourceAsStream("/myfileiso.txt"));
			System.out.println(expected.equals(result));
			
			System.out.println("*** Reading UTF file ***");
			result = readFile(clazz.getResourceAsStream("/myfileutf8.txt"));
			System.out.println(expected.equals(result));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String readFile(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
		reader.close();
		return line;
    }
}
