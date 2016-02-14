package treehacks.tinderplusplus;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class Matching extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
    }

    private void asyncHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://tinderplusplus.mybluemix.net/data/selectAns/1", new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                // called before request is started
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                // called when response HTTP status is "200 OK"
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

        final SharedPreferences settings = getPreferences(MODE_PRIVATE);
        settings.getAll();

        RequestParams params = new RequestParams();
        for (String key: settings.getAll().keySet()){
            params.put(key,settings.getString(key +"", ""));
            System.out.println(key);
            System.out.println(client.get("http://tinderplusplus.mybluemix.net/data/getAns/1",null));
        }
    }
}
