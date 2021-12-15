package com.example.tugaspmbl1;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends Activity {
	
	String[] jurusan = {
			"-- pilih jurusan --",
			"Manajemen Informatika",
			"Teknik Informatika",
			"Teknologi Informasi",
			"Manajemen Retail",
			"Sistem Informasi"
	};
	
	EditText name, npm;
	RadioGroup gender;
	RadioButton lk, pr;
	Spinner sp;
	Button btnKirim;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (getIntent().getExtras()!=null) {
			Bundle terima = getIntent().getExtras();
			Toast.makeText(getBaseContext(), terima.getString("balas"), Toast.LENGTH_SHORT).show();
		}
		
		// isi data spinner
		sp = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jurusan);
		sp.setAdapter(adp);
		
		name = (EditText) findViewById(R.id.editText1);
		npm = (EditText) findViewById(R.id.editText2);
		gender = (RadioGroup) findViewById(R.id.radioGroup1);
		lk = (RadioButton) findViewById(R.id.radio1);
		pr = (RadioButton) findViewById(R.id.radio2);
		
		btnKirim = (Button) findViewById(R.id.button1);
		btnKirim.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, Profilmahasiswa.class);
				
				// kirim data nama
				i.putExtra("nama", name.getText().toString());
				
				// kirim data npm
				i.putExtra("npm", npm.getText().toString());
				
				// kirim data gender
				if (lk.isChecked()) {
					i.putExtra("gender", "Laki-Laki");
				} else if (pr.isChecked()) {
					i.putExtra("gender", "Perempuan");
				} else {
					i.putExtra("gender", "Tidak dipilih1");
				}
				
				// kirim data jurusan
				i.putExtra("jurusan", jurusan[sp.getSelectedItemPosition()]);
				startActivity(i);
				
			}
		});
	}

}
