package rtc.phornthip.chutima.treasuvehumtmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    //Explicit
    private TextView questTextView,ch1TextView,ch2TextView, ch3TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Bind widget
        questTextView = (TextView) findViewById(R.id.textView5);
        ch1TextView = (TextView) findViewById(R.id.textView2);
        ch2TextView = (TextView) findViewById(R.id.textView3);
        ch3TextView = (TextView) findViewById(R.id.textView4);


    }//Main Method


}   //Main Class
