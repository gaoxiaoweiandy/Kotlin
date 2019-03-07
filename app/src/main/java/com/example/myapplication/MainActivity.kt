package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        var TAG = "MainActivity";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var len = getStringLength("GAOXIAOWEI");
        Log.e(TAG,"strLen="+len);
        var strArray:Array<String> = arrayOf("hgf","rnm");
       //gxw-  printWhileArray(strArray);
        printForArray(strArray);

        checkIn();
    }

    //智能转换
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length;
        }
        return null;
    }


    //while循环
    fun printWhileArray( strArray:Array<String>)
    {
        var i = 0;
        while(i <strArray.size)
        {
            Log.i(TAG,"strArray[$i]="+strArray[i]);
            i++;
        }
    }

    //for循环
    fun printForArray( strArray:Array<String>)
    {
        var i = 0;
        for(str in strArray)  //遍历元素，索引需要手动修改
        {
            Log.i(TAG,"strArray[$i]="+strArray[i]);
            i++;
        }
        var j = 0;
        for(j in strArray.indices)  //遍历索引，索引自增
        {
            Log.i(TAG,"strArray2[$j]="+strArray[j]);
        }
    }

    //in检查范围
    fun checkIn()
    {
        //遍历一个范围里的元素
        for(a in 0..5)
        {
            Log.i(TAG,"a="+a);
        }


    }
}
