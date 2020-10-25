package com.twoItems.codeChallenge;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TwoItemsProcessor {
	   
	/*public static void main(String[] args) throws IOException, URISyntaxException {
		TwoItemsProcessor process = new TwoItemsProcessor();
		process.findPair(200.00, "giftList.txt");
		process.findPair(30.00, "giftList.txt");
		process.findPair(75.00, "giftList.txt");
		process.findPair(900.00, "giftList.txt");
	}
	*/
	public void findPair(double budget, String fileName) throws IOException, URISyntaxException {
		List<Item> items = readFromFileAndMap(fileName); //reds listed items from file
		//System.out.println(items);
		double sum = 0;
		Item[] result = new Item[2];
		for (int i = 0; i < items.size(); i++){       
           Item item1 = items.get(i); //assigns i to  item1
           for(int j = i + 1; j < items.size(); j++) {
        	   Item item2 = items.get(j); //assigns j to  item2
        	   double currentSum = item1.getPrice() + item2.getPrice();
        	   if(currentSum <= budget && currentSum > sum) {
        		   result[0] = item2;
        		   result[1] = item1;
        		   sum = currentSum;
        	   }
           }
        }
		if(result[0] != null) {
			System.out.println("You can buy: " + result[0]  + " and ");
			System.out.println(result[1]);
		}else {
			System.out.println("No Solution");
		}
	}
	
	
	private List<Item> readFromFileAndMap(String fileName) throws IOException, URISyntaxException{
		return Files.readAllLines(Paths.get(this.getClass().getResource(fileName).toURI()), Charset.defaultCharset())
					.stream()
					.map(item -> item.split(", "))
					.filter(arr -> 2 == arr.length)
					.map(arr -> new Item(arr[0], Double.parseDouble(arr[1].trim())))
					//.sorted(Comparator.comparingDouble(item -> item.getPrice())) // this helps when list is not sorted
					.collect(Collectors.toList());
	}
}
