package com.li.jacky.reflect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Class clazz = Class.forName("com.li.jacky.reflect.test.Father");
            Method resetNumber = clazz.getDeclaredMethod("resetNumber", int.class);
            resetNumber.setAccessible(true);
            Constructor constructor = clazz.getConstructor();
            Object father = constructor.newInstance();
            resetNumber.invoke(father, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        customDatePicker();
    }

    private void customDatePicker() {
        LinearLayout linearLayout = new LinearLayout(this);
        addContentView(linearLayout, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        try {
            Class<?> clazz = Class.forName("android.widget.DayPickerView");
            Method setDate = clazz.getDeclaredMethod("setDate", long.class, boolean.class, boolean.class);
            Constructor<?> constructor = clazz.getConstructor(Context.class);
            View dayPickerView = (View) constructor.newInstance(this);
            setDate.setAccessible(true);
            setDate.invoke(dayPickerView,0, false, false);
            linearLayout.addView(dayPickerView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
