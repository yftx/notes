package com.github.yftx.iotest.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import com.github.yftx.iotest.R;

/**
 * Created by yftx on 11/11/14.
 */
public class StyleRecentActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_recent_activity);
        styleRecentTasksEntry();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void styleRecentTasksEntry() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        Resources resources = getResources();
        String label = "title";
        int colorPrimary = resources.getColor(R.color.pink);

        Bitmap sIcon = BitmapFactory.decodeResource(resources, R.drawable.recent_task_ico);

        setTaskDescription(new ActivityManager.TaskDescription(label, sIcon, colorPrimary));
    }
}