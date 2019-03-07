package com.example.myapplication
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
       // when多条件选择的用法，类似于switch
        cases("Hello")
        cases(1)
        cases(0L)
        cases(MainActivity())
        cases("hello")
    }

    //when多条件选择的用法，类似于switch
    private fun cases(obj: Any) {
        when (obj) {
             1 -> Log.i(TAG, "1")
            "Hello" -> Log.i(TAG, "Hello")
            !is String ->Log.i(TAG, "obj is not String");
            "hello" -> Log.i(TAG, "hello")
            is Long ->Log.i(TAG, "Long")
         else
             -> Log.i(TAG, "unknown");
      }
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
        //判断是否在范围内
        var y = 4;
        if(y in 0..5)
        {
            Log.i(TAG,"1 in 0..5");
        }
        else
        {
            Log.i(TAG,"y is not in 0..5");
        }
        //判断一个数组是否包含该字符串
        var aStr = "dd";
        var strArray = arrayListOf<String>();
        strArray.add("aaa");
        strArray.add("bbb");
        strArray.add("ccc");

        if(aStr in strArray)
        {
            Log.i(TAG,"aStr in strArray");
        }
        else
        {
            Log.i(TAG,"aStr is not in strArray");
        }

        var index = 3;

        if(index in 0..strArray.size - 1)
        {
            Log.i(TAG,"index is avilable");
        }
        else
        {
            Log.i(TAG,"index is out");
        }
    }
}
