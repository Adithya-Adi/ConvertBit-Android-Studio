package com.example.convertbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText val;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] arraySpinner = new String[] {
                "Binary","Decimal","Octal","Hexadecimal"
        };
        val =findViewById(R.id.value1);
        Spinner s = findViewById(R.id.spinner3);
        Spinner s1 = findViewById(R.id.spinner5);
        textView = findViewById(R.id.textView6);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s1.setAdapter(adapter);
        final Button btnConvert = findViewById(R.id.button4);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = s.getSelectedItem().toString();
                String to = s1.getSelectedItem().toString();
                String value = val.getText().toString();

                if(val.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter the value", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (from == "Binary" && to == "Decimal") {
                            int decimal = Integer.parseInt(value, 2);
                            textView.setText(decimal + " ");
                        } else if (from == "Binary" && to == "Hexadecimal") {
                            int decimal = Integer.parseInt(value, 2);
                            String hexadecimal = (Integer.toHexString(decimal));
                            textView.setText(hexadecimal + " ");
                        } else if (from == "Binary" && to == "Octal") {
                            int decimal = Integer.parseInt(value, 2);
                            int octal = Integer.parseInt(Integer.toOctalString(decimal));
                            textView.setText(octal + " ");
                        } else if (from == "Decimal" && to == "Binary") {
                            int binary = Integer.parseInt(Integer.toBinaryString(Integer.parseInt(value)));
                            textView.setText(binary + " ");
                        } else if (from == "Decimal" && to == "Hexadecimal") {
                            String hexadecimal = (Integer.toHexString(Integer.parseInt(value)));
                            textView.setText(hexadecimal + " ");
                        } else if (from == "Decimal" && to == "Octal") {
                            int octal = Integer.parseInt(Integer.toOctalString(Integer.parseInt(value)));
                            textView.setText(octal + " ");
                        } else if (from == "Hexadecimal" && to == "Decimal") {
                            int decimal = Integer.parseInt(value, 16);
                            textView.setText(decimal + " ");
                        } else if (from == "Hexadecimal" && to == "Binary") {
                            int decimal = Integer.parseInt(value, 16);
                            int binary = Integer.parseInt(Integer.toBinaryString(decimal));
                            textView.setText(binary + " ");
                        } else if (from == "Hexadecimal" && to == "Octal") {
                            int decimal = Integer.parseInt(value, 16);
                            int octal = Integer.parseInt(Integer.toOctalString(decimal));
                            textView.setText(octal + " ");
                        } else if (from == "Octal" && to == "Decimal") {
                            int decimal = Integer.parseInt(value, 8);
                            textView.setText(decimal + " ");
                        } else if (from == "Octal" && to == "Binary") {
                            int decimal = Integer.parseInt(value, 8);
                            int binary = Integer.parseInt(Integer.toBinaryString(decimal));
                            textView.setText(binary + " ");
                        }
                        else if (from == "Octal" && to == "Hexadecimal") {
                            int decimal = Integer.parseInt(value, 8);
                            String hexadecimal = (Integer.toHexString(decimal));
                            textView.setText(hexadecimal + " ");

                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception e)
                    {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}