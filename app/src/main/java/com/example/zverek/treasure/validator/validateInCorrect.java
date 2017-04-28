package com.example.zverek.treasure.validator;
import android.graphics.Bitmap;
import android.widget.ImageView;


public interface validateInCorrect {
    public String validname(String name);
    public String validnik(String nik);
    public String validpass(String password1,String password2);
    public ImageView validphoto(ImageView photo);

}
