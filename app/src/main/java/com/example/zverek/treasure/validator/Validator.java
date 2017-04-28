package com.example.zverek.treasure.validator;

import android.graphics.Bitmap;
import android.widget.ImageView;


public class Validator implements validateInCorrect {
    char [] ch = new char[31];
    char [] ch2 = new char[31];

   public Validator(){
       ch[0] = 'а';
       ch[1] = 'б';
       ch[2] = 'в';
       ch[3] = 'г';
       ch[4] = 'д';
       ch[5] = 'е';
       ch[6] = 'ё';
       ch[7] = 'ж';
       ch[8] = 'з';
       ch[9] = 'и';
       ch[10] = 'к';
       ch[11] = 'л';
       ch[12] = 'м';
       ch[13] = 'н';
       ch[14] = 'п';
       ch[15] = 'р';
       ch[16] = 'с';
       ch[17] = 'т';
       ch[18] = 'у';
       ch[19] = 'Ф';
       ch[20] = 'й';
       ch[21] = 'х';
       ch[22] = 'ч';
       ch[23] = 'ш';
       ch[24] = 'щ';
       ch[25] = 'ь';
       ch[26] = 'ъ';
       ch[27] = 'э';
       ch[28] = 'ю';
       ch[29] = 'я';
       ch[30] = 'о';

       ch2[0] = 'А';
       ch2[1] = 'Б';
       ch2[2] = 'В';
       ch2[3] = 'Г';
       ch2[4] = 'Д';
       ch2[5] = 'Е';
       ch2[6] = 'Ё';
       ch2[7] = 'Ж';
       ch2[8] = 'З';
       ch2[9] = 'И';
       ch2[10] = 'К';
       ch2[11] = 'Л';
       ch2[12] = 'М';
       ch2[13] = 'Н';
       ch2[14] = 'П';
       ch2[15] = 'Р';
       ch2[16] = 'С';
       ch2[17] = 'Т';
       ch2[18] = 'У';
       ch2[19] = 'ф';
       ch2[20] = 'Й';
       ch2[21] = 'Х';
       ch2[22] = 'Ч';
       ch2[23] = 'Ш';
       ch2[24] = 'Щ';
       ch2[25] = 'Ь';
       ch2[26] = 'Ъ';
       ch2[27] = 'Э';
       ch2[28] = 'Ю';
       ch2[29] = 'Я';
       ch2[30] = 'О';

	   }

    @Override
    public String validname(String name) {
       if(name.length()>2&&name!=null){
           return name;
       }

        return "введен не правильное имя или оно слишком короткое";
    }

    @Override
    public String validnik(String nik) {
        if(nik.length()>2&&nik!=null){
           for(int i = 0; i<nik.length();i++){
                 for (int j = 0;j<ch.length;j++){
                     String ccc = String.valueOf(nik.charAt(i));
                     String sss = String.valueOf(ch[j]);
                     String kkk = String.valueOf(ch2[j]);
                     if(ccc.equals(sss)||ccc.equals(kkk)){
                         return "используйте латинские буквы для НИКа";
                     }
                 }
            }return nik;

        }

        return "введен не правильный ник или оно слишком короткое";


    }

    @Override
    public String validpass(String password1,String password2) {
        if(password1.length()>1&&password1!=null&&password2!=null){
            if((password1.equals(password2))){
                return password1;
            }
            else {
                return "введеные пароли не корректны";

            }}




        return "введеные пароли не корректны";

    }

    @Override
    public ImageView validphoto(ImageView photo) {
        if((photo!=null)&&(photo.getWidth()!=0)&&(photo.getHeight()!=0)){
            return photo;
        }
        return null;
    }
}
