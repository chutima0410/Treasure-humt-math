package rtc.phornthip.chutima.treasuvehumtmath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private TextView questTextView, ch1TextView, ch2TextView, ch3TextView, scoreTextView;
    private Random random;
    private int firstAnInt, secondAnInt, answerAnInt, trueChoiceAnInt, scoreAnInt = 0;

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

        //Choice Controller
        ch1TextView.setOnClickListener(this);
        ch2TextView.setOnClickListener(this);
        ch3TextView.setOnClickListener(this);

        playController();


    }//Main Method

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
        for (int i=0;i<textViews.length;i++) {
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

        if (intChoice == answerAnInt) {
            scoreAnInt += 1;
        }

        scoreTextView.setText("Scoer = " + Integer.toString(scoreAnInt));

    }

}   //Main Class
