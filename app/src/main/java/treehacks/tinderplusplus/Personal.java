package treehacks.tinderplusplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Personal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                onSubmitButtonClicked(v);
            }
        });
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }
    public void onSubmitButtonClicked(View view){
        Intent i = new Intent(this, LookingFor.class);
        startActivity(i);
    }

    public class DataContainer {
        String name, lang, pickup, project;
        int gender, age;
        public DataContainer() {
            EditText _name = ((EditText)findViewById(R.id.name));
            name = _name.getText().toString();
            SeekBar _gender = (SeekBar)findViewById(R.id.gender);
            gender = _gender.getProgress();
            EditText _age = (EditText)findViewById(R.id.age);
            age = Integer.parseInt(_age.getText().toString());
            Spinner _lang = (Spinner)(findViewById(R.id.language));
            lang = _lang.getSelectedItem().toString();
            EditText _pickup = (EditText)findViewById(R.id.pickupline);
            pickup = _pickup.getText().toString();
            EditText _project = (EditText)findViewById(R.id.project);
            project = _project.getText().toString();
        }

    }
}
