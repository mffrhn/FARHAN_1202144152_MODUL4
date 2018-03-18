package com.example.muhammadfarhan.muhammadfarhan_1202144152_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListNamaMahasiswa extends AppCompatActivity {
    private ListView listNamaMahasiswa;
    private Button MulaiAsyctask;

    private String[] list_nama = {
            "Mike Portnoy","Neil Peart","Travis Barker","Joey Jordison","James Owen Sullivan","Eno Gitara Ryanto","Rayendra Sunito"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);

        listNamaMahasiswa = findViewById(R.id.listnama);
        MulaiAsyctask = findViewById(R.id.mulaiasynctask);

        listNamaMahasiswa.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>()));
        MulaiAsyctask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new mulaiAsynctask().execute();
            }
        });
    }

    class mulaiAsynctask extends AsyncTask<Void, String, String> {
        ArrayAdapter<String> adapter;
        int count;
        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>)listNamaMahasiswa.getAdapter();
            pDialog = new ProgressDialog(ListNamaMahasiswa.this);
            pDialog.setTitle("Ambil Dulu Datanya....");
            pDialog.setProgressStyle(pDialog.STYLE_HORIZONTAL);
            pDialog.setMax(10);
            pDialog.setProgress(0);
            pDialog.show();
            count = 0;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            pDialog.hide();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            pDialog.setProgress(count);
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (String listmhsw : list_nama) {
                publishProgress(listmhsw);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Ini Datanya....";
        }
    }
}
