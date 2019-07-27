import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SecretSanta {
	private static ArrayList<String> names = new ArrayList<String>();
	private static HashMap<String, String> pairs = new HashMap<String, String>();
	
	public static void createGroup() {
		Scanner input = new Scanner (System.in);
		System.out.print("How many people are in your group? ");
		int numOfPeople = input.nextInt();
		input.nextLine();
		int peeps = numOfPeople;
		while(peeps!=0) {
			System.out.print("Please enter name: ");
			String personName = input.nextLine();
			names.add(personName);
			pairs.put(personName, "heyo");
			peeps--;
		}
		
		//create hashmap and make every person a key
		for(String key:pairs.keySet()) {
			int possIndex = getName(numOfPeople);
			while(names.get(possIndex).equals(key)) {
				possIndex = getName(numOfPeople);
			}
			pairs.put(key,names.get(possIndex));
			numOfPeople--;
			names.remove(possIndex);
		}
		
		System.out.println("");
		System.out.println("here are the pairs");
		System.out.println("");
		for(String key: pairs.keySet()) {
			System.out.println(key+"--->"+pairs.get(key));
		}
		
		
	}
	
	
	private static int getName(int max) {
		int index = (int)(Math.random() * max + 0);
		return index;
	}
	
	public static void main (String [] args) {
		createGroup();
	}

}
