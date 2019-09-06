# spring-cloud-config-demo
微服务配置管理demo
Config-Server: Spring Cloud Config Server即服务器项目
Config-Client: Spring Cloud Config Client即客户端项目
##配置文件的管理 Spring Cloud Config支持在Git, SVN和本地存放配置文件，使用Git或者SVN存储库可以很好地支持版本管理，Spring默认配置是使用Git存储库。在本案例中将使用OSChina提供的Git服务存储配置文件。为了能让Config客户端准确的找到配置文件，在管理配置文件项目my-sample-config中放置配置文件时，需要了解application, profile和label的概念：

{application}映射到Config客户端的spring.application.name属性
{profile}映射到Config客户端的spring.profiles.active属性，可以用来区分环境
{label}映射到Git服务器的commit id, 分支名称或者tag，默认值为master

config服务端访问git仓库：http://localhost:8888/applicationName/master

config服务端搭建：
1.引入spring-boot-starter-web和spring-cloud-config-server依赖
2.在config-server的启动类上加上@EnableConfigServer注解
3.application.proprties中需设置I：server.port=8888 II：spring.cloud.config.server.git.uri=https://gitee.com/yu-fan/config-server.git
                              III：spring.cloud.config.server.git.searchpaths = config-server(searchPaths参数提示Config服务器搜索config-server子目录。)
                              
                              
config客户端搭建：
1.1.引入spring-boot-starter-web和spring-cloud-starter-config依赖
2.application.properties中需设置I：server.port=8131 II：spring.cloud.config.profile=prod(设置开发环境)
                               III：spring.application.name=config-server(与git上文件名有关)
                               IV：spring.cloud.config.uri=http://localhost:8888(config服务器地址)
3.@RefreshScope  当git仓库文件变化时，加上此注解，不需重启客户端即可更新value值
