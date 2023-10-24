import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class StockDriver {

	// ArrayList of Ticker Symbols we have data for
	static ArrayList<String> tickers = new ArrayList<String>();
	// ArrayList of daily trading information for a stock for the last 1-year
	static ArrayList<StockDailyInfo> arr = new ArrayList<StockDailyInfo>();

	public static void main(String[] args) {

		String ticker = "";

		// get all files in the data folder
		File dir = new File("data/");
		File[] directoryListing = dir.listFiles();

		if (directoryListing != null) {
			for (File child : directoryListing) {
				ticker = child.getName().replace(".csv", "");
				tickers.add(ticker);
			}
			ticker = ""; // reset ticker to blank
		}
	
		System.out.print("Stocks: ");
		for (String tickerName : tickers)
			System.out.print(tickerName + " | ");
		
		System.out.println();

		// prompt the user to input a ticker symbol contained in the list
		// tickers reject any value not in the list tickers and reprompt the
		// user, utilize the isTicker() method which is TBD

		Scanner keyboard = new Scanner(System.in); // Create a Scanner object
		do {
			System.out.print("Which stock: ");
			ticker = keyboard.next().toUpperCase();
		} while (!isTicker(ticker));

		Stock s = new Stock(ticker);

		// print most recent 7-days of stock data for this ticker
		System.out.println("MOST RECENT 7-DAYS METRICS");
		s.prettyPrint(7);

		// TBD implement all of the functions below so we get valid results
		int trading_days = s.getTradingDays();
		double closing_high = s.getClosingHigh(trading_days);
		double closing_low = s.getClosingLow(trading_days);
		double recent_close = s.getMostRecentClose();
		double price_performance = s.getPricePerformance(trading_days);
		double moving_average_50_day = s.getMovingAverage(50);
		double moving_average_200_day = s.getMovingAverage(200);

		System.out.printf("\n--> The most recent close is $%.2f\n", recent_close);
		System.out.printf("--> The highest close in 52 weeks is $%.2f\n", closing_high);
		System.out.printf("--> The lowest close in 52 weeks is $%.2f\n", closing_low);
		if (price_performance > 0) {
			System.out.printf(
					"--> The price performance for 52 weeks is up %.2f%%\n",
					price_performance);
		} else {
			System.out.printf(
					"--> The price performance for 52 weeks is down %.2f%%\n",
					price_performance);
		}

		System.out.printf("--> The 50 day moving average is $%.2f\n", moving_average_50_day);
		System.out.printf("--> The 200 day moving average is $%.2f\n", moving_average_200_day);

		System.out.println();

		// TBD Implement If/Else If/Else LOGIC FOR STOCK RECOMMENDATION (THESE SHOULD NOT ALL PRINT!)
		
		// if the recent close is above the 50 day moving average print this:
		System.out.printf("--> %s is above its 50 day moving average.  This is bullish, BUY!\n", ticker);
		// else if the recent close is more than 5% below the 50 day moving average, print this
		System.out.printf("--> %s is well below its 50 day moving average.  This is bearish, SELL!\n", ticker);
		// else recommend HOLD
		System.out.printf("--> %s is slightly below its 50 day moving average.  This is Hold!\n", ticker);


		
		System.out.printf("--> %s\n", s.bigSwing(trading_days));

		// sort array using selection sort (easier sort method to implement)
		s.selectionSort();
		
		// sort array using merge sort instead (if you are daring)
		// merge_sort(0, days - 1);

		// print sorted array by volume
		System.out.println("\nFIVE HIGHEST VOLUME DAYS");
		s.prettyPrint(5);

	}

	public static boolean isTicker(String ticker) {

		// TBD ONLY RETURN TRUE IF THE TICKER STOCK DATA CSV IS AVAILABLE
		return true;
	}

}
