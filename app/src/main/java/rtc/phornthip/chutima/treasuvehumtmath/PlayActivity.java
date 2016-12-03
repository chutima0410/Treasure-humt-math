package rtc.phornthip.chutima.treasuvehumtmath;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private TextView questTextView, ch1TextView, ch2TextView,
            ch3TextView, scoreTextView, timeTextView;
    private Random random;
    private int firstAnInt, secondAnInt, answerAnInt, trueChoiceAnInt, scoreAnInt = 0;
    private int timeAnInt = 30; // นี่คือเวลาลูป
    private ImageView boat1ImageView, boat2ImageView, boat3ImageView, boat4ImageView;
    private ImageView[] imageViews;
    private int falseAnInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        random = new Random();

        //Bind widget
        questTextView = (TextView) findViewById(R.id.textView5);
        ch1TextView = (TextView) findViewById(R.id.textView2);
        ch2TextView = (TextView) findViewById(R.id.textView3);
        ch3TextView = (TextView) findViewById(R.id.textView4);
        scoreTextView = (TextView) findViewById(R.id.textView6);
        timeTextView = (TextView) findViewById(R.id.textView7);
        boat1ImageView = (ImageView) findViewById(R.id.imageView3);
        boat2ImageView = (ImageView) findViewById(R.id.imageView4);
        boat3ImageView = (ImageView) findViewById(R.id.imageView5);
        boat4ImageView = (ImageView) findViewById(R.id.imageView6);

        imageViews = new ImageView[]{boat1ImageView, boat2ImageView, boat3ImageView,
                boat4ImageView};


        //Choice Controller

        ch1TextView.setOnClickListener(this);
        ch2TextView.setOnClickListener(this);
        ch3TextView.setOnClickListener(this);

        playController();

        countTime();


    }//Main Method

    private void countTime() {
        timeAnInt -= 1;
        timeTextView.setText(Integer.toString(timeAnInt) + "วินาที");
        if (timeAnInt < 0) {
            // สิ่งที่จะทำหลังเวลาหมด


           myRestartApp();

        } // if


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                countTime();
            }
        }, 1000);

    }   // countTime

    private void playController() {

        firstAnInt = random.nextInt(100);
        secondAnInt = random.nextInt(100);
        answerAnInt = firstAnInt + secondAnInt;
        trueChoiceAnInt = random.nextInt(3);
        Log.d("3decV1", "Choice True ==> " + (trueChoiceAnInt + 1));

        //Show Qurstion
        questTextView.setText(Integer.toString(firstAnInt) + " + " +
                Integer.toString(secondAnInt) + " = ?");

        //Show Choice
        TextView[] textViews = new TextView[]{ch1TextView, ch2TextView, ch3TextView};
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setText(Integer.toString(random.nextInt(100)));
        }   // for

        //Show True Choice
        textViews[trueChoiceAnInt].setText(Integer.toString(answerAnInt));


    }   // playController


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.textView2:
                checkAnser(Integer.parseInt(ch1TextView.getText().toString()));
                break;
            case R.id.textView3:
                checkAnser(Integer.parseInt(ch2TextView.getText().toString()));
                break;
            case R.id.textView4:
                checkAnser(Integer.parseInt(ch3TextView.getText().toString()));
                break;
        }

        playController();

    }   // onClick

    private void checkAnser(int intChoice) {

        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setVisibility(View.INVISIBLE);
        }

        if (scoreAnInt < 5) {
            imageViews[0].setVisibility(View.VISIBLE);
        } else if (scoreAnInt < 10) {
            imageViews[1].setVisibility(View.VISIBLE);
        } else if (scoreAnInt < 15) {
            imageViews[2].setVisibility(View.VISIBLE);
        } else {
            imageViews[3].setVisibility(View.VISIBLE);
        }



        if (intChoice == answerAnInt) {
            scoreAnInt += 1;
        } else {

            if (scoreAnInt >= 3) {
                Toast.makeText(PlayActivity.this, "Game Over", Toast.LENGTH_SHORT).show();

                myRestartApp();


            }

            falseAnInt += 1;
            Log.d("3devV1", "false ==> " + falseAnInt);

            switch (falseAnInt) {

                case 0:
                    boat1ImageView.setImageResource(R.drawable.y);
                    boat2ImageView.setImageResource(R.drawable.y);
                    boat3ImageView.setImageResource(R.drawable.y);
                    boat4ImageView.setImageResource(R.drawable.y);
                    break;

                case 1:
                    boat1ImageView.setImageResource(R.drawable.y1);
                    boat2ImageView.setImageResource(R.drawable.y1);
                    boat3ImageView.setImageResource(R.drawable.y1);
                    boat4ImageView.setImageResource(R.drawable.y1);
                    break;

                case 2:
                    boat1ImageView.setImageResource(R.drawable.y2);
                    boat2ImageView.setImageResource(R.drawable.y2);
                    boat3ImageView.setImageResource(R.drawable.y2);
                    boat4ImageView.setImageResource(R.drawable.y2);
                    break;

            }   // switch




        }

        scoreTextView.setText("Score = " + Integer.toString(scoreAnInt));


    }   // checkAnser

    private void myRestartApp() {

        scoreAnInt = 0;
        timeAnInt = 30;

        Intent intent = getIntent();
        finish();
        startActivity(intent);

    }

}   //Main Class
