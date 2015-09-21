package com.mac.cdp.androidbaidusign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

//import android.support.v7.app.ActionBarActivity;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
       String text= intent.getStringExtra("key");
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setWidth(40);
        setContentView(textView);
//        if(savedInstanceState!=null){
//            getSupportFragmentManager().beginTransaction().add(R.id.container,new PlaceholderFragment())
//                    .commit();
//        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_display_message, menu);
//        return true;
//    }

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

//    public static class PlaceholderFragment extends Fragment {
//
//        public PlaceholderFragment() { }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_display_message, container, false);
//            return rootView;
//        }
//    }

}
