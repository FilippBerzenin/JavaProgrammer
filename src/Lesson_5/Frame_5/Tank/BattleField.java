package Lesson_5.Frame_5.Tank;

import Lesson_5.Frame_5.Tank.bf.*;
import Lesson_5.Frame_5.Tank.interfaces.BFObject;
import Lesson_5.Frame_5.Tank.interfaces.Drawable;

import java.awt.*;

public class BattleField implements Drawable {
	
	public static final String BRICK = "B";
	public static final String EAGLE = "E";
	public static final String ROCK = "R";
	public static final String WATER = "W";
	public static final String BLANK = " ";
	
	private int bfWidth = 576;
	private int bfHeight = 576;

	private String[][] battleFieldTemplate = {
			{" ", "B", " ", "B", " ", " ", " ", "B", " "},
			{" ", " ", "W", " ", " ", "B", " ", "B", " "},
			{" ", "B", "B", "B", "R", "B", "B", "B", " "},
			{" ", " ", " ", " ", " ", " ", " ", " ", " "},
			{"W", " ", "R", "B", "E", "B", "R", "B", "R"},
			{"W", " ", "W", " ", "B", "B", " ", " ", " "},
			{" ", " ", "W", "B", "R", "B", "B", " ", " "},
			{" ", "B", "B", " ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", "B", "W", "B", " ", " "}
		};

	public String[][] getBattleFieldTemplate() {
		return battleFieldTemplate;
	}

	private BFObject[][] battleField = new BFObject[9][9];

	public BattleField() {
		drawBattleField();
	}

	public BattleField(String[][] battleField) {
		this.battleFieldTemplate = battleField;
		drawBattleField();
	}
	
	private String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}
	
	private void drawBattleField() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				String coordinates = getQuadrantXY(i + 1, j + 1);
				int separator = coordinates.indexOf("_");
				int y = Integer.parseInt(coordinates
						.substring(0, separator));
				int x = Integer.parseInt(coordinates
						.substring(separator + 1));

				String obj = battleFieldTemplate[i][j];
				BFObject bfObject;
				if (obj.equals(BRICK)) {
					bfObject = new Brick(x, y);
				} else if (obj.equals(ROCK)) {
					bfObject = new Rock(x, y);
				} else if (obj.equals(EAGLE)) {
					bfObject = new Eagle(x, y);
				} else if (obj.equals(WATER)) {
					bfObject = new Water(x, y);
				} else {
					bfObject = new Blank(x, y);
				}
				battleField[i][j] = bfObject;
			}
		}
	}

	public int getX = -100;
	public int getY = -100;
	public int step;
	
	@Override
	public void draw(Graphics g) {
		for (int j = 0; j < battleField.length; j++) {
			for (int k = 0; k < battleField.length; k++) {
				battleField[j][k].draw(g); 
			}
		}
	}
	
	public void destroyObject(int v, int h) {
		battleField[v][h].destroy();
	}

	public BFObject scanQuadrant(int v, int h) {
		return battleField[v][h];
	}

	public String getAggressorLocation() {
		return "512_512";
	}


	public BFObject[][] getBattleField() {
		return battleField;
	}

	public int getBfWidth() {
		return bfWidth;
	}
	
	public int getBfHeight() {
		return bfHeight;
	}

}
