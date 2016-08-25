# CustomViewTest
自定义组合控件TopView，自定义View之计数的TextView
这是一个顶部栏的自定义组合控件，跟Github上其他自定义的TopBar的区别是：
   
TopBar继承了RealtiveLayout等ViewGroup，其属性首先都定义在attrs中，然后在xml文件中声明，并在其构造方法中获取相应的自定义属性并赋值给对应的View（此处如果控件属性较多，代码看起来会比较多，比较臃肿）。此方法发好处就是可以将你所需要的属性定义在attrs中，在xml中使用自定义的属性。灵活性高。

TopView直接继承的是FrameLayout,将顶部栏布局通过inflater加载进来，并提对外的方法来设置View的显示与否以及内容形式（文字、图片 ），次方法也同样便于理解，代码相对较少。也可动态更改

以下显示了三种效果：
1.以文字形式全部显示
2.隐藏左右两边任意view
3.加入图片显示


![image](https://github.com/maqingwei/CustomViewTest/raw/master/screenshots/aaa.gif)
