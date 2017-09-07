package com.benson.game.AgileBuddy.data;

/**
 * com.benson.game.AgileBuddy.data
 * Created by Benson on 2017/2/8-下午9:01.
 */

public class Food {

    public int mFoodReward;

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
