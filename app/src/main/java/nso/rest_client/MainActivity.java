package nso.rest_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtRequestUri = (TextView)findViewById(R.id.txtRequestUri);
        Button btnExecute = (Button)findViewById(R.id.btnExecute);

        final TextView txtViewRespose = (TextView)findViewById(R.id.txtViewResponse);

        btnExecute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence strUri = txtRequestUri.getText();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL(strUri.toString());
                            HttpURLConnection con = (HttpURLConnection)url.openConnection();
                            con.setRequestMethod("GET");
                            con.connect();

                            String str = InputStreamToString(con.getInputStream());
                            txtViewRespose.setText(str);

                        } catch (Exception e) {
                            //
                        }
                    }
                }).start();
            }
        });
    }

    static String InputStreamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
