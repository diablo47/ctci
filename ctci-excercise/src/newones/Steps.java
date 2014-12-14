package newones;

public class Steps {

	public static int counting(int steps, int[] normal, int[] stepBack) {
		if (steps <= 3)
			return 1;
		return counting11(steps - 3, normal, stepBack, false)
				+ counting11(steps - 5, normal, stepBack, false);
	}

	public static int counting11(int steps, int[] normal, int[] stepBack,
			boolean hasStepback) {
		if (steps <= 0 && !hasStepback)
			return 0;
		if (steps < 0 && hasStepback)
			return 1;
		if (steps == 0 && hasStepback)
			return 1;
		if (steps <= 3 && hasStepback)
			return 1;
		int ret = 0;
		if (hasStepback) {
			if (stepBack[steps] > 0)
				return stepBack[steps];
			ret += counting11(steps - 3, normal, stepBack, true);
			ret += counting11(steps - 5, normal, stepBack, true);
			stepBack[steps] = ret;
			return ret;
		} else {
			if (normal[steps] > 0)
				return normal[steps];
			int step3 = counting11(steps - 3, normal, stepBack, false);
			int step5 = counting11(steps - 5, normal, stepBack, false);
			if (step3 >= 0)
				ret += step3;
			if (step5 >= 0)
				ret += step5;
			ret += counting11(steps - 2, normal, stepBack, true);
			ret += counting11(steps - 4, normal, stepBack, true);
			normal[steps] = ret;
			return ret;
		}

	}

	public static void main(String[] args) {
		int n = 100;
		int[] normal = new int[n];
		int[] stepBack = new int[n];
		// System.out.println(counting11(7, normal, stepBack, true));
		System.out.println(counting(n, normal, stepBack));

	}

}
