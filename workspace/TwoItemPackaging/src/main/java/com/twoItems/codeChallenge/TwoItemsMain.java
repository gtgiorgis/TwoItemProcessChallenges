package com.twoItems.codeChallenge;

import java.io.IOException;
import java.net.URISyntaxException;

public class TwoItemsMain {
	public static void main(String[] args) throws IOException, URISyntaxException {
		TwoItemsProcessor process = new TwoItemsProcessor();
		process.findPair(200.00, "giftList.txt");
		process.findPair(30.00, "giftList.txt");
		process.findPair(75.00, "giftList.txt");
		process.findPair(900.00, "giftList.txt");
		process.findPair(700.00, "giftList.txt");
	}
}
