# JavaWeb 用户-登录注册-信息管理项目

## 前言

这个项目，达不到应用的层次，但是对于学完 JavaWeb 的朋友进行练手还是不错的，因为很多地方都是用的是比较原生的手法，例如分页等等，能更好的掌握知识，同时巩固练习

## 总述

这个项目使用 JavaWeb 相关的技术，摈弃了 JSP ，使用 HTML 配合 AJAX异步提交方式，完成了与后台的交互，前端界面主要依赖于Bootstrap 3 的前端框架，而后台部分使用的则是 Servlet 以及配合MySQL、Druid、 JDBCTemplate 完成数据的增删改查，对于数据的 json 格式处理 我们选择jackson技术

注意：在项目中UserServlet 继承 自定义BaseServlet 进行了抽取

## 说明

- 项目中使用了过滤器 进行权限的判断，不过由于时间仓促，可以说这部分还是有一些小问题，不过基本无伤大雅，部署项目在本地后，可以访问导航主页 `http://localhost:8080/index.html` 

  - 注：访问路径一定要有 index.html

- 用户注册中，需要验证邮箱是否正确，发送邮件激活后才可以正常登陆，发件人需要在 Utils 包下 MailUtils 中进行配置邮箱和密码

- sql 我放在了目录下 javaweb.sql 

  - 项目应用主要基于一个人事管理的场景，但是有不同需要，例如学生管理等，可以随时修改数据库，实体，以及相关的一些代码，核心思路没任何改变，只是换了一些说法罢了

- 这个项目使用的是后端分页，原先有一个 前端分页的Demo 这个页面是应用了一个Boostrap的前端分页插件，仅供参考，更新后已经删掉了。

- 这个项目主要点在于 相对完整的用户注册登录功能 以及管理员对于用户信息的后台增删改查功能

- 数据格式校验我们使用了前端的JQuery插件，当然也可以手写

  
## 效果展示

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/1.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/2.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/3.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/4.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/5.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/6.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/7.png)

![](https://github.com/ideal-20/JavaWeb-Login-Register-InfoManage/blob/master/img/8.png)


## 结尾

  如果有什么不足，或者错误的地方，欢迎大家留言分享想法，感谢朋友们的支持！

  如果能帮到你的话，那就来关注我吧！如果您更喜欢微信文章的阅读方式，可以关注我的公众号

  > 在这里的我们素不相识，却都在为了自己的梦而努力 ❤
  >
  > 一个坚持推送原创开发技术文章的公众号：理想二旬不止

  ![](http://image.ideal-20.cn/img/QRcode-rectangle.png)

 
