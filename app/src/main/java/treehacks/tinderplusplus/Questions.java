package treehacks.tinderplusplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class Questions extends AppCompatActivity {

    private static ArrayList<Question> q;

    static {
        q = new ArrayList<>();
        q.add(new Question("Which pronounciation?", "Giff", "Jiff"));
        q.add(new Question("", "Android", "iOS"));
        q.add(new Question("Indentation Preference", "Tabs", "Spaces"));
        q.add(new Question("Naming Preferences","Camel Case","Snake Case"));
        q.add(new Question("Editor Color Scheme","White on black","Black on White"));
        q.add(new Question("","github","Bitbucket"));
        q.add(new Question("Strings","Single Quotes","Double Quotes"));
        q.add(new Question("","Scrolling","Inverted Scrolling"));
        q.add(new Question("","Front End","Back End"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        q.add(new Question("Which pronounciation?", "Giff", "Jiff"));
        q.add(new Question("", "Android", "iOS"));
        q.add(new Question("Indentation Preference", "Tabs", "Spaces"));
        q.add(new Question("Naming Preferences","Camel Case","Snake Case"));
        q.add(new Question("Editor Color Scheme","White on black","Black on White"));
        q.add(new Question("","github","Bitbucket"));
        q.add(new Question("Strings","Single Quotes","Double Quotes"));
        q.add(new Question("","Scrolling","Inverted Scrolling"));
        q.add(new Question("","Front End","Back End"));
        Collections.shuffle(q);
    }

    public static class Question {
        public String question;
        public String opt1;
        public String opt2;

        public Question(String q, String o1, String o2) {
            question = q;
            opt1 = o1;
            opt2 = o2;
        }
    }

}
