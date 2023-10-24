class StockDailyInfo {
	
	private String date;
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	private double range; // positive absolute value

	public void setDate(String d){
		date = d;
	}

	public void setOpen(double o){
		open = o;
	}

	public void setHigh(double h){
		high = h;
	}

	public void setLow(double l){
		low = l;
	}

	public void setClose(double c){
		close = c;
	}

	public void setVolume(long v){
		volume = v;
	}

	public void setRange(double r) {
		range = r;
	}

	public String getDate(){
		return date;
	}

	public double getOpen() {
		return open;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getClose() {
		return close;
	}

	public long getVolume() {
		return volume;
	}

	public double getRange(){
		return range;
	}
}