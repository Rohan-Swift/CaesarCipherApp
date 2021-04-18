package com.example.encrypt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Switch swt;

    EditText input;
    TextView output;
    EditText num;

    String inp="";
    int choice;
    char[] c  = new char[100];

    Button enc, dec;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        output= (TextView) findViewById(R.id.output);
        num = (EditText) findViewById(R.id.num);

        enc = (Button) findViewById(R.id.enc);
        dec = (Button) findViewById(R.id.dec);
        swt=findViewById(R.id.swt);

        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else
                {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }
        });




        enc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                inp=input.getText().toString();
                c=inp.toCharArray();
                choice= Integer.parseInt(num.getText().toString());
                Log.d("CHECK", "onClick: "+choice+"INPUT len: "+input.length());
                for(int i=0;i<input.length();i++)
                {
                    c[i]= (char) (c[i]+choice);
                }
                output.setText(new String(c));
            }
        });

        dec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v1)
            {

                inp=input.getText().toString();
                c=inp.toCharArray();
                choice= Integer.parseInt(num.getText().toString());
                for(int i=0;i<input.length();i++)
                {
                    c[i]= (char) (c[i]-choice);
                }
                output.setText(new String(c));
            }
        });
    }
}
