package com.practicaljava.lesson15;

public class UserPreferences implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6361242709356910065L;
	private String color;
	private String font;
	private int fontSize;
	
	public UserPreferences(String color, String font, int fontSize) {
		this.color = color;
		this.font = font;
		this.fontSize = fontSize;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getFont() {
		return font;
	}
	
	public void setFont(String font) {
		this.font = font;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}