package fr.wildcodeschool.blablawild.base;

import java.text.ParseException;
import java.util.Date;

public interface DateView extends MvpView{
    Date stringAsDate(String date) throws ParseException;
    String dateAsString(Date date);
}
