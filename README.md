说真的自从对**RecyclerView**的**LayoutManager**有新的认识后，完全不用担心很多的复杂布局了。而且对**ViewGroup**测量过程也不用担心了，因为里面有**LayoutManager**帮我们实现了。下面就进入该篇文章的主题吧，废话不多说，直接上图更有说服力。

**统一高度文本形式**

![RecyclerView-LayoutManager-Text.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-Text.gif)

**不同高度文本行居中显示形式**

![RecyclerView-LayoutManager-DiffHeightText.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-DiffHeightText.gif)

**图片形式**

![RecyclerView-LayoutManager-Image.gif](https://github.com/1002326270xc/LayoutManager-FlowLayout/blob/master/photos/RecyclerView-LayoutManager-Image.gif)

上面的示例图是我把**ItemView**分别用了**TextView**和**ImageView**。其实这些是没什么好说的，主要是如何定义这样的**LayoutManager**。相信大家都用过了**LinearLayoutManager**吧，系统提供的**LayoutManager**都是对齐的方式进行排版的，我们这里的**flow**的样式就是在排版**item**之前，判断了该行多余的空间还够不够显示，如果不够直接换行显示的思路。
         
       
### 关于我:

**email:** a1002326270@163.com

**简书:** http://www.jianshu.com/users/7b186b7247c1/latest_articles
