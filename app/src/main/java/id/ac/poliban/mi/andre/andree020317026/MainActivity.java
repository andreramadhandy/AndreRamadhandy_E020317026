package id.ac.poliban.mi.andre.andree020317026;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationContext();

        Switch mySwitch = findViewById(R.id.switch1);
        EditText etNama = findViewById(R.id.etNama);
        EditText etNim = findViewById(R.id.etNim);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        RadioButton rbLaki = findViewById(R.id.rbLaki);
        RadioButton rbPerem = findViewById(R.id.rbPerem);


        mySwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(mySwitch.isChecked()){
                etNama.setEnabled(true);
                etNim.setEnabled(true);
                etAlamat.setEnabled(true);
                rgGender.setEnabled(true);
                etTelp.setEnabled(true);
                btClear.setEnabled(true);
                rbPerem.setEnabled(true);
                rbLaki.setEnabled(true);
                btSubmit.setEnabled(true);
            } else {
                etNama.setEnabled(false);
                etNim.setEnabled(false);
                etAlamat.setEnabled(false);
                etTelp.setEnabled(false);
                rbLaki.setEnabled(false);
                rbPerem.setEnabled(false);
                rgGender.setEnabled(false);
                btClear.setEnabled(false);
                btSubmit.setEnabled(false);
            }
        });




    btSubmit.setOnClickListener(v -> {
        String jenisKelamin = "";
        if (rbLaki.isChecked()){
             jenisKelamin+= "Laki-laki";
        }
        if(rbPerem.isChecked()){
            jenisKelamin += "Perempuan";
        }
        new AlertDialog.Builder(this)
                .setTitle("Info")
                .setMessage("NIM: "+etNim.getText().toString() + "\n" +
                        "Nama: "+etNama.getText().toString() + "\n" +
                        "Jenis Kelamin: "+jenisKelamin.toString()+"\n"+
                        "Alamat: "+etAlamat.getText().toString() + "\n" +
                        "Telp: "+etTelp.getText().toString() + "\n"
                )
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", null).show();
    });
//        btSubmit.setOnClickListener(v ->
//            new AlertDialog.Builder(this)
//                    .setTitle("Info")
//                    .setMessage(etNim.getText().toString())
//                    .setPositiveButton("OK", null).show());

        btClear.setOnClickListener(v -> {
            etNim.setText("");
            etNama.setText("");
            etAlamat.setText("");
            etTelp.setText("");
            rgGender.clearCheck();
            etNim.requestFocus();
        });
    }
}
