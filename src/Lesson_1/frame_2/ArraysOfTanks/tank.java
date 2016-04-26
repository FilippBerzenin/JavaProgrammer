package Lesson_1.frame_2.ArraysOfTanks;

public class tank {
	
	private String color;
	private int maxSpeed;
	private int crew;

//	tank (String color, int maxSpeed, int crew) {
//		this.color = color;
//		this.maxSpeed = maxSpeed;
//		this.crew = crew;
//	}

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
