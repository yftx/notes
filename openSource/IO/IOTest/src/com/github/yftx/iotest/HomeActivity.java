package com.github.yftx.iotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.github.yftx.iotest.ui.DisableCompomentActivity;
import com.github.yftx.iotest.ui.StyleRecentActivity;

public class HomeActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.recent_ui).setOnClickListener(this);
        findViewById(R.id.disable_application).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.recent_ui:
                recent();
                break;
            case R.id.disable_application:
                disable();
                break;
        }
    }

    private void disable() {
        startActivity(new Intent(this, DisableCompomentActivity.class));
    }

    private void recent() {
        startActivity(new Intent(this, StyleRecentActivity.class));
    }
}
