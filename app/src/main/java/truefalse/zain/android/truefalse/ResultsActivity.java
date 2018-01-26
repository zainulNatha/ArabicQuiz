package truefalse.zain.android.truefalse;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {


    TextView mGrade, mFinalScore;
    Button mRetryButton;
    Button mReviseButton;
    Button mShareButton;
    Intent shareIntent;
    RatingBar mRatingBar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = (TextView) findViewById(R.id.grade);
        mFinalScore = (TextView) findViewById(R.id.outOf);
        mRetryButton = (Button) findViewById(R.id.retry);
        mReviseButton = (Button) findViewById(R.id.revise);
        mShareButton=(Button)findViewById(R.id.share);
        mRatingBar = (RatingBar) findViewById(R.id.rating_bar);








        final MediaPlayer btnClickResults = MediaPlayer.create(this, R.raw.on_click);

        Bundle bundle = getIntent().getExtras();
        final int score = bundle.getInt("finalScore");

        mFinalScore.setText( " You scored " + score + " out of " + QuizBook.questions.length);
        mRatingBar.setRating(score);

        if (score == 8) {
            mGrade.setText("Outstanding");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.trophy);
            MediaPlayer player = MediaPlayer.create(this, R.raw.cheering_short);
            player.setLooping(false);
            player.start();

        } else if (score == 7) {
            mGrade.setText("Good work");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.thumbsup);

        } else if (score == 6) {
            mGrade.setText("Good work");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.thumbsup);

        } else if (score == 5) {
            mGrade.setText("Good work");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.thumbsup);


        } else if (score == 4) {
            mGrade.setText("Good Effort");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.thumbsup);


        } else {
            mGrade.setText("Go over your notes");
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageResource(R.drawable.revise);
        }



        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
                btnClickResults.setLooping(false);
                btnClickResults.start();

            }
        });
        Button mReviseButton = (Button) findViewById(R.id.revise);

        mReviseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultsActivity.this, lessonScreen.class);
                startActivity(intent);
                btnClickResults.setLooping(false);
                btnClickResults.start();
            }
        });

        Button mShareButton=(Button)findViewById(R.id.share);

        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My Score!");
                shareIntent.putExtra(Intent.EXTRA_TEXT,  " I got " + score + " out of 8 in Quiz 1: Makhaarij. " +
                        " What did you get? ");
                startActivity(Intent.createChooser(shareIntent, "Share via"));

            }

        });



    }

}





