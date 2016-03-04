package timeLord;

import java.util.Calendar;

public class Time {

	private int day;
	private int month;
	private int year;
	private int hour;
	private int minutes;
	private int seconds;
	
	public Time(int day, int month, int year, int hour, int minutes, int seconds) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return String.format("%d:%d:%d %d.%d.%d", this.hour, this.minutes, this.seconds, this.day, this.month,
				this.year);
	}

	public static Time now() {
		Calendar now = Calendar.getInstance();
		
		int day = now.get(Calendar.DAY_OF_MONTH);
		int month = now.get(Calendar.MONTH);
		int year = now.get(Calendar.YEAR);
		int hour = now.get(Calendar.HOUR);
		int minutes = now.get(Calendar.MINUTE);
		int seconds = now.get(Calendar.SECOND);
		
		return new Time(day, month, year, hour, minutes, seconds);
	}
}
