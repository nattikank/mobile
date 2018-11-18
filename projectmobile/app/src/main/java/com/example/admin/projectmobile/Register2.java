package com.example.admin.projectmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Register2 extends AppCompatActivity {
EditText use,pass,telna,Name,addressna,_idcard;
String member;
RadioGroup GG;
    private Button back,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        bind();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select = GG.getCheckedRadioButtonId();
                RadioButton ultra = findViewById(select);
                member = String.valueOf(ultra.getText().toString());
                Insert();
            }
        });

    }
    public void bind(){
        use = findViewById(R.id.regusername);
        pass = findViewById(R.id.regpassword);
        telna = findViewById(R.id.regtel);
        Name = findViewById(R.id.regname);
        addressna = findViewById(R.id.regaddress);
        _idcard = findViewById(R.id.regidcard);
        GG = findViewById(R.id.group);
        back = findViewById(R.id.btnback);
    }

    public void Insert(){
        String _url = "http://10.61.224.27/insert.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                _url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(member.equalsIgnoreCase("member")){
                    Intent i = new Intent(getApplicationContext(),Member.class);
                    startActivity(i);
                }else{
                    Intent intent = new Intent(getApplicationContext(), Prograp.class);
                    startActivity(intent);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("username",use.getText().toString());
                param.put("password",pass.getText().toString());
                param.put("Name",Name.getText().toString());
                param.put("tel",telna.getText().toString());
                param.put("address",addressna.getText().toString());
                param.put("type_member",member);
                param.put("idcard",_idcard.getText().toString());
                return param;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
