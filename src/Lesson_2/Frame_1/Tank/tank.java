package Lesson_2.Frame_1.Tank;

public class tank {
	
	private String color;
	private int maxSpeed;
	private int crew;

	tank () {
	}

	tank (String color, int maxSpeed, int crew) {
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.crew = crew;
	}

	@Override
	public String toString() {
		return "My main tank";
	}

	public String move () {
		return "My tank is drive";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed>200) {
			this.maxSpeed = 200;
		}
		else {
			this.maxSpeed = maxSpeed;
		}
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public String getColor() {
		return color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getCrew() {
		return crew;
	}


}
