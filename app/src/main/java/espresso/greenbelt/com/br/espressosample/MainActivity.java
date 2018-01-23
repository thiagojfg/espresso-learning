package espresso.greenbelt.com.br.espressosample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextNumero1 = findViewById(R.id.editTextNumero1);
        final EditText editTextNumero2 = findViewById(R.id.editTextNumero2);
        final TextView textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonSomar = findViewById(R.id.buttonSomar);

        buttonSomar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String n1 = editTextNumero1.getText().toString();
                String n2 = editTextNumero2.getText().toString();

                if(n1.isEmpty()){

                    Toast.makeText(MainActivity.this, "Missing Number 1", Toast.LENGTH_SHORT).show();

                    return;
                }

                if(n2.isEmpty()){

                    Toast.makeText(MainActivity.this, "Missing Number 2", Toast.LENGTH_SHORT).show();

                    return;
                }

                Long number1 = Long.valueOf(n1);
                Long number2 = Long.valueOf(n2);

                textViewResultado.setText(String.valueOf(number1 + number2));
            }
        });
    }
}
