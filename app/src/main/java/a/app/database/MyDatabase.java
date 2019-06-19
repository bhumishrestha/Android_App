package a.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyDatabase extends SQLiteOpenHelper {

    private final String DB_NAME="mydatabase.db";

    public MyDatabase(@Nullable Context context) //constructor
    {

        super(context,"mydatabase.db" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql="create table student(email TEXT, password TEXT, branch TEXT)"; //key
db.execSQL(sql);

    }

public void insertData(String email, String pass, String branch)  //agrs passed
{
    ContentValues cv= new ContentValues();
    cv.put("email", email); //key, agr
    cv.put("password",pass);
    cv.put("branch",branch);
    SQLiteDatabase db= getWritableDatabase();
    long i=db.insert("student",null,cv);
    Log.d("APPP","insert Method"+i);
  }

public void getdata() {
    SQLiteDatabase db = getReadableDatabase();
    try {
        Cursor cr = db.rawQuery("select * from student", null);
        Log.d("APPP", "cols" + cr.getColumnCount());
    } catch (Exception E) {

    }
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
onCreate(db);
    }
}
