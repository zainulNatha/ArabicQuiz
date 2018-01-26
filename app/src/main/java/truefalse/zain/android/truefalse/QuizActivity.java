package truefalse.zain.android.truefalse;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private Button mTrueButton, mFalseButton;
    private ProgressBar mProgressBar;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.points);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);
        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);

        updateQuestion();
        final MediaPlayer btnClickQuiz=MediaPlayer.create(this,R.raw.ahsant);
        final MediaPlayer btnClickQuizWrong=MediaPlayer.create(this,R.raw.wrong);

        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer == true) {
                    mScore++;
                    updateScore(mScore);
                    mProgressBar.setProgress(mQuestionNumber);
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    final MediaPlayer finalBtnClick = btnClickQuiz;
                    finalBtnClick.setLooping(false);
                    finalBtnClick.start();


                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();

                    }
                } else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                        Toast.makeText(QuizActivity.this,"wrong", Toast.LENGTH_SHORT).show();
                        final MediaPlayer finalBtnClick = btnClickQuizWrong;
                        finalBtnClick.setLooping(false);
                        finalBtnClick.start();
                    }
                }
            }
        });




        //Logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == false) {
                    mScore++;
                    updateScore(mScore);
                    mProgressBar.setProgress(mQuestionNumber);
                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    final MediaPlayer finalBtnClick = btnClickQuiz;
                    finalBtnClick.setLooping(false);
                    finalBtnClick.start();



                    //perform check before you update the question
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(QuizActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                        Toast.makeText(QuizActivity.this,"wrong", Toast.LENGTH_SHORT).show();
                        final MediaPlayer finalBtnClick = btnClickQuizWrong;
                        finalBtnClick.setLooping(false);
                        finalBtnClick.start();
                    }
                }
            }
        });

    }

    private void updateQuestion() {

        mQuestion.setText(QuizBook.questions[mQuestionNumber]);
        mAnswer = QuizBook.awnsers[mQuestionNumber];
        mQuestionNumber++;
        mProgressBar.setProgress(mQuestionNumber);
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }


}
