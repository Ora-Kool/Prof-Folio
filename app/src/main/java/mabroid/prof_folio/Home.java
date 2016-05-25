package mabroid.prof_folio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mabroid.prof_folio.Adapter.CustomAdapter;

public class Home extends AppCompatActivity{
    ListView batchList;
    CustomAdapter adapter;
    ArrayList<String> databatch;
    String year = "";
    private Button register;
    RelativeLayout firstlayout;
    ScrollView registerlayout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        databatch = new ArrayList<>();
        firstlayout = (RelativeLayout)findViewById(R.id.datalayout);
        registerlayout = (ScrollView)findViewById(R.id.registerlayout);
        register = (Button)findViewById(R.id.add);
        registerlayout.setVisibility(View.INVISIBLE);


        batchList = (ListView)findViewById(R.id.batchlist);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                firstlayout.setVisibility(View.INVISIBLE);
                registerlayout.setVisibility(View.VISIBLE);
                fab.setVisibility(View.INVISIBLE);
                if(getSupportActionBar() != null) {
                    getSupportActionBar().setTitle("INSERT DATA");
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "registring in progress.....", Toast.LENGTH_SHORT).show();
            }
        });

        adapter = new CustomAdapter(Home.this, databatch);
        batchList.setAdapter(adapter);
        adapter.notifyDataSetChanged();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (id){
            case android.R.id.home:
                firstlayout.setVisibility(View.VISIBLE);
                registerlayout.setVisibility(View.INVISIBLE);
                getSupportActionBar().setTitle(getString(R.string.app_name));
                fab.setVisibility(View.VISIBLE);
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setDisplayShowHomeEnabled(false);
                return true;
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
