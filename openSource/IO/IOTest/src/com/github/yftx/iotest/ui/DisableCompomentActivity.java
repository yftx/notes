package com.github.yftx.iotest.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import com.github.yftx.iotest.R;

/**
 * Created by yftx on 11/11/14.
 *
 * http://www.grokkingandroid.com/enabling-and-disabling-broadcastreceivers/
 * 使用PackageManager.setComponentEnabledSetting设置自身系统组件是否可用。
 */
public class DisableCompomentActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disable_compoment_activity);
        findViewById(R.id.disable).setOnClickListener(this);
        findViewById(R.id.enable).setOnClickListener(this);
        findViewById(R.id.open).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.disable:
                disable();
                break;
            case R.id.enable:
                enable();
                break;
            case R.id.open:
                open();
                break;
        }
    }

    private void open() {
        startActivity(new Intent(this, TestCompomentActivity.class));
    }

    private void enable() {
        handleCompoment(true);
    }

    private void disable() {
        handleCompoment(false);
    }

    private void handleCompoment(boolean flag) {
        final PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(getPackageName(),
                    PackageManager.GET_ACTIVITIES | PackageManager.GET_META_DATA);
            if (pi == null) {
                return;
            }

            final ActivityInfo[] activityInfos = pi.activities;
            for (ActivityInfo info : activityInfos) {
                if (info.name.contains(TestCompomentActivity.class.getSimpleName()))
                    //关闭或者弃用系统控件
                    pm.setComponentEnabledSetting(
                            new ComponentName(this,
                                    Class.forName(info.name)),
                            flag
                                    ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED
                                    : PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                            //不重启app，
                            PackageManager.DONT_KILL_APP);
            }
        } catch (Exception ignore) {

        } finally {

        }

    }
}