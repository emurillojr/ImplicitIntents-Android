package neit.ImplicitIntents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {

    private Button contactsBTN;
    private Button geoBTN; // save button
    private Button imgBTN; // save button



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactsBTN = (Button)findViewById(R.id.contactsBTN); // save button
        geoBTN = (Button)findViewById(R.id.geoBTN); // save button
        imgBTN = (Button)findViewById(R.id.imgBTN); // save button

        contactsBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse("content://contacts/people/"));
                startActivity(i);
            }
        });

        geoBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway%2C+CA"));
                startActivity(i);

            }
        });


        imgBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
