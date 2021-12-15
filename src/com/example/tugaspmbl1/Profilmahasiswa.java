package com.example.tugaspmbl1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class Profilmahasiswa extends Activity {
	
	Button btnKembali;
	TextView nama, npm, gender, jurusan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profilmahasiswa);
		
		nama = (TextView) findViewById(R.id.tvNama);
		npm = (TextView) findViewById(R.id.tvNpm);
		gender = (TextView) findViewById(R.id.tvGender);
		jurusan = (TextView) findViewById(R.id.tvJurusan);
		
		npm.setText(getIntent().getStringExtra("npm"));
		nama.setText(getIntent().getStringExtra("nama"));
		gender.setText(getIntent().getStringExtra("gender"));
		jurusan.setText(getIntent().getStringExtra("jurusan"));
		
		btnKembali = (Button) findViewById(R.id.back);
		btnKembali.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle kirim = new Bundle();
				// kirim pesan balasan untuk data yg telah diterima
				kirim.putString("balas", "Data Sudah Diterima!");
				
				Intent kembali = new Intent(Profilmahasiswa.this, MainActivity.class);
				kembali.putExtras(kirim);
				startActivity(kembali);
				
			}
		});
		
		
	}

}
