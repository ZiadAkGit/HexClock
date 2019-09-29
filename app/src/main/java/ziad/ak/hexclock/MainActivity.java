package ziad.ak.hexclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBackground();
    }

    public void setBackground(){
        final Handler handler = new Handler();
        final int delay = 1000; //milliseconds
        handler.postDelayed(new Runnable(){
            public void run(){
                tv = findViewById(R.id.tv1);
                String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                String timewithoutdots = currentTime.replace(":", "");
                ConstraintLayout currentLayout = findViewById(R.id.background);
                currentLayout.setBackgroundColor(Color.parseColor("#" + timewithoutdots));
                tv.setText("#" + timewithoutdots);
                handler.postDelayed(this, delay);
            }
        }, delay);
    }

}
