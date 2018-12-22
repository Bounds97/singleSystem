### 个人档案系统

本项目是一个简易版的个人档案系统，实现前后端分离，页面静态化。主要用到的技术有：

* Spring阿里巴巴的Druid连接池技术
* SpringMVC通过@ResponseBody注解返回json格式的数据给前端，@RequestBody注解接受前端传过来的json字符串数据给对应的参数
* Mybatis Mybatis分页
* restful风格 get、post、put、delete传值
* ajax ajax异步请求
* json实现前后端分离前后端相互建立一个约束关系，前端通过json字符串格式向后端传值，后端通过json格式返回给前端
* layui前端框架数据表格、模块化、方法渲染、自动化渲染的重载
