# jsonfilter
A simple POJO property filter for Resful JSON output bases on fastjson and springboot.

## Dependencies
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>1.5.9.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.46</version>
        </dependency>
```
## Install
Add **jsonfilter-1.0.4.jar** to your project's dependencies. You can do like that in maven project:
```
        <dependency>
            <groupId>com.liuyis</groupId>
            <artifactId>jsonfilter</artifactId>
            <version>1.0.4</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/libs/jsonfilter-1.0.4.jar</systemPath>
        </dependency>
```

Then, just enjoy it !

## Example

**customize a POJO json output**
```Java
    @GetMapping("/user")
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you want to save
    @SerializeField(clazz = User.class,includes = {"name","id"})
    public User user() {
        User user = new User(1L, "liuyis", "123456");
        return user;
    }
```
you will get response like that : {"id":1,"name":"liuyis"}

**customize two POJO json output**
```Java
    @GetMapping("/user2")
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you want to save
    @SerializeField(clazz = User.class,includes = {"name", "id", "addresses"})
    //use @MultiSerializeField annotation to customize the second POJO json output *_*
    //clazz -- the POJO class that you want to customize
    //excludes -- the properties in POJO that you do not want to show in json output
    @MultiSerializeField(clazz = Address.class, excludes = {"user"})
    public User user2() {
        User user = new User(1L, "liuyis", "123456");
        List<Address> addresses = new ArrayList<>();
        Address a1 = new Address("liuyis's home", "liuyis's school", user);
        Address a2 = new Address("liuyis's home2", "liuyis's school2", user);
        addresses.add(a1);
        addresses.add(a2);
        user.setAddresses(addresses);

        return user;
    }
```
you will get response like that: {"addresses":[{"home":"liuyis's home","school":"liuyis's school"},{"home":"liuyis's home2","school":"liuyis's school2"}],"id":1,"name":"liuyis"}


```Java
    @GetMapping("/address")
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you wan to save
    @SerializeField(clazz = Address.class, includes = {"school", "home", "user"})
    //use @MultiSerializeField annotation to customize the second POJO json output *_*
    //clazz -- the POJO class that you want to customize
    //excludes -- the properties in POJO that you do not want to show in json output
    @MultiSerializeField(clazz = User.class, excludes = {"addresses"})
    public Address address(){
        User user = new User(1L, "liuyis", "123456");
        List<Address> addresses = new ArrayList<>();
        Address a1 = new Address("liuyis's home", "liuyis's school", user);
        Address a2 = new Address("liuyis's home2", "liuyis's school2", user);
        addresses.add(a1);
        addresses.add(a2);
        user.setAddresses(addresses);

        return a1;
    }
```
you will get response like that:{"home":"liuyis's home","school":"liuyis's school","user":{"id":1,"name":"liuyis"}}

**customize mutiple POJO json output**
```Java
    @GetMapping("/address2")
    //use @MoreSerializeField annotation to customize mutiple POJO json output *_*
    //add @SerializeField annotation as many as you want :)
    @MoreSerializeField({
            @SerializeField(clazz = Address.class,includes = {"school", "home", "user"}),
            @SerializeField(clazz = User.class, includes = {"id", "name"})})
    public Address address2(){
        User user = new User(1L, "liuyis", "123456");
        List<Address> addresses = new ArrayList<>();
        Address a1 = new Address("liuyis's home", "liuyis's school", user);
        Address a2 = new Address("liuyis's home2", "liuyis's school2", user);
        addresses.add(a1);
        addresses.add(a2);
        user.setAddresses(addresses);

        return a1;
    }
```
you will get response like that:{"home":"liuyis's home","school":"liuyis's school","user":{"id":1,"name":"liuyis"}}




