Fragment传参以及recreate时参数的保存以及重置
========

>https://bitbucket.org/hvisser/bundles

使用注解的方式给fragment传参数  
在Fragment被销毁以及重新构建的时候，被用来保存自定义的值。
  
**使用注解的目的为减少代码量，通过注解在编译时期自动生成相关的代码。less code .more strong **



一般fragment传参的构建方式为

```
public class MyFragment extends Fragment {
  private int id;  
  private String title;  
  public static MyFragment newInstance(int id, String title) {  
    MyFragment f = new MyFragment();  
    f.id = id;  
    f.title = title;  
    return f;  
  }  
}

```

使用注解之后传参为

```
public class TestFragment extends Fragment {
    @Argument
    boolean mCheese;
    @Argument(required=false)
    int mTotal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        // Use the generated builder class to "inject" the arguments on creation
        // you can use a static import to shorten this line to injectArguments(this)
        TestFragmentBuilder.injectArguments(this);
    }
}
```

```
TestFragment fragment = new Test2FragmentBuilder(false).build();
TestFragment fragment2 = new Test2FragmentBuilder(false).total(10).build();
```


```
package test;

import static test.MyActivityState.restoreInstanceState;
import static test.MyActivityState.saveInstanceState;
import android.app.Activity;
import android.os.Bundle;

import com.neenbedankt.bundles.annotation.Frozen;

public class MyActivity extends Activity {
    @Frozen
    String mName;
    @Frozen
    boolean mCheeseActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(this, outState);
    }
}
```
