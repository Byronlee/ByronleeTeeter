package com.byronlee;

/**
 * 
 * @author Byronlee
 * 
 */
public class Food {

	//食品类型
	public int mFoodReward;

	
	// 加分物品    在屏幕上的滞留时间，也是食物循环出现的时间间隔
	//public static final int FOOD_ATTRIBUTE_DELAY_TIME = 450;
	//时间间隔，就是隔 mTimeCounter 的时间间隔 产生一个food
	//在 UI 类里面确定的
	public int mTimeCounter;

	public int mMinX;

	public int mMinY;

	public int mMaxX;

	public int mMaxY;

	public Food(int foodReward, int timeCounter, int x, int y, int size) {
		mFoodReward = foodReward;
		mTimeCounter = timeCounter;
		mMinX = x;
		mMinY = y;
		mMaxX = x + size;
		mMaxY = y + size;
	}
}
