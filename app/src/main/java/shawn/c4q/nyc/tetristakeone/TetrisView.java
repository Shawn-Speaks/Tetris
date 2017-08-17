package shawn.c4q.nyc.tetristakeone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shawnspeaks on 8/16/17.
 */

public class TetrisView extends View {

    Paint mPaint;
    int state = 0;
    int distFromCenterOfShape = 50;
    int left;
    int top;
    int right;
    int bottom;

    /**
     * STATE 1 == LEFT
     * STATE 2 = DOWN
     * STATE 3 = RIGHT
     * STATE 5 = DRAW NEW RECTANGLE
     * @param context
     * @param attrs
     */

    public TetrisView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(state == 0){
            setPositions();
        }else if(state == 1){
            if(left - distFromCenterOfShape > 0) {
                shiftLeft();
            }
        }else if(state == 2){
            if(bottom + distFromCenterOfShape < getHeight()) {
                shiftDown();
            }
        }else if(state == 3){
            if(right + distFromCenterOfShape < getWidth()) {
                shiftRight();
            }
        }else if(state == 5) {
            setPositions();
        }
        canvas.drawRect(left, top, right, bottom, mPaint);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.FILL);
    }

    private void setPositions(){
        left = getWidth()/2 - distFromCenterOfShape;
        top = getHeight()/2 - distFromCenterOfShape;
        right = getWidth()/2 + distFromCenterOfShape;
        bottom = getHeight()/2  + distFromCenterOfShape;
    }


    private void shiftLeft(){
        left -= distFromCenterOfShape;
        right -= distFromCenterOfShape;
    }

    private void shiftRight(){
        right +=  distFromCenterOfShape;
        left += distFromCenterOfShape;
    }

    private void shiftDown(){
        top +=  distFromCenterOfShape;
        bottom +=  distFromCenterOfShape;
    }



    private void rotate(){
        setPositions();
    }

}
