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

customize two POJO json output
```Java
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you wan to save
    @SerializeField(clazz = Address.class, includes = {"school", "home","user"})
    //use @MultiSerializeField annotation to customize the second POJO json output *_*
    //clazz -- the POJO class that you want to customize
    //excludes -- the properties in POJO that you do not want to show json output
    @MultiSerializeField(clazz = User.class, excludes = {"addresses"})
    public Address getAddressById(@PathVariable Long id){
        return addressService.findAddressById(id);
    }
```
you will get response like that:{"home":"myhomeAddress","school":"myschoolAddress","user":{"id":1,"name":"liuyi","password": "19942333333"}}

customize mutiple POJO json output
```Java
    @RequestMapping(value = "/", method = RequestMethod.POST)
    //use @MoreSerializeField annotation to customize mutiple POJO json output *_*
    //add @SerializeField annotation as many as you want :)
    @MoreSerializeField({
            @SerializeField(clazz = Address.class,includes = {"school", "home","user"}),
            @SerializeField(clazz = User.class, includes = {"id", "name"})})
    public Address createAddress(Address address){
        return addressService.addAddress(address);
    }
```



