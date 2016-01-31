package friday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class ParallelMinPoint {

	public static List<Point> generatePoints() {
		List<Point> points = new ArrayList<>();
		Random rand = new Random();
		double x;
		double y;
		for (int i = 0; i < 10000; i++) {
			x = 10000 * rand.nextDouble();
			y = 10000 * rand.nextDouble();
			points.add(new Point(x, y));
		}
		return points;
	}

	private static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}

	private static Point findNearestPoint(Point p, List<Point> points) {
		Optional<Double> nearest = points.stream().map(x -> getDistance(p, x)).sorted().filter(y -> y > 0).findFirst();

		for (Point point : points) {
			if (getDistance(p, point) == nearest.get()) {
				return point;
			}
		}
		return null;
	}

	public static Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
		Map<Point, Point> result = new HashMap<>();
		int size = generatedPoints.size();

		Thread firstHalf = new Thread(new Runnable() {
			public void run() {
				doCalculations(generatedPoints, 0, size / 2, result);
			}
		});

		Thread secondHalf = new Thread(new Runnable() {
			public void run() {
				doCalculations(generatedPoints, size / 2, size, result);

			}
		});
		
		firstHalf.start();
		secondHalf.start();
		
		return result;

	}

	public static void doCalculations(List<Point> generatedPoints, int indexFrom, int indexTo,
			Map<Point, Point> outMap) {
		outMap = new HashMap<>();

		for (int i = indexFrom; i < indexTo; i++) {
			outMap.put(generatedPoints.get(i), findNearestPoint(generatedPoints.get(i), generatedPoints));
		}
	}

	public static void main(String[] args) {
		List<Point> points = generatePoints();

		long start = System.currentTimeMillis();
		Map<Point, Point> nearest = getNearestPoints(points);
		long end = System.currentTimeMillis();

		System.out.println(end - start);	
	}
}
