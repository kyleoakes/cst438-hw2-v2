package cst438.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TempAndTime {
	
	double temp;
	long time;
	int timezone;
	String readableTemp;
	String readableTime;
	
	public TempAndTime(double temp, long time, int timezone) {
		super();
		this.temp = temp;
		this.time = time;
		this.timezone = timezone;
		updateReadableTime(timezone, time);
		updateReadableTemp();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempAndTime other = (TempAndTime) obj;
		if (readableTemp == null) {
			if (other.readableTemp != null)
				return false;
		} else if (!readableTemp.equals(other.readableTemp))
			return false;
		if (readableTime == null) {
			if (other.readableTime != null)
				return false;
		} else if (!readableTime.equals(other.readableTime))
			return false;
		if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp))
			return false;
		if (time != other.time)
			return false;
		if (timezone != other.timezone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TempAndTime [temp=" + temp + ", time=" + time + ", timezone=" + timezone + ", readableTemp="
				+ readableTemp + ", readableTime=" + readableTime + "]";
	}
	
	private void updateReadableTime(int timezone, long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		tz.setRawOffset(timezone*1000);
		sdf.setTimeZone(tz);
		Date date = new Date(time);
		this.readableTime = sdf.format(date);
	}
	
	private void updateReadableTemp() {
		double tempF = (this.temp - 273.15) * 9.0/5.0 + 32.0;
		tempF = ((int)(tempF*100.0))/100.0;
		this.readableTemp = tempF + " °F";
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
		updateReadableTemp();
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
		updateReadableTime(timezone, time);
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public String getReadableTemp() {
		return readableTemp;
	}

	public void setReadableTemp(String readableTemp) {
		this.readableTemp = readableTemp;
	}

	public String getReadableTime() {
		return readableTime;
	}

	public void setReadableTime(String readableTime) {
		this.readableTime = readableTime;
	}
		
}
