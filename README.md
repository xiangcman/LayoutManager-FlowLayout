[![](https://jitpack.io/v/1002326270xc/LayoutManager-FlowLayout.svg)](https://jitpack.io/#1002326270xc/LayoutManager-FlowLayout/v1.3)

说真的自从对**RecyclerView**的**LayoutManager**有新的认识后，完全不用担心很多的复杂布局了。而且对**ViewGroup**测量过程也不用担心了，因为里面有**LayoutManager**帮我们实现了。下面就进入该篇文章的主题吧，废话不多说，直接上图更有说服力。

<div>
    <image src="https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-Text.gif" width="250" title="同一高度"/>
    <image hspace="20" src="https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-DiffHeightText.gif" width="250"/>
    <image src="https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-Image.gif" width="250"/>
</div>

上面的示例图是我把**ItemView**分别用了**TextView**和**ImageView**。其实这些是没什么好说的，主要是如何定义这样的**LayoutManager**。相信大家都用过了**LinearLayoutManager**吧，系统提供的**LayoutManager**都是对齐的方式进行排版的，我们这里的**flow**的样式就是在排版**item**之前，判断了该行多余的空间还够不够显示，如果不够直接换行显示的思路。

### 使用:
**详见[TextFlowActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/app/src/main/java/com/single/flowlayout/TextFlowActivity.java)、[DiffHeightTextFlowActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/app/src/main/java/com/single/flowlayout/DiffHeightTextFlowActivity.java)、[PhotoFlowActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/app/src/main/java/com/single/flowlayout/PhotoFlowActivity.java)**
```
RecyclerView recyclerView = (RecyclerView) findViewById(flow);
FlowLayoutManager flowLayoutManager = new FlowLayoutManager();
//设置每一个item间距
recyclerView.addItemDecoration(new SpaceItemDecoration(dp2px(10)));
recyclerView.setLayoutManager(flowLayoutManager);
recyclerView.setAdapter(new FlowAdapter());
```

**常见商品属性界面:**

![商品属性界面.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/商品属性界面.gif)

使用:见[ProductActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/app/src/main/java/com/single/flowlayout/ProductActivity.java)

**常见悬浮商品属性界面:**

![商品属性界面.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/悬浮商品属性界面.gif)

使用:见[SuspensionProductActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/app/src/main/java/com/single/flowlayout/SuspensionProductActivity.java)

**常见viewpager中流式布局界面:**

![viewpager中流式布局界面.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/vp_flow/photos/viewpager中流式布局.gif)

使用:见[ViewPagerActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/vp_flow/app/src/main/java/com/single/flowlayout/ViewPagerActivity.java)

**常见长点击删除流式布局界面:**

![长点击删除界面.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/vp_flow/photos/长点击删除界面.gif)

使用:见[LongClickDeleteTextFlowActivity](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/vp_flow/app/src/main/java/com/single/flowlayout/LongClickDeleteTextFlowActivity.java)

**1.1版本:**

修复重复操作数据问题

**1.2版本:**

修复重复操作数据错位以及暴露内容高度

**1.3版本:**

修复中间添加数据时错位问题

**gradle依赖:**
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
        compile 'com.github.1002326270xc:LayoutManager-FlowLayout:v1.4'
}
```

**欢迎大家提出问题，留言板留言或邮箱直接联系我。我会第一时间测试相关的bug**
         
       
### 关于我:

**email:** a1002326270@163.com

**简书:** http://www.jianshu.com/users/7b186b7247c1/latest_articles

**csdn:** http://blog.csdn.net/u010429219/article/details/64915136
