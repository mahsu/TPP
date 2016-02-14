package treehacks.tinderplusplus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Collections;

import cz.msebera.android.httpclient.Header;

public class Questions extends AppCompatActivity {

    private static ArrayList<Question> questions;
    private int currentQuestion = -1;
    private boolean[] answers = new boolean[questions.size()];
    private static Button optA, optB;

    static {
        questions = new ArrayList<>();
        questions.add(new Question(1,"Which pronounciation?", "Giff", "Jiff"));
        questions.add(new Question(2,"", "Android", "iOS"));
        questions.add(new Question(3,"Indentation Preference", "Tabs", "Spaces"));
        questions.add(new Question(4,"Naming Preferences", "Camel Case", "Snake Case"));
        questions.add(new Question(5,"Editor Color Scheme", "White on black", "Black on White"));
        questions.add(new Question(6,"", "github", "Bitbucket"));
        questions.add(new Question(7,"Strings", "Single Quotes", "Double Quotes"));
        questions.add(new Question(8,"", "Scrolling", "Inverted Scrolling"));
        questions.add(new Question(9,"", "Front End", "Back End"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Collections.shuffle(questions);
        optA = (Button)findViewById(R.id.optA);
        optB = (Button)findViewById(R.id.optB);

            nextQuestion();

            optA.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    answers[currentQuestion] = false;
                    nextQuestion();
                }
            });

            optB.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    answers[currentQuestion] = true;
                    nextQuestion();
                }
            });

    }

    public void nextQuestion() {
        if (currentQuestion < questions.size()-1){
            currentQuestion++;
            Question q = questions.get(currentQuestion);
            optA.setText(q.opt1);
            optB.setText(q.opt2);
        }
        else{
            pushToShared();
            asyncHttp(this);
        }
    }

    public static class Question {
        public String question;
        public String opt1;
        public String opt2;

        public Question(int id,String q, String o1, String o2) {
            question = q;
            opt1 = o1;
            opt2 = o2;
        }
    }

    public void pushToShared(){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        for (int i = 0; i < questions.size(); i++){
            editor.putBoolean(questions.get(i).toString(), answers[i]);
        }
        editor.apply();
        editor.commit();

    }
    private void asyncHttp(final Questions quest){
        final SharedPreferences settings = getPreferences(MODE_PRIVATE);

        RequestParams params = new RequestParams();
        for (String key: settings.getAll().keySet()){
            params.put(key,settings.getString(key +"", ""));
            System.out.println(key);
            //System.out.println(client.get("http://tinderplusplus.mybluemix.net/data/selectAns/1"));
        }

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://tinderplusplus.mybluemix.net/data/selectAns/1", params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
                Intent i = new Intent(quest, Matching.class);
                startActivity(i);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }

            @Override
            public void onRetry(int retryNo) {
                // called when request is retried
            }
        });

        settings.getAll();


    }

}
