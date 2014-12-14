package chapter9;

import java.util.ArrayList;
import java.util.Arrays;

class Result {
	public int value;
	public boolean[] choice;

	public String toString() {
		return "value: " + value;
	}
}

public class Bag {

	public static Result values(int[] weight, int[] value, int index, int max,
			int weightLeft) {
		if (index == max - 1) {
			boolean[] choice = new boolean[max];
			Result ret = new Result();
			ret.choice = choice;
			if (weight[index] <= weightLeft) {
				ret.value = value[index];
				choice[index] = true;
			} else {
				choice[index] = false;
				ret.value = 0;
			}
			return ret;
		}

		int currentWeight = weight[index];
		Result v1 = values(weight, value, index + 1, max, weightLeft);
		if (currentWeight < weightLeft) {
			Result v2 = values(weight, value, index + 1, max, weightLeft
					- currentWeight);
			if (v2.value + value[index] > v1.value) {
				v2.value += value[index];
				v2.choice[index] = true;
				return v2;
			} else {
				v1.choice[index] = false;
				return v1;
			}
		} else {
			v1.choice[index] = false;
			return v1;
		}
	}

	public static void main(String[] args) {
		// int[] weight = new int[] { 2, 2, 6, 5, 4 };
		// int[] value = new int[] { 6, 3, 5, 4, 6 };
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };

		Result res = values(weight, value, 0, 7, 150);
		System.out.println(res);
		for (boolean b : res.choice) {
			System.out.print(b + " ");
		}
	}
}
