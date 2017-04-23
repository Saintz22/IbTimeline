package ibtime.ibtimeline;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class image360 extends AppCompatActivity {

    int mStartX, mStartY, mEndX, mEndY, mImageIndex;
    ImageView m360DegreeImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image360);
        m360DegreeImageView = (ImageView)findViewById(R.id.santafe3dview);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :

                mStartX = (int)event.getX();
                mStartY = (int)event.getY();
                return true;

            case (MotionEvent.ACTION_MOVE) :

                mEndX = (int)event.getX();
                mEndY = (int)event.getY();

                if((mEndX - mStartX) > 3) {
                    mImageIndex++;
                    if(mImageIndex > 56 )
                        mImageIndex = 0;

                    m360DegreeImageView.setImageLevel(mImageIndex);

                }
                if((mEndX - mStartX) < -3) {
                    mImageIndex--;
                    if(mImageIndex <0)
                        mImageIndex = 56;

                    m360DegreeImageView.setImageLevel(mImageIndex);

                }
                mStartX = (int)event.getX();
                mStartY = (int)event.getY();
                return true;

            case (MotionEvent.ACTION_UP) :
                mEndX = (int)event.getX();
                mEndY = (int)event.getY();

                return true;

            case (MotionEvent.ACTION_CANCEL) :
                return true;

            case (MotionEvent.ACTION_OUTSIDE) :
                return true;

            default :
                return super.onTouchEvent(event);
        }
    }

    public void goTime(View v){

        Intent newAct = new Intent(getApplicationContext(), MainMenu.class);
        startActivity(newAct);

    }

}
