package com.li.jacky.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
