package com.liuyis.demo;

import com.liuyis.demo.bean.Address;
import com.liuyis.demo.bean.User;
import com.liuyis.jsonfilter.annotation.MoreSerializeField;
import com.liuyis.jsonfilter.annotation.MultiSerializeField;
import com.liuyis.jsonfilter.annotation.SerializeField;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyis on 2018/4/7.
 */
@RestController
@SpringBootApplication
public class Demo {


    @GetMapping("/user")
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you want to save
    @SerializeField(clazz = User.class,includes = {"name", "id"})
    public User user() {
        User user = new User(1L, "liuyis", "123456");
        List<Address> addresses = new ArrayList<>();
        Address a1 = new Address("liuyis's home", "liuyis's school", user);
        Address a2 = new Address("liuyis's home2", "liuyis's school2", user);
        addresses.add(a1);
        addresses.add(a2);
        user.setAddresses(addresses);

        return user;
    }

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

    @GetMapping("/address")
    //use annotation to customize your json output *_*
    //clazz -- the POJO class that you want to customize
    //includes -- the properties in POJO that you wan to save
    @SerializeField(clazz = Address.class, includes = {"school", "home", "user"})
    //use @MultiSerializeField annotation to customize the second POJO json output *_*
    //clazz -- the POJO class that you want to customize
    //excludes -- the properties in POJO that you do not want to show in json output
    @MultiSerializeField(clazz = User.class, excludes = {"addresses", "password"})
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

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Demo.class, args);
    }
}
