package truefalse.zain.android.truefalse;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button mStartButton;
    Button mLessonButton;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            MediaPlayer btnClick=MediaPlayer.create(this,R.raw.on_click);

            mStartButton = (Button) findViewById(R.id.startButton);
            final MediaPlayer finalBtnClick = btnClick;
            mStartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, QuizActivity.class));

                    finalBtnClick.setLooping(false);
                    finalBtnClick.start();

                }
            });

        Button mLessonButton = (Button) findViewById(R.id.lessonButton);
            btnClick = MediaPlayer.create(this, R.raw.on_click);

        mLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, lessonScreen.class);
                startActivity(intent);

                finalBtnClick.setLooping(false);
                finalBtnClick.start();

            }
        });



    }

}










