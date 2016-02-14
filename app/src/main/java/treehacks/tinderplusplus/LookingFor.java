package treehacks.tinderplusplus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;

public class LookingFor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_for);
        SeekBar _genderpref = (SeekBar)findViewById(R.id.seekBar2);
        int genderpref = _genderpref.getProgress();

        Spinner _agepref = (Spinner) findViewById(R.id.agepref);
        String agepref = _agepref.getSelectedItem().toString();
        //agepref in form "25 to 30" or "45 to 100"
        int agemin = Integer.parseInt(agepref.substring(0, 1));
        int agemax = Integer.parseInt(agepref.substring(6));

        findViewById(R.id.next2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onNextButtonClicked(v);
            }
        });

        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putInt("genderpref", genderpref);
        editor.putString("agepref", agepref);
        editor.apply();
        editor.commit();


    }

    public void onNextButtonClicked(View view){
        Intent i = new Intent(this, Questions.class);
        startActivity(i);
    }
}
