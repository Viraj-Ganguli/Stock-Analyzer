public class Color{
	
	public static void red() {
		System.out.print("\033[1;31m");
	}

	public static void green() {
		System.out.print("\033[0;32m");
	}

	public static void cyan() {
		System.out.print("\033[0;36m");
	}

	public static void purple() {
		System.out.print("\033[0;35m");
	}

	public static void reset() {
		System.out.print("\033[0m");
	}

}