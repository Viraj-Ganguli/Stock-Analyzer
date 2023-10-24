import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Stock {

	private ArrayList<StockDailyInfo> arr = new ArrayList<StockDailyInfo>();
	private int trading_days;
	private String ticker;

	public Stock(String t) {

		ticker = t;

		System.out.println("\nStock ticker: " + ticker);

		try {
			trading_days = getStockData(ticker);
		} catch (Exception e) {
			System.out.println("Error in getStockData: " + e.getMessage());
			System.exit(0);
		}
	}

	private int getStockData(String ticker) throws Exception {
		// set the directory and file extension for this ticker
		String fileName = "data/" + ticker + ".csv";

		File data = new File(fileName);
		Scanner line = new Scanner(data);
		line.nextLine(); // throw out the first line with the headers

		int days = 0;
		while (line.hasNextLine()) {

			StockDailyInfo sdi = new StockDailyInfo();
			String l = line.nextLine(); // line of stock data
			Scanner token = new Scanner(l);
			token.useDelimiter(",");
			sdi.setDate(token.next()); // date
			sdi.setOpen(Double.parseDouble(token.next())); // open
			sdi.setHigh(Double.parseDouble(token.next())); // high
			sdi.setLow(Double.parseDouble(token.next())); // low
			sdi.setClose(Double.parseDouble(token.next())); // close
			token.next(); // this is adj_close which we don't need
			sdi.setVolume(Long.parseLong(token.next())); // volume
			// TBD set the range (positive value representing difference between high and low)

			
			arr.add(0, sdi);
			days++;
		}

		return days;
	}

	public void prettyPrint(int days) {
		Color.purple();
		System.out.print("\n====================");
		System.out.print("======================");
		System.out.print("======================\n");
		Color.cyan();
		System.out.println();

		System.out.printf("%-12s%-11s%-11s%-11s%-11s%-11s\n", "DATE", "OPEN", "HIGH", "LOW", "CLOSE", "VOLUME");
		Color.reset();
		for (int i = 0; i < days; i++) {
			System.out.printf("%-12s", arr.get(i).getDate());
			System.out.printf("$%-10.2f", arr.get(i).getOpen());
			System.out.printf("$%-10.2f", arr.get(i).getHigh());
			System.out.printf("$%-10.2f", arr.get(i).getLow());
			if ((i + 1) == days || (arr.get(i).getClose() >= arr.get(i + 1).getClose()))
				Color.green();
			else
				Color.red();
			System.out.printf("$%-10.2f", arr.get(i).getClose());
			Color.reset();
			System.out.println(String.format("%,d", arr.get(i).getVolume()));
		}
		Color.purple();
		System.out.print("\n====================");
		System.out.print("======================");
		System.out.print("======================\n");
		Color.reset();
	}

	public int getTradingDays() {
		// TBD return the number of trading days data available
		
		return trading_days;
	}

	public double getClosingHigh(int days) {
		// TBD return the all time closing high from the most recent X trading days
		double closing_high = 0;

		// YOUR CODE HERE
		
		return closing_high;
	}

	public double getClosingLow(int days) {
		// TBD return the all time closing low from the most recent X trading days
		double closing_low = 0;

		// YOUR CODE HERE
		
		return closing_low;
	}

	public double getMostRecentClose() {
		// TBD return the closing price from the most recent close

		// YOUR CODE HERE
		
		return 0;
	}

	public double getPricePerformance(int days) {
		// TBD return the percent (as a double) increase or decrease of the
		// stock for the past days

		// YOUR CODE HERE
		
		return 0;
	}

	public double getMovingAverage(int days) {
		// get moving average from the most recent X trading days
		// moving average = [(day1 + day2 + day3 + .... + day n) / n]

		// YOUR CODE HERE

		return 0.0;
	}

	public String bigSwing(int days) {
		// return a string that indicates the day with the highest daily 
		// range for the most recent days use the folowing format:
		// "The biggest intraday swing occurred on [date] when [ticker] 
		//  ranged from [low] to [high] and closed at [close]"

		double max = 0;
		int index = 0;
		String message = "";

		// YOUR CODE HERE

		message = ("The biggest intraday swing occurred on " + 
				   arr.get(index).getDate() + " when " + ticker + 
				   " ranged from " + String.format("$%.2f", arr.get(index).getLow()) + " to " + 
				   String.format("$%.2f", arr.get(index).getHigh())) + " and closed at " +
				String.format("$%.2f", arr.get(index).getClose());

		return message;
	}

	public void mergeSort(int left, int right) {
		// sort array using merge sort (optional, other choice selectionSort)
		
		// YOUR CODE HERE
	}

	// merges arr[left..mid] and arr[mid + 1..right]
	public void merge(int left, int mid, int right) {
		// YOUR CODE HERE
		
	}

	public void selectionSort() {

		// sort array using selection sort (optional, other choice mergeSort)

		// YOUR CODE HERE
		
	}

}
