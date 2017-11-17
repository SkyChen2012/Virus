package com.benson.game.NumberGame.Entity;

import java.util.ArrayList;

/**
 * back 供用户不确定的数据放进去 (候选数字)
 * userNum是用户确定的数据
 * systemNum 是系统生成的数据
 * flag 是否是抹去的数字 : true是抹去的。false是没有抹去的
 *
 * com.benson.game.NumberGame.Entity
 * Created by Benson on 2017/11/16-下午2:26.
 */

public class NumNode {
    private ArrayList<Integer> back = new ArrayList<Integer>();
    public int systemNum = 0;
    public int userNum = 0;
    public boolean flag = false;

    /* 添加候选数，如果候选数的多于了9个那么就不能插入数字了 */
    boolean setBackNum(int num) {
        for (int i = 0; i < back.size(); i++) {
            if (num == back.get(i))
                return false;
        }
        if ((int) back.size() > 9) {
            return false;
        }
        back.add(num);
        return true;
    }
    /*去除队列中的某个数字*/
    void clearBackNum(Integer num){
        back.remove(num);
    }

    public ArrayList getBack() {
        return back;
    }

    @Override
    public String toString() {
        return "NumNode [systemNum:" + systemNum + ", userNum:" + userNum + ", flag:" + flag + "]";
    }

    public int getSystemNum() {
        return systemNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public boolean isFlag() {
        return flag;
    }
}