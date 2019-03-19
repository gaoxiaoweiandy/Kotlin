package com.example.myapplication
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class MainActivity : AppCompatActivity() {
    companion object {
        var TAG = "MainActivity";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*        var len = getStringLength("GAOXIAOWEI");
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

        *//*gxw+s解构*//*
        val pair = Pair("gxw","gaoxiaowei");
        var (key,value) = pair; //解构
        Log.i(TAG,"the key of Pair is$key,value is $value");

        //数据类
        var user = User("gaoxiaowei",30);
        val toString  = user.toString();
        var(name,age) = user;
        Log.i(TAG,"the name of user is$name,age is $age, toString=$toString");
        dataClass();

        //遍历MAP
        travelMap();
        *//*gxw+e解构*//*

        *//*gxw+s for 委托*//*
        var example = Example("rinima");
        Log.i(TAG,"example.property="+ example.myProperty);
        example.myProperty = "hgf";

        //懒加载:只计算1次（只输出compute1次），第二次直接加载上次缓存的结果
        var lazyLoad = lazyLoad();
        Log.i(TAG,"lazy=${lazyLoad.lazy}");
        Log.i(TAG,"lazy=${lazyLoad.lazy}");


        //观察者，观察属性的变化
        val user2 = User2();
        user2.name = "Carl";
        user2.name = "Car2";*/


        //委托来处理属性在未初始化的情形：自动抛出异常
/*        val user3 = User3();
        user3.init("gaoxiaowei");
        val userName = user3.name;
        Log.i(TAG,"$userName");*/

        //使用MAP给属性赋值
       /* val userMap = UserMap(mapOf("name" to "gaoxiaowei","age" to 35));
        val uN = userMap.name;
        val age = userMap.age;
        Log.i(TAG,"the name of user is $uN,age is $age");*/
        /*gxw+e for 委托*/

        /*gxw+s Callable References*/
/*        val list = listOf(1,2,3);
       var listInt = list.filter(::isOdd);

        Log.i(TAG,""+listInt);*/

/*
        var oddLength = compose(::isOdd,::length);
        var strings = listOf("a","ab","abc");
        Log.i(TAG,""+(strings.filter(oddLength)));
        */
/*gxw+e*//*


        //TEST
        var intArray = intArrayOf(1,4,3);
        var sum = sum(intArray);
        Log.i(TAG,"sum=$sum");
*/
        var intArray = intArrayOf(1,4,3);
        val max = indexOfMax(intArray);
        Log.i(TAG,"max=$max");
    }


    /*
 * Your task is to implement the indexOfMax() function so that it returns
 * the index of the largest element in the array, or null if the array is empty.
 */


    fun indexOfMax(a: IntArray): Int? {
        if(a == null)
        {
            return null;
        }
        return a.max();
    }


    /**\
     * 求和题目1
     */
    fun sum(a: IntArray): Int {
        // Write your solution here
        var sum = 0;
        for( value in a)
        {
            sum+=value;
        }
        return sum
    }


    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x -> f(g(x)) }
    }




    fun length(s:String) = s.length;
    fun  isOdd(x:Int) = (x%2) !=0;


    class UserMap(var map:Map<String,Any?>)
    {
        val name:String by map;
        val age:Int by map;
    }
    /**
     * 委托来处理属性在未初始化的情形：自动抛出异常
     */
    class User3
    {
        var name:String by Delegates.notNull();
        fun init ( name:String){
           this. name = name;
        }
    }

    /**
     * observable有2个参数，第一个是初始值，第二个是属性变化时的handler
     * 观察者模式：当属性值变化时，响应handler，handler有3个参数：改变的属性，old值，new值
     */
    class User2 {
        var name: String by Delegates.observable("no name") {
                d, old, new ->
            Log.i(TAG,"$old - $new")
        }
    }


    /**
     * 懒加载，当第一次计算后输出computed!,  mylzy,第二次再读取的时候，直接读取上次返回的结果（已经缓存），
     * 无需再计算，即无需再输出computed!
     */
    class lazyLoad
    {
        val lazy: String by lazy {
            Log.i(TAG,"computed!")
            "my lazy"
        }
    }

    //委托
     class Example(var property1: String)
    {
        var myProperty:String by MyDelegate();
    }

    class MyDelegate
    {
        operator fun getValue(example: MainActivity.Example, property: KProperty<*>): String {
            return "hello $example,thank you delegate your property ${property.name} to me";

        }
        operator fun setValue(example: Any?, property: KProperty<*>, value: String) {
            Log.i(TAG,"$value has been assigned to ${property.name} in $example ")
        }
    }

    /**
     * 使用data class类默认生成的方法
     */
    fun dataClass()
    {
        var user = User("gaoxiaowei",30);
        var secondUser = User("liushuai",31);
        var thirdUser = User("maguorong",32);
        Log.i(TAG,"user:"+user+", secondUser="+secondUser+",thirdUser="+thirdUser);
        Log.i(TAG,"usercopy="+user.copy(age=31));
        Log.i(TAG,"usercopy2="+user.copy(name="liushuai"));
        Log.i(TAG,"usercopy3="+user.copy("gxw",33));
    }


    //遍历hashmap
    fun travelMap()
    {
        var myMap = hashMapOf<String,String>();
        myMap.put("gxw","gaoxiaowei");
        myMap.put("ls","liushuai");
        myMap.put("mgr","maguorong");

        for((key,value) in myMap)
        {
            Log.i(TAG,"key="+key+",value="+value);
        }
    }

    //数据类，所有属性在主构造方法中声明，内部会自动生产toString,equal,hashcode,copy等方法。
    data class User(var name:String,var age:Int);
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

    //解构:把一个类的各属性的值抽取出来赋给你声明的变量
    class Pair<K,V>(val key:K,val value:V)
    {
        operator fun  component1():K
        {
            return key;
        }

        operator fun  component2():V
        {
            return value;
        }
    }
}


