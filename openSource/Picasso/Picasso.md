Picasso 
==========
####Picasso
一个Picasso对象中包括
一个HANDLER关联到MainThread用来做消息收发  
构建Picasso对象的时候，会在构造函数中自动创建CleanupThread线程  CleanupThread线程同外部通信使用MainThread的Looper
每个Picasso对象对应一个Stats对象


####Picasso.Builder(Builder模式)
用来构造用来构造Picasso对象

####Request

#####RequestCreator
包含Piscasso对象以及Request.Builder对象  


####PicassoExecutorService
自定义线程池,该线程池中的线程用来下载图片  
其中会有逻辑判断当网络为3G，4G，wifi的情况下更改线程池的中线程的数量  

####PicassoFutureTask
封装BitmapHunter，提供针对不同优先级，改变线程执行优先级功能。


####Downloader
执行下载任务的接口

####Stats
标记状态位  
内部包含自己的HandlerThread  
创建的时候开启自己单独的线程，并通过StatsHander做消息首发

####Dispatcher
分发器  
内部包含自己的HandlerThread(DispatcherThread)  
创建的时候开启自己单独的线程，并通过DispatcherHandler做消息首发


'''

    Picasso.with(context) //
        .load(url) //
        .placeholder(R.drawable.placeholder) //
        .error(R.drawable.error) //
        .fit() //
        .tag(context) //
        .into(view);

'''

Picasso.with(context).load(uri)  
获取Picasso对象并且指定uri生成RequestCreator.  
通过对RequestCreator设置tag来指定某些tag暂停，取消。  
Request.Creator.into方法用来启用显示图片的相关操作。  

####BitmapHunter



