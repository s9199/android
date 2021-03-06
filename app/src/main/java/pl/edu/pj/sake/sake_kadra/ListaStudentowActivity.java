package pl.edu.pj.sake.sake_kadra;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pj.sake.pl.edu.pj.sake.db.StudentDB;


public class ListaStudentowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_studentow);

        ListView listView = (ListView) findViewById(R.id.lista_studentow_view);

        StudentDB student = new StudentDB(this);
        student.dodajStudenta("Magdalena", "Ukleja");//Dodanie przyk�adowego rekordu do bazy danych - przy ka�dym uruchomieniu

        Cursor cur = student.dajDane();

        List<String> lista = new ArrayList<String>();

        while(cur.moveToNext()) {
            lista.add(cur.getString(0) + " " + cur.getString(1));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lista);

        listView.setAdapter(adapter);

    }
}
