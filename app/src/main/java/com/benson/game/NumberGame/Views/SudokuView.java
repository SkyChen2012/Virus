package com.benson.game.NumberGame.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.benson.game.NumberGame.Entity.SudokuArray;
import com.benson.game.NumberGame.Entity.SudokuGame;
import com.benson.virus.R;


/**
 * Created by Benson.Chen on 2016/11/18.
 */

public class SudokuView extends View {

    private  final  static String Tag = "SudokuView";
    //单元格的宽度和高度
    private float width;
    private float height;
    private int selectedX;
    private int selectedY;

    private Context mcontext;

    private int[][] sudokuArray;
    private String sudokuStr;
    private String sudokuStr2;

    private SudokuArray numAloneArray = new SudokuArray(9, 5);

    private SudokuGame game;
    public SudokuView(Context context) {
        this(context,null);
    }

    public SudokuView(Context context ,AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SudokuView(Context context, AttributeSet attrs, int defStyle) {
        super(context ,attrs ,defStyle);
        init(context);
        Log.i(Tag,"(Context context, AttributeSet attrs, int defStyle)");
    }

    private void init(Context context){
        this.mcontext = context;
        Log.i(Tag,sudokuStr);
        numAloneArray.begin();
        StringBuffer SudokuStrBuf = new StringBuffer();
        for (int m = 0; m < numAloneArray.getArray().length; m ++){
            for (int n = 0; n < numAloneArray.getArray()[m].length ;n++){
                Log.i(Tag,"numAloneArray.getArray()[" + m + "][" + n + "] = "+numAloneArray.getArray()[m][n].toString());
                if (!numAloneArray.getArray()[m][n].isFlag()) {
                    SudokuStrBuf.append(numAloneArray.getArray()[m][n].getSystemNum());
                }else {
                    SudokuStrBuf.append(0);
                }

            }
        }
        Log.i(Tag,"SudokuStrBuf:"+SudokuStrBuf.toString());
        game = new SudokuGame(SudokuStrBuf.toString());
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //计算当前单元格的宽度和高度
        this.width = w / 9f;
        this.height = h / 9f;
        if (this.width > this.height)
        {
            this.width = this.height;
        }else{
            this.height = this.width;
        }
        Log.i(Tag, "w:"+ w + "h:" + h + "oldw:" + oldw + "oldh:" + oldh);
        super.onSizeChanged(w+1, h+1, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //生成用于绘制背景色的画笔
        Paint backgroundPaint = new Paint();
        //设置画笔的颜色
        backgroundPaint.setColor( ResourcesCompat.getColor(getResources(),  R.color.Sudoku_background,null));
        //绘制背景色
        canvas.drawRect(0, 0, getWidth(), getHeight(), backgroundPaint);

        Paint darkPaint = new Paint();
        darkPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.Sudoku_dark,null));

        Paint hilitePaint = new Paint();
        hilitePaint.setColor(ResourcesCompat.getColor(getResources(), R.color.Sudoku_hilite,null));

        Paint lightPaint = new Paint();
        lightPaint.setColor(ResourcesCompat.getColor(getResources(), R.color.Sudoku_light,null));
        for(int i = 1; i < 9 ;i++){
            //一下两行代码用户绘制横向的单元格线
            canvas.drawLine(0, i * height, getWidth(), i * height,lightPaint);
            canvas.drawLine(0, i * height + 1, getWidth(), i * height + 1, hilitePaint);

            canvas.drawLine(i * width, 0, i * width, getHeight(), lightPaint);
            canvas.drawLine(i * width +1, 0, i * width + 1, getHeight(), hilitePaint);
        }

        for(int i = 1 ; i < 10;i++){
            if(i % 3 != 0){
                continue;
            }
            canvas.drawLine(0, i * height, getWidth(), i* height, darkPaint);
            canvas.drawLine(0,i * height + 1,getWidth(), i * height + 1,hilitePaint);
            canvas.drawLine(i * width, 0, i * width, getHeight(), darkPaint);
            canvas.drawLine(i * width + 1, 0, i * width + 1, getHeight(), hilitePaint);
        }

        //绘制数字
        Paint numberPaint = new Paint();
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.STROKE);
        numberPaint.setTextSize( height * 0.75f);
        numberPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fm = numberPaint.getFontMetrics();
        float x = width/2;

        float y = height / 2 - (fm.ascent + fm.descent) /2;
        for(int i = 0 ; i < 9; i++){
            for(int j = 0; j < 9 ;j++){
                canvas.drawText(game.getTileString(i, j), i * width + x,  j * height + y, numberPaint);
            }
        }
        super.onDraw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN){
            return super.onTouchEvent(event);
        }

        selectedX = (int)(event.getX() / width);
        selectedY = (int)(event.getY() / height);

        int  used [] = game.getUsedTilesByCoor(selectedX, selectedY);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < used.length; i++) {
            sb.append(used[i]);
        }

        KeyDialog keyDialog = new KeyDialog(getContext(), used,this);
        keyDialog.show();

        return true;
    }
    public void setSelectedTile(int tile) {
        if (game.setTileIfValid(selectedX, selectedY, tile)) {
            invalidate();
        }
    }

    /**
     * 根据xml的设定获取宽度/根据xml的设定获取高度
     * @param measureSpec
     * @return
     */
    private int measureWidth(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST){
        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY){
        }
        Log.i("这个控件的宽度----------","specMode=" + specMode + " specSize=" + specSize);
        return specSize;
    }

    /**
     * 根据xml的设定获取高度
     * @param measureSpec
     * @return
     */
    private int measureHeight(int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        //wrap_content
        if (specMode == MeasureSpec.AT_MOST){
        }
        //fill_parent或者精确值
        else if (specMode == MeasureSpec.EXACTLY){
        }
        Log.i("这个控件的高度----------","specMode:" + specMode + "specSize:" + specSize);
        return specSize;
    }
}
