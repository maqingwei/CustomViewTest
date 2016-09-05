# CustomViewTest组合控件
   将系统原有的控件组合在一起，并不需要自己去绘制。
###TopBar（自绘控件）
继承了RealtiveLayout等ViewGroup，此方法所显示的View视图都是自己绘制出来的，主要的绘制代码在onDraw()方法中。其属性首先都定义在attrs中，然后在xml文件中声明，并在其构造方法中获取相应的自定义属性并赋值给对应的View（此处如果控件属性较多，代码看起来会比较多，比较臃肿）。此方法发好处就是可以将你所需要的属性定义在attrs中，在xml中使用自定义的属性。灵活性高。

###TopView（组合控件）
直接继承的是FrameLayout,此方法并不需要自己去绘制显示的View，只需要将系统原有的组件组合在一起使用，并提对外的方法来设置View的显示与否以及内容形式（文字、图片 ）。

###以下显示了三种效果：
* 以文字形式全部显示
* 隐藏左右两边任意view
* 加入图片显示


![image](https://github.com/maqingwei/CustomViewTest/raw/master/screenshots/bbb.gif)
