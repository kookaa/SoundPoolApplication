package com.koo.android.practice.soundpoolapplication;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    SoundPool sp;
    int sound_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        //インスタンス作成
        sp       = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound_id = sp.load(this, R.raw.q_se, 1 );

        Button btn = new Button(this);
        btn.setText("ボタンを押すと音がなります");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(sound_id, 1.0F, 1.0F, 0, 0, 1.0F);
            }

        });
        ll.addView(btn);
    }

    @Override
    public void onPause(){
        super.onPause();
        sp.release();
    }
}
