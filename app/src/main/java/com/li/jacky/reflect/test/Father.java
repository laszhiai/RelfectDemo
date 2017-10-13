package com.li.jacky.reflect.test;

import android.util.Log;

/**
 * Created by Jacky on 2017/10/13.
 */
    class Father {

    private int number = 0;

    private void resetNumber(int i) {
        number = i;
        Log.i("jacky", "resetNumber:    " +getNumber());
    }

    public int getNumber(){
        return number;
    }

}
