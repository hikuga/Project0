package com.example.hitesh.project0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.view.MotionEvent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.app_heading));
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.addView(textView);
        for(String appn: getResources().getStringArray(R.array.apps) )
        {
                Button btn = new Button(this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                lp.setMargins(0, 25, 0, 0);//probably there is a better way to do this.
                btn.setLayoutParams(lp);
                btn.setText(appn);
                btn.setTag(appn);
                btn.setId(appn.hashCode());
                btn.setBackgroundResource(android.R.color.holo_orange_light);
                btn.setWidth(900);// better way to do this?
                btn.setGravity(Gravity.CENTER_HORIZONTAL);
                btn.invalidate();
                btn.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                v.setBackgroundResource(android.R.color.holo_orange_dark);
                                Toast.makeText(getApplicationContext(), "This button will launch my " + ((Button) v).getTag() + " app!", Toast.LENGTH_SHORT).show();
                                return true;
                            case MotionEvent.ACTION_UP:
                                v.setBackgroundResource(android.R.color.holo_orange_light);
                                return true;
                        }
                        return false;
                    }
                });
                layout.addView(btn);
        }
        setContentView(layout);
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
