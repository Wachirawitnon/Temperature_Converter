package com.example.temperatureconverter;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.temperatureconverter.model.body;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();//ประกาศตัวแปร tag เพื่อ debug ทุกๆอย่างที่อยู่ภายในคลาสนี้ได้
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView showTextView = findViewById(R.id.show_text_view);
        final Button fahrenheit = findViewById(R.id.fahrenheit_button);
        final Button celsius = findViewById(R.id.celsius_button);


        fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEditText = findViewById(R.id.number_edit_text);
                String str = numberEditText.getText().toString().trim();//แปลงเป็น String เพื่อเช็ค validate
                if(str.equals("")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("เกิดข้อผิดพลาด");
                    dialog.setMessage("กรุณากรอกอุณหภูมิที่ต้องการแปลงค่า");
                    dialog.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ///โค๊ดที่ต้องการให้ทำงานหลังจากกดปุ่ม OK
                        }
                    });
                    dialog.setNegativeButton("ยกเลิก",null);
                    dialog.setCancelable(false);//เซตไว้ไม่ให้กดพื้นที่ว่างเพื่อออกจาก dialog ต้องกดที่ตัว dialog เท่านั้น
                    dialog.show();
                }else {
                    double input = Double.parseDouble(str);
                    body body = new body(input);
                    double calculate = body.toFahranheit(); //ส่งไปแปลงค่าเป็น F
                    String output = body.checkingDecimalF(calculate);// ส่งผลที่ได้ไปเช็คว่าเป็นทศนิยมที่ถูกรูปแบบตามความเป็นจริงหรือไม่
                    showTextView.setText(output);
                    showTextView.setBackgroundResource(R.drawable.textview_f_bg_rounded_corners);
                    fahrenheit.setBackgroundResource(R.drawable.button_bg_rounded_corners_change);
                    celsius.setBackgroundResource(R.drawable.button_bg_rounded_corners);
                   // Log.i(TAG, "ผลลัพธ์ = " + String.valueOf(output));//check log
                }

            }
        });

        celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEditText = findViewById(R.id.number_edit_text);
                String str = numberEditText.getText().toString().trim();
                if(str.equals("")){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("เกิดข้อผิดพลาด");
                    dialog.setMessage("กรุณากรอกอุณหภูมิที่ต้องการแปลงค่า");
                    dialog.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ///โค๊ดที่ต้องการให้ทำงานหลังจากกดปุ่ม OK
                        }
                    });
                    dialog.setNegativeButton("ยกเลิก",null);
                    dialog.setCancelable(false);//เซตไว้ไม่ให้กดพื้นที่ว่างเพื่อออกจาก dialog ต้องกดที่ตัว dialog เท่านั้น
                    dialog.show();

                }else {
                    double input = Double.parseDouble(str);
                    body body = new body(input);
                    double calculate = body.toCelsius();
                    String output = body.checkingDecimalC(calculate);
                    showTextView.setText(output);
                    showTextView.setBackgroundResource(R.drawable.textview_c_bg_rounded_corners);
                    celsius.setBackgroundResource(R.drawable.button_bg_rounded_corners_change);
                    fahrenheit.setBackgroundResource(R.drawable.button_bg_rounded_corners);
                   // Log.i(TAG, "ผลลัพธ์ = " + String.valueOf(output));//check log
                }
            }
        });





    }



}