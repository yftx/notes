Android 64K method大小限制
=========

>http://www.hellsoft.se/android/androids-64k-method-limit/

####起因
Android限制dex文件中的method数量为64K.  
Android系统中运行的文件格式为dex类型。  
dex类型同class类型是有区别的。dex文件中的所有class中的method都会产生一个索引。  
索引为short类型，一个short类型包含16bits(十进制为65536)，所以就有了64K 的method 数量的限制。  
使用很多的第三方的库会导致有很多方法，就有可能产生此问题。    
比如Google Play Service(V5)的method数量大概为20k  

####解决方案
* proguard 移除掉不使用的method
* 多dex文件处理。不把所有的method打包到同一个dex文件。  

####Tips
* ART不能解决该问题，由于是在编译时期生成dex文件。所以无论运行环境是Davlink还是ART都不能解决该问题。
* 加载多个dex文件  
> http://android-developers.blogspot.it/2011/07/custom-class-loading-in-dalvik.html
* 多dex的加载器
> https://github.com/behumble/dexdex
* gradle支持多dex构建的plugin
> https://github.com/casidiablo/multidex
> https://github.com/creativepsyco/secondary-dex-gradle

* facebook fork proguard 比原来的proguard混淆的要快
> https://github.com/facebook/proguard

* ART详细讲解,ART是什么？为什么ART会使app运行变快
> http://androidbackstage.blogspot.de/2014/08/android-developers-backstage-episode-11.html?m=1


