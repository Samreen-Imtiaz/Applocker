package test.applocker.com.applocker;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainScreen extends AppCompatActivity {


    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            Intent i = new Intent(MainScreen.this, MainScreen.class);
            MainScreen.this.startActivity(i);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   Intent i = new Intent(MainScreen.this, User_Profile.class);
     //   startActivity(i);
      //  finish();


                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if(!prefs.getBoolean("first_time", false))
                {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("first_time", true);
                    editor.commit();
                    Intent i = new Intent(MainScreen.this, User_Manual.class);
                    this.startActivity(i);
                    this.finish();
                }

                else
                {
                    this.setContentView(R.layout.activity_main);
                    handler.sendEmptyMessageDelayed(0, 3000);
                }

            }
        }



