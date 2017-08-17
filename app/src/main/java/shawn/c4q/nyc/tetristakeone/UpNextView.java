package shawn.c4q.nyc.tetristakeone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shawnspeaks on 8/16/17.
 */

public class UpNextView extends View {


    public UpNextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
        paint.setColor(R.color.colorAccent);
        paint.setTextSize(50);
        canvas.drawText("Up Next", 10, 25, paint);
    }
}
