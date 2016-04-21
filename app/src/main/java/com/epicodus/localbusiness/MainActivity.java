package com.epicodus.localbusiness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.navList) ListView mNavList;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addDrawerItems();
    }

    private void addDrawerItems(){
        String[] navArray = { "Home", "What We Do", "Get Involved", "How to Give", "Multi-Media", "About Us", "Blog", "Personal Blog"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navArray);
        mNavList.setAdapter(mAdapter);

        mNavList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String page = ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, page, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
