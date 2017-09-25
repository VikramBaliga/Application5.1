package projects.android.my.application51;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView blinkText;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blinkText = (TextView) findViewById(R.id.blinkText);
        BlinkingText thread = new BlinkingText();
        thread.start();
    }

    class BlinkingText extends Thread
    {
        @Override
        public void run() {
            super.run();
            while (true)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception  ex)
                {

                }
                count++;
                if(true)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run()
                        {
                            System.out.println(count);
                            if(count%2==0)
                            {
                                blinkText.setTextColor(Color.WHITE);
                            }
                            else
                            {
                                blinkText.setTextColor(Color.BLACK);
                            }
                        }
                    });
                }
            }
        }
    }
}
