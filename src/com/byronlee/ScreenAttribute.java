package com.byronlee;

/**
 * 
 * @author Byronlee
 */
public class ScreenAttribute {
	// 最小X坐标
	public int minX;
	// 最小Y坐标
	public int minY;
	// 最大X坐标
	public int maxX;
	// 最大Y坐标
	public int maxY;

	public ScreenAttribute(int minX, int minY, int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;
	}
}
