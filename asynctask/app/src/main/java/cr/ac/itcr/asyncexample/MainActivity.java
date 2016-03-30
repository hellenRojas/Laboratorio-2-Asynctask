package cr.ac.itcr.asyncexample;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//Hellen Rojas 
//Henry Solís
public class MainActivity extends Activity {

    private ArrayList<String> arrayList;
    private Button button;
    private  ListView lvl;
    private Boolean state = true;
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_do_it);

        arrayList = new ArrayList<String>();
        lvl = (ListView)findViewById(R.id.lvpaises);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lvl.setAdapter(adapter);
        Toast t = Toast.makeText(this,"Para ver los elementos que se van agregando haga scroll",Toast.LENGTH_LONG);
        Toast c = Toast.makeText(this,"La aplicacion inicia por defecto, si quiere detenerla o iniciarla de nuevo toque el boton",Toast.LENGTH_LONG);
        t.show();
        c.show();
        AsyncTaskRunner runner = new AsyncTaskRunner();
        runner.execute();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == true){
                    state = false;
                }
                else {
                    state = true;
                    AsyncTaskRunner runner = new AsyncTaskRunner();
                    runner.execute();
                }
            }
        });
    }



    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            int i = 0;
            int time = 5000;
            while (true) {
                if (state== false){
                    break;
                }
                try {

                    arrayList.add("Conjunto..."+i);
                    arrayList.add("Conjunto..."+i);
                    arrayList.add("Conjunto..."+i);
                    arrayList.add("Conjunto..."+i);
                    arrayList.add("Conjunto..."+i);
                    adapter.notifyDataSetChanged();
                    Thread.sleep(time);


                } catch (InterruptedException e) {
                    e.printStackTrace();

                } catch (Exception e) {
                    e.printStackTrace();

                }
                i++;
            }
            return "";
        }


    }
}