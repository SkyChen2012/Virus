package com.benson.game.Sudoku;

/**
 * com.benson.game.Sudoku
 * Created by Benson on 2017/11/9-下午9:13.
 * 生成数独题目
 */

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;


public class SudokuPuzzles {

    private final static  String  TAG = "SudokuPuzzles";
    private  Boolean Debug = true;
    private int GameLevel = 0;

    public SudokuPuzzles(){}
    /**
     * 生成数独题目
     * @param GameLevel 游戏难度
     */
    public SudokuPuzzles(int GameLevel)
    {
        this.GameLevel = GameLevel;
    }

    /**
     * 打印二维数组，数独矩阵
      * @param a 二维数组
     */
    private void printArray(int a[][])
    {
        if (Debug) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    Log.d(TAG," "+a[i][j]);
                    if (0==((j+1)%3)) {
                        Log.d(TAG," ");
                    }
                }
                Log.d(TAG,"");
                if(0==((i+1)%3))
                {
                    Log.d(TAG,"");
                }
            }
        }
    }

    /**
     * 产生一个1-9的不重复长度为9的一维数组
     * @return 随机一维数组
     */
    private  ArrayList<Integer> creatNineRondomArray()
    {
        ArrayList <Integer>list = new ArrayList<Integer>();
        Random random=new Random();
        for (int i = 0; i < 9; i++) {
            int randomNum=random.nextInt(9)+1;
            while (true) {
                if (!list.contains(randomNum)) {
                    list.add(randomNum);
                    break;
                }
                randomNum=random.nextInt(9)+1;
            }

        }
        Log.d(TAG," 生成的一位数组为：");
        for (Integer integer : list) {
            Log.d(TAG," "+integer.toString());
        }
        return list;
    }
    /**
     * 通过一维数组和原数组生成随机的数独矩阵
     *   遍历二维数组里的数据，在一维数组找到当前值的位置，并把一维数组
     * 当前位置加一处位置的值赋到当前二维数组中。目的就是将一维数组为
     * 依据，按照随机产生的顺序，将这个9个数据进行循环交换，生成一个随
     * 机的数独矩阵。
     * @param seedArray 原数组
     * @param randomList 随机一维数组
     * @return
     */
    private   int[][] creatSudokuArray(int[][]seedArray,ArrayList<Integer> randomList)
    {
        int flag=1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if(seedArray[i][j]==randomList.get(k))
                    {
                        seedArray[i][j]=randomList.get((k+1)%9);
                        break;
                    }
                }
            }
        }
        Log.d(TAG,"处理后的数组");
        this.printArray(seedArray);
        return seedArray;
    }

    /**
     * 获取数独题目
     * @return
     */
    public int[][] creatSudoku() {
        int seedArray[][]={
                {9,7,8,3,1,2,6,4,5},
                {3,1,2,6,4,5,9,7,8},
                {6,4,5,9,7,8,3,1,2},
                {7,8,9,1,2,3,4,5,6},
                {1,2,3,4,5,6,7,8,9},
                {4,5,6,7,8,9,1,2,3},
                {8,9,7,2,3,1,5,6,4},
                {2,3,1,5,6,4,8,9,7},
                {5,6,4,8,9,7,2,3,1}
        };
        if (Debug) {
            Log.d(TAG, "原始的二维数组:");
            this.printArray(seedArray);
        }
        ArrayList<Integer> randomList=this.creatNineRondomArray();
        seedArray = this.creatSudokuArray(seedArray, randomList);
        return seedArray;
    }

    /**
     * 获取数独题目，带有难度
     * @param GameLevel 游戏难度
     * @return
     */
    public int[][] creatSudoku(int GameLevel) {
        return this.creatSudoku();
    }

    public String SudokuPuzzlesToString(int [][] Sudoku){
        StringBuffer SudokuStr = new StringBuffer();
        if (Sudoku.length > 0) {
            int i = 0,j = 0;
            for (i=0;i< Sudoku.length;i++){
                for (j=0;j<Sudoku[j].length;j++){
                    SudokuStr.append(Sudoku[i][j]);
                }
            }
        }
        return SudokuStr.toString();
    }


}