package com.example.muhammadfarhan.muhammadfarhan_1202144152_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

public class PencariGambar extends AppCompatActivity {
    private EditText linkURL;
    private Button cari_gambar;
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);

        linkURL = findViewById(R.id.urlgambar);
        cari_gambar = findViewById(R.id.carigambar);
        gambar = findViewById(R.id.gambar);

        cari_gambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new cari_Gambar().execute();
            }
        });
    }

    class cari_Gambar extends AsyncTask<Void, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(Void... voids) {
            String URL = linkURL.getText().toString();
            Bitmap bmp = null;
            try {
                bmp = BitmapFactory.decodeStream((InputStream)new URL(URL).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bmp;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            gambar.setImageBitmap(bitmap);
        }
    }
}

