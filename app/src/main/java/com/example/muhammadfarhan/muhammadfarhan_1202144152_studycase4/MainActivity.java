package com.example.muhammadfarhan.muhammadfarhan_1202144152_studycase4;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup hehe;
    RadioButton listNamaMahasiswa, pencariGambar;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hehe = findViewById(R.id.radioGroup);
        listNamaMahasiswa = findViewById(R.id.list_nama_mahasiswa);
        pencariGambar = findViewById(R.id.pencari_gambar);
        next = findViewById(R.id.next);
    }

    public void next(View view) {
        int terserah = hehe.getCheckedRadioButtonId();
        if(terserah == listNamaMahasiswa.getId()){
            Intent pindah = new Intent(MainActivity.this, ListNamaMahasiswa.class);
            startActivity(pindah);
            Toast.makeText(MainActivity.this, "List Nama Mahasiswa", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(MainActivity.this, PencariGambar.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Pencari Gambar", Toast.LENGTH_LONG).show();
        }
    }
}

