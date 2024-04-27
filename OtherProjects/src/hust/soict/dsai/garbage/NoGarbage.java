package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "src\\hust\\soict\\dsai\\garbage\\test.jpg";
		
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for(byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
		String output = outputStringBuilder.toString();
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
