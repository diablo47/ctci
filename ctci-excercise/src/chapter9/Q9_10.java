package chapter9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Box {
	public int width;
	public int height;
	public int depth;

	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}

public class Q9_10 {

	public static List<Box> build(List<Box> boxes, Box bottom) {
		List<Box> max = null;
		Box newBottom = null;
		int maxHeight = 0;
		for (Box box : boxes) {
			if (box != bottom && canBuiltUp(bottom, box)) {
				List<Box> upper = build(boxes, box);
				System.out.println("Round :");
				System.out.println("	Temp node: " + box);
				System.out.println("	Temp upper node : " + upper.toString());
				if (box.height + countHeight(upper) > maxHeight) {
					newBottom = box;
					max = upper;
				}
			}
		}
		if (max == null)
			max = new ArrayList<Box>();
		if (newBottom != null) {
			max.add(newBottom);
		}
		return max;

	}

	public static List<Box> buildDP(List<Box> boxes, Box bottom,
			Map<Box, List<Box>> cache) {
		if (cache.get(bottom) != null) {
			System.out.println("cached for box:" + bottom);
			return cache.get(bottom);
		}
		List<Box> max = null;
		Box newBottom = null;
		int maxHeight = 0;
		for (Box box : boxes) {
			if (box != bottom && canBuiltUp(bottom, box)) {
				List<Box> upper = buildDP(boxes, box, cache);
				System.out.println("Round :");
				System.out.println("	Temp node: " + box);
				System.out.println("	Temp upper node : " + upper.toString());
				if (box.height + countHeight(upper) > maxHeight) {
					newBottom = box;
					max = upper;
				}
			}
		}
		if (max == null)
			max = new ArrayList<Box>();
		if (newBottom != null) {
			max.add(newBottom);
		}
		cache.put(bottom, max);
		return max;

	}

	private static int countHeight(List<Box> boxes) {
		int ret = 0;
		for (Box box : boxes) {
			ret += box.height;
		}
		return ret;
	}

	private static boolean canBuiltUp(Box bottom, Box box) {
		if (bottom == null) {
			return true;
		} else
			return bottom.width >= box.width && bottom.height >= box.height;
	}

	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<Box>();
		boxes.add(new Box(3, 4, 1));
		boxes.add(new Box(8, 6, 2));
		boxes.add(new Box(9, 8, 4));
		boxes.add(new Box(9, 10, 3));
		System.out.println(build(boxes, null));
		Map<Box, List<Box>> cache = new HashMap<Box, List<Box>>();
		System.out.println(buildDP(boxes, null, cache));
		System.out.println(-3 % 4);
	}

}
