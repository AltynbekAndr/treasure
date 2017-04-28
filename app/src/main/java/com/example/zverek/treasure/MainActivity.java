package com.example.zverek.treasure;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.zverek.treasure.validator.Validator;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageButton img ;
    final int Pick_image = 1;
    Bitmap bitmap;
    ImageView imgview;
    EditText name,nik,pass1,pass2;
    String ename=null,enik=null,epass1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageButton) findViewById(R.id.myimgbtn);
        imgview = (ImageView) findViewById(R.id.imageVieww);
        name = (EditText)findViewById(R.id.editText);
        nik = (EditText)findViewById(R.id.editText2);
        pass1 = (EditText)findViewById(R.id.editText3);
        pass2 = (EditText)findViewById(R.id.editText4);

        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(getApplicationContext(),Vhod.class);
                startActivity(in);
            }
        });


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent pickPhoto = new Intent(Intent.ACTION_PICK);
                pickPhoto.setType("image/*");
                startActivityForResult(pickPhoto, Pick_image);
                img.setVisibility(img.GONE);
                imgview.setVisibility(ImageView.VISIBLE);
            }
        });
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK);
                pickPhoto.setType("image/*");
                startActivityForResult(pickPhoto, Pick_image);
            }
        });
        Button btn_reg = (Button)findViewById(R.id.button2);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Validator validator = new Validator();
                ename = validator.validname(name.getText().toString());
                if(ename.equals(name.getText().toString())){
                    enik = validator.validnik(nik.getText().toString());
                    if(enik.equals(nik.getText().toString())){
                        epass1 = validator.validpass(pass1.getText().toString(),pass2.getText().toString());
                        if(epass1.equals(pass2.getText().toString())){

                            imgview = validator.validphoto(imgview);
                            if(imgview!=null){

                                Intent intent = new Intent(getApplicationContext(),TwoMainActivity.class);
                        intent.putExtra("name",ename);
                        intent.putExtra("nik",enik);
                        intent.putExtra("pass",epass1);

                                startActivity(intent);


                             }else{
                                Toast.makeText(getApplicationContext(),"Загрузите фото",Toast.LENGTH_SHORT).show();
                             }
                        }
                      else{
                            Toast.makeText(getApplicationContext(),epass1,Toast.LENGTH_SHORT).show();
                        }

                    }else{Toast.makeText(getApplicationContext(),enik,Toast.LENGTH_SHORT).show();
                }
                }else{
                    Toast.makeText(getApplicationContext(),ename,Toast.LENGTH_SHORT).show();}
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK){
                    Uri uri = data.getData();
                    try {
                        InputStream input = getContentResolver().openInputStream(uri);
                        bitmap = BitmapFactory.decodeStream(input);

                        imgview.setImageBitmap(bitmap);



                        } catch (FileNotFoundException e) {

                        e.printStackTrace();
                    }  }


        }

    }


}
