package nso.rest_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
                CharSequence strUri = txtRequestUri.getText();

                txtViewRespose.setText(strUri);
            }
        });

    }
}
