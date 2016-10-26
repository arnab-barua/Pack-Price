package com.mycompany.packprice;

import android.graphics.Typeface;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    TextView fp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = (EditText) findViewById(R.id.package_price);
        fp = (TextView) findViewById(R.id.final_price);

        if (ed.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        ed.addTextChangedListener(textWatcher);
    }

    protected final TextWatcher textWatcher = new TextWatcher(){
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            fp.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                fp.setVisibility(View.GONE);
            } else{
                Double price = Double.valueOf(ed.getText().toString());
                Double prn = price;
                price = price + price * 0.05;
                price = price + price * 0.15;
                prn = price + prn * 0.01;
                prn = (Math.round(prn*100))/100.0;
                String st = "Price with sd+vat+sc : ";
                st += prn.toString();
                fp.setText(st);
            }
        }
    };

    /*protected void calculate(View view)
    {
        String str = ed.getText().toString();
        if(!TextUtils.isEmpty(str)) {
            Double price = Double.valueOf(str);
            Double prn = price;
            price = price + price * 0.05;
            price = price + price * 0.15;
            prn = price + prn * 0.01;
            Double pr = (Math.round(prn*100))/100.0;
            String st = "Price with sd+vat+sc : ";
            st += pr.toString();
            fp.setText(st);
        }
        else{
            String st = "";
            fp.setText(st);
        }
    }*/
}
