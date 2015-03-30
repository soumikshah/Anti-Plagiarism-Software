package exam2.retake2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File1Reader {
	File3Reader table;
	int counter = 1;

	public void run(File f) throws IOException {
		Scanner scanner = new Scanner(f);

		ArrayList<String> insertWord0 = new ArrayList<String>();
		ArrayList<String> insertWord1 = new ArrayList<String>();
		ArrayList<String> insertWord2 = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			String T = scanner.nextLine();
			if (counter == 1) {
				insertWord0.add(T);
				// System.out.println("Its 1st counter..");
				counter++;
			} else if (counter == 2) {
				insertWord1.add(T);
				// System.out.println("Its 2nd counter");
				counter++;
			} else if (counter == 3) {
				// System.out.println("Its 3rd counter..");
				insertWord2.add(T);
			}

			// System.out.println(T);
		}
		scanner.close();
		table = new File3Reader();
		table.start(insertWord0);
		table.start(insertWord1);
		table.start(insertWord2);
		table.printAll();
		// table.frequentUsed(insertWord);

		// System.out.println("Hello i am out");
	}

	public static void main(String[] args) throws IOException {
	
		
		for (String file : args) {
			System.out.println("Next File starts here..");
			new File1Reader().run(new File(file));
		}
		
	
	}
}
