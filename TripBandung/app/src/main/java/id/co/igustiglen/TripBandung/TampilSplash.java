package id.co.igustiglen.TripBandung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * * Created by I Gusti Glen on 11-Agustus-20.
 * Nim :10117099
 * Kelas :IF-3
 */

public class TampilSplash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(500);
//                    sound.start();
                    Thread.sleep(2500);
                }catch (Exception e){

                }finally {
//                    sound.release();
                    startActivity(new Intent("android.intent.action.MAINACTIVITY"));
                    finish();
                }
            }
        }).start();
    }
}
