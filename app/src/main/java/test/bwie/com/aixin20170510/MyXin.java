package test.bwie.com.aixin20170510;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;


/**
 * @类的用途:
 * @author:jiajianhai
 * @date:2017/5/10
 */

public class MyXin extends View {

    private Paint criPaint;

    public MyXin(Context context) {
        super(context);
    }
/*
    public MyXin(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyXin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        createPaint();
        creatHeart(R.color.colorAccent);
    }

    private void createPaint() {
        criPaint = new Paint();
        criPaint.setColor(Color.RED);

    }

    private Bitmap bitmap;

    private Bitmap creatHeart(int color) {


        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap newBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawBitmap(bitmap, 0, 0, criPaint);
        canvas.drawColor(color, PorterDuff.Mode.SRC_ATOP);
        canvas.setBitmap(null);
        return newBitmap;
    }*/
}