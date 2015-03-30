package exam2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;



class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

public class File3Reader {

	private static String[] stopWords = { "to", "but", "the", "that", "a",
			"than", "that", "what", "where", "why", "when", "who", "with",
			"are", "as", "at", "be", "by", "but", "can", "it", "his", "him",
			"you", "in", "is", "he", "have", "had", "as", "in", "is", "it",
			"of", "that", "the", "to" };
	// boolean done = true;
	int i = 0;
	int counter = 1;
	Map<String, Integer> table;
	
	public int uniqueNumber(Map<String, Integer> Word) {
		int count = 0;
		for (String integer : Word.keySet()) {
			if (Word.get(integer) == 1) {
				count++;
			}

		}
		return count;
	}
	
	private ArrayList<String> cleanUp(String[] words) {
		ArrayList<String> cleanWords = new ArrayList<String>();

		for (String word : words) {
			String t = word.replaceAll("\\.", " ").replaceAll(";", " ")
					.replaceAll(",", " ").replaceAll("--", " ")
					.replaceAll("'", " ").replaceAll(":", " ");
			cleanWords.add(t);
		}

		return cleanWords;
	}

	public void printAll() {
		System.out.println("The unique number is  " + uniqueNumber(table));
	}

	
	
	public void start(ArrayList<String> list) {
		table = new TreeMap<String, Integer>();
		ValueComparator bvc =  new ValueComparator(table);
	    TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);
	
		HashSet<String> stopWordsSet = new HashSet<String>();
		Map<String, Integer> lines = new TreeMap<String, Integer>();
		
		for (String word : stopWords) {
			stopWordsSet.add(word);
		}
		for (String words : list) {
			lines.put(words, counter);
		}
		for (String line : lines.keySet()) {
			String[] words = line.split("\\s+");
			for (String cleanWord : cleanUp(words)) {
				if (cleanWord.equals("")) {
					continue;
				}
				if (table.containsKey(cleanWord)) {
					int count = table.get(cleanWord);
					table.put(cleanWord, count + 1);
				} else {
					table.put(cleanWord, 1);
				}
			}
		}
		
	

        sorted_map.putAll(table);

        System.out.println(sorted_map);
        //ArrayList<String> name = new ArrayList<String>();
      
		 int frequentNumber = (uniqueNumber(table)*10)/100;
		 System.out.println("Most Frequent Words are : ");
		 for(String word : table.keySet()){
			 if(table.get(word)>frequentNumber){
			 System.out.print(" "+word);
		 }
		 }
		 System.out.println("Most infrequent words are: ");
		 for(String word : table.keySet()){
		 if(table.get(word)<frequentNumber){
				System.out.print(" "+word);
			}
//	        sorted_table.putAll(table);
//
//	        System.out.println("results: "+sorted_table);
//		for (String name : sorted_map.keySet()) {
//			System.out.println(name+" : "+ sorted_map.get(name));
//		}
//		for (String word : table.keySet()) {
//
//			if (table.get(word) > 100) {
//				// System.out.println("The most frequently used words are: " );
//			//	System.out.println("The most frequented words are: "+word);
//			}
//			
			
		//}
		//System.out.println("The least frequented words are: ");
//		for (String word : sorted_table.keySet()) {
//		if (table.get(word) < 5 && table.get(word)>1) {
//			// System.out.println("The most frequently used words are: " );
//			System.out.print(" "+word);
//		}
//		}
//		// System.out.println("The most repeated words are from file are : ");
	}
	}
}
