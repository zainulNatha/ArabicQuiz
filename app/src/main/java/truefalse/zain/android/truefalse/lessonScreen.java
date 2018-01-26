package truefalse.zain.android.truefalse;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class lessonScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        MediaPlayer btnClick=MediaPlayer.create(this,R.raw.on_click);

        Button mStartButton = (Button) findViewById(R.id.startButton);
        MediaPlayer finalBtnClick = btnClick;
        final MediaPlayer finalBtnClick1 = finalBtnClick;
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lessonScreen.this, QuizActivity.class));

                finalBtnClick1.setLooping(false);
                finalBtnClick1.start();

            }
        });


        Button mHomeButton = (Button) findViewById(R.id.homeScreenButton);
        finalBtnClick = btnClick;

        final MediaPlayer finalBtnClick2 = finalBtnClick;
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(lessonScreen.this, MainActivity.class);
                startActivity(intent);
                finalBtnClick2.setLooping(false);
                finalBtnClick2.start();
            }
        });

        VideoView quranVideo = (VideoView) findViewById(R.id.videoLesson);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.app_vid_final;
        Uri uri = Uri.parse(videoPath);
        quranVideo.setVideoURI(uri);

        MediaController mediaController=new MediaController(lessonScreen.this);
        quranVideo.setMediaController(mediaController);
        mediaController.setAnchorView(quranVideo);
    }
}

