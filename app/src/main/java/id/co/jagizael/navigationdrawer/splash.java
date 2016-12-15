package id.co.jagizael.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Khariza on 3/28/2016.
 */
public class splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //setelah 5 detik, maka akan kita arahkan ke halaman utama
                Intent a = new Intent(getApplicationContext(), AwalActivity.class);
                startActivity(a);
                finish();
            }
        }, 5000L);
    }
}



