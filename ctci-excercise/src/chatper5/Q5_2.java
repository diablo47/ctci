package chatper5;

import java.math.BigDecimal;

public class Q5_2 {

	public static String bits(double d) {
		StringBuilder sb = new StringBuilder();
		BigDecimal decimal = new BigDecimal(d);
		BigDecimal fact = new BigDecimal(0.5);
		sb.append(".");
		int n = 1;
		while (decimal.doubleValue() > 0) {
			if (sb.length() > 32) {
				return "ERROR";
			}
			if (decimal.compareTo(fact) >= 0) {
				sb.append(1);
				decimal = decimal.subtract(fact);
			} else
				sb.append(0);
			fact = fact.divide(new BigDecimal(2));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(bits(0.75));
		System.out.println(bits(0.123486465));
		System.out.println(bits(0.5));
	}
}
