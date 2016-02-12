# jsonfilter
A json field filter bases on fastjson and springboot

## Dependencies
```
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.2.RELEASE</version>
 </parent>
<dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.7</version>
  </dependency>
```
## Install
add **jsonfilter-1.0.0.jar** to your project's dependencies

if you are using springboot with **@EnableAutoConfiguration** and **@ComponentScan** , you can just use it without any configuration
!

if you are using springboot that configs and scans components by yourself, you should add **"com.liuyis.jsonfilter"** to your config path and component path.
## example

customize a POJO json output
```Java
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you want to save
    @SerializeField(clazz = User.class,includes = {"name","id"})
    public User getUser(@PathVariable Long id){
        return  userService.getUserById(id);
    }
```
you will get response like that : {"id": 1, "name": "liuyis"}
