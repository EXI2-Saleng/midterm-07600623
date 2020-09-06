package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

        Button button_Cal = findViewById(R.id.button_cal);
        button_Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ET_dis = findViewById(R.id.ET_distance);
                EditText ET_Time = findViewById(R.id.ET_second);
                TextView Text_Ans = findViewById(R.id.text_ans);
                String ET_Dis = ET_dis.getText().toString();
                String ET_T = ET_Time.getText().toString();
                if(ET_Dis.isEmpty() || ET_T.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this, R.string.Distance_and_time_are_required,Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    Double S = Double.parseDouble(ET_Dis);
                    Double T = Double.parseDouble(ET_T);
                    if(T==0){
                        Toast t = Toast.makeText(MainActivity.this, R.string.TimeZero,Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Double ANS = (S / 1000) * (3600 / T);
                        Text_Ans.setText(String.format("%.2f", ANS));
                        if(ANS>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.OverLimit);
                            dialog.setPositiveButton("OK",null);
                            dialog.show();}
                    }
                }


            }
        });
        Button button_Clear = findViewById(R.id.button_clear);
        button_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ET_dis = findViewById(R.id.ET_distance);
                EditText ET_Time = findViewById(R.id.ET_second);
                TextView Text_Ans = findViewById(R.id.text_ans);
                ET_dis.setText("");
                ET_Time.setText("");
                Text_Ans.setText("");

            }
        });
    }
}