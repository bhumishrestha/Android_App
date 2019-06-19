package a.app.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText email,pass,branch;

MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        branch =findViewById(R.id.branch);

        db=new MyDatabase(this);
        db.getdata();
    }

    public void registerUser(View view)
    {
        String s=email.getText().toString();
        String s1=pass.getText().toString();
        String s2=branch.getText().toString();

        db.insertData(s,s1,s2);
    }
}
