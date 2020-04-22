使用须知：
   user-manager模块
     1、必须创建com.cbat.usermanager.config.ShiroFilterConfig类的实现类
        可用于自定义shiro的拦截规则和认证规则，该子类需在spring中注册
        拦截器默认实现为从数据库查找，然后复赋值
     2、必须在cbat-application.properties中配置拦截器的相关默认路径
        #跳转登陆url  可替换为controller
        cbat.url.login=/page/login.html
        #跳转认证url  可替换为controller
        cbat.url.authorized=/page/authorized.html
     3、