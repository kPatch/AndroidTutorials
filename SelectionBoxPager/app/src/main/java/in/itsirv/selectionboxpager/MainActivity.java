package in.itsirv.selectionboxpager;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import in.itsirv.selectionboxpager.adapter.SelectionBoxPagerAdapater;

public class MainActivity extends Activity {
    private ViewPager pager;
    private ArrayList<View> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        addButtonListeners();
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


    private void initViewPager() {
        pager = (ViewPager) findViewById(R.id.viewPager);
        list = new ArrayList<>();

        LayoutInflater inflater = getLayoutInflater();

        list.add(inflater.inflate(R.layout.selection_option_0, null));
        list.add(inflater.inflate(R.layout.selection_option_1, null));
        list.add(inflater.inflate(R.layout.selection_option_2, null));
        View view = inflater.inflate(R.layout.selection_option_3, null);
        list.add(view);

        pager.setAdapter(new SelectionBoxPagerAdapater(list));
    }

    public void addButtonListeners() {
        ImageView rew = (ImageView) findViewById(R.id.rew);

        rew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = pager.getCurrentItem();
                Toast.makeText(getApplicationContext(), "FF " + pager.getChildCount(),
                        Toast.LENGTH_SHORT).show();
                if(currentItem != 0){
                    pager.setCurrentItem(currentItem - 1, true);
                }
            }
        });

        ImageView ff = (ImageView) findViewById(R.id.ff);
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int curreItem = pager.getCurrentItem();
                Toast.makeText(getApplicationContext(), "FF " + pager.getChildCount(),
                        Toast.LENGTH_SHORT).show();
                if(curreItem != (pager.getChildCount() - 1)) {
                    pager.setCurrentItem(curreItem+1, true);
                }
            }
        });
    }
}
