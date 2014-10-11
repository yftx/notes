Google I/O 2014 同步功能分析

IO App通过三种方式进行效率优化

* 下载json文件时，通过header中的过期时间判断是否要更新文件
* 使用hashcode进行数据库中某个表的数据比对。
* 使用事务进行更新提供数据库的处理操作
* 同步使用的SyncAdapter

分析文章的地址
> http://android-developers.blogspot.com/2014/09/conference-data-sync-gcm-google-io.html

GoogleI/O项目源码

> https://github.com/google/iosched