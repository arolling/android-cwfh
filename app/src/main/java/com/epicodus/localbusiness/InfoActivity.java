package com.epicodus.localbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {
    public static final String TAG = InfoActivity.class.getSimpleName();

    @Bind(R.id.tvPageTitle) TextView mPageTitle;
    @Bind(R.id.tvDescription) TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String page = intent.getStringExtra("page");
        Log.d(TAG, page);
        mDescription.setMovementMethod(LinkMovementMethod.getInstance());
        mPageTitle.setText(page);
        int content;
        switch(page){
            case "Home":
                content = R.string.home_page;
                break;
            case "What We Do":
                content = R.string.what_we_do;
                break;
            case "Get Involved":
                content = R.string.get_involved;
                break;
            case "How to Give":
                content = R.string.how_to_give;
                break;
            case "Multi-Media":
                content = R.string.multi_media;
                break;
            case "About Us":
                content = R.string.about_us;
                break;
            case "Blog":
                content = R.string.blog;
                break;
            default:
                content = R.string.home_page;
        }
        mDescription.setText(content);
    }
}
