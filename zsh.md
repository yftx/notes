zsh config
==========
####oh-my-zsh
使用已经配置好的_oh-my-zsh_  
github下载地址  
>https://github.com/robbyrussell/oh-my-zsh  

####安装
curl -L http://install.ohmyz.sh | sh

####配置
zsh的配置文件为**~/.zshrc**  
>环境变量配置  
ANDROID_HOME=~/software/android-sdk-macosx
APKTOOL_HOME=~/software/decompile/apktool
DEX2JAR_HOME=~/software/decompile/dex2jar
GRADLE_HOME=/Users/yftx/software/gradle-2.1
export ANDROID_HOME
export APKTOOL_HOME
export DEX2JAR_HOME
export GRADLE_HOME
export PATH=$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$APKTOOL_HOME/:$DEX2JAR_HOME/:$GRADLE_HOME/bin:$PATH

####颜色配置
theme样式  
>https://github.com/robbyrussell/oh-my-zsh/wiki/themes

####设置语言编码
>export LANG=en_US.UTF-8