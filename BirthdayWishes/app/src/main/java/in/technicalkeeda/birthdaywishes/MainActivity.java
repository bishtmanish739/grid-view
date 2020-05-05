package in.technicalkeeda.birthdaywishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView simpleGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final int logos[] = {R.drawable.ic_cake_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp
       ,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp
       ,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp,R.drawable.ic_home_black_24dp};
        Resources res = getResources();
        String[] myStrings = res.getStringArray(R.array.birthdaywishes);
        simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set an Intent to Another Activity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("image", logos[position]); // put image data in Intent
                startActivity(intent); // start Intent
            }
        });


    }
}
