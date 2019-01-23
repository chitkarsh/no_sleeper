import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class NoSleeper {

	private static int TIME_IN_MINUTES = 2;

	public static void main(String[] args) {
		if (args.length != 0) {
			try {
				TIME_IN_MINUTES = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Enter parameter as integer time in minutes");
				System.out.println("java -jar nosleep 2");
			}
		}
		try {
			while (true) {
				int time = TIME_IN_MINUTES * 1000 * 60;
				Thread.sleep(time);
				Point currentMouseLocation = MouseInfo.getPointerInfo().getLocation();
				Robot robot = new Robot();
				robot.mouseMove(currentMouseLocation.x, currentMouseLocation.y);
			}
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
