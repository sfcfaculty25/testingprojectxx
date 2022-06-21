package com.dawai.insert;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText name,lname,email,password;
Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edname);
        lname=findViewById(R.id.edlname);
        email=findViewById(R.id.edemail);
        password=findViewById(R.id.edpass);
        insert=findViewById(R.id.btn);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest st=new StringRequest(Request.Method.POST, "https://gladdened-gallows.000webhostapp.com/insert2006b.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                   if(response.equals("inserted")){
                       Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                   }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                      Map<String,String> mp=new HashMap<>();
                      mp.put("name",name.getText().toString());
                      mp.put("lname",lname.getText().toString());
                      mp.put("email",email.getText().toString());
                      mp.put("pass",password.getText().toString());
                      return mp;

                    }

                };
                RequestQueue rq= Volley.newRequestQueue(MainActivity.this);
                rq.add(st);

            }
        });

    }

}