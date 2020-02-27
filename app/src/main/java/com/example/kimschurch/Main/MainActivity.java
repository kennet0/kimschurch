package com.example.kimschurch.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.example.kimschurch.Register.RegisterActivity;
import com.example.kimschurch.Search.SearchActivity;
import com.example.kimschurch.R;
import com.example.kimschurch.Search.SearchRequest;
import com.example.kimschurch.Youth.YouthActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnSearch, btnYouth ,btnSenior,btnFindMember,btnInsertMember;
    EditText txtSearch;
    String searchName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        btnYouth = findViewById(R.id.btnYouth);
        btnSenior = findViewById(R.id.btnSenier);
        btnFindMember = findViewById(R.id.btnFindMember);
        btnInsertMember = findViewById(R.id.btnInsertMember);
        txtSearch = findViewById(R.id.txtSearch);

        btnYouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent = new Intent(MainActivity.this, YouthActivity.class);
              startActivity(intent);

            }
        });

        // 교인등록버튼
        btnInsertMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchName = "";
                String body = "name=" + searchName;
                String url = "http://112.186.116.16:6011/Search.php";
                new BackgroundTask(url,RegisterActivity.class, body).execute();
            }
        });

        //검색버튼

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchName = txtSearch.getText().toString();
                String body = "name=" + searchName;
                String url = "http://112.186.116.16:6011/Search.php";
                new BackgroundTask(url,SearchActivity.class, body).execute();

            }
        });

        // 교인찾기 버튼
        btnFindMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchName = "";
                String body = "name=" + searchName;
                String url = "http://112.186.116.16:6011/Search.php";
                new BackgroundTask(url,SearchActivity.class, body).execute();
            }
        });
    }


    class BackgroundTask extends AsyncTask<Void,Void,String> {
        String target;
        Class context;
        String body;

        public BackgroundTask(String target, Class context, String body) {
            this.target = target;
            this.context = context;
            this.body = body;
        }

        @Override
        public String doInBackground(Void... voids) {

            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Context-type","application/x-www-form-urlencoded");

                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(body.getBytes("UTF-8"));


                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                outputStream.flush();
                outputStream.close();

                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!=null){
                    stringBuilder.append(temp + "\n");
                }

                bufferedReader.close();
                inputStream.close();

                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }

        @Override
        public void onPostExecute(String result){
            Intent intent = new Intent(MainActivity.this, context);
            intent.putExtra("tag",1);
            intent.putExtra("result", result);
            Log.e("result", result);
            startActivity(intent);

        }
    }
}
