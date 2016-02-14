package treehacks.tinderplusplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LookingFor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looking_for);

        findViewById(R.id.next2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onNextButtonClicked(v);
            }
        });
    }

    public void onNextButtonClicked(View view){
        Intent i = new Intent(this, Questions.class);
        startActivity(i);
    }
}
