package edu.neu.springcloud.provider_1.controller;

import edu.neu.springcloud.provider_1.bean.TbUser;
import edu.neu.springcloud.provider_1.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")

public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/add/{code}")
    public List<TbUser> add(@PathVariable String code){
        System.out.println("you are using provider1");
        String[] temp = code.split("-");
        TbUser user = new TbUser();
        user.setId(Integer.parseInt(temp[0]));
        user.setLoginName(temp[1]);
        user.setUsername(temp[2]);
        user.setPassword(temp[3]);
        userService.addUser(user);
        return userService.findAll();
    }


    @RequestMapping("/delete/{code}")
    public List<TbUser> delete(@PathVariable String code){
        System.out.println("you are using provider1");
        userService.deleteByCode(code);
        return userService.findAll();
    }

    @RequestMapping("/change/{code}")
    public List<TbUser> change(@PathVariable String code){
        System.out.println("you are using provider1");
        String[] temp = code.split("-");
        TbUser user = new TbUser();
        user.setId(Integer.parseInt(temp[0]));
        user.setLoginName(temp[1]);
        user.setUsername(temp[2]);
        user.setPassword(temp[3]);
        userService.changeUser(user);
        return userService.findAll();
    }

    @RequestMapping("/findAll")
    public List<TbUser> findAll(){
        System.out.println("you are using provider1");
        return userService.findAll();
    }

    @RequestMapping("/findById/{code}")
    public TbUser findByCode(@PathVariable String code){
        return userService.findByCode(code);
    }

    @RequestMapping("/findByName/{code}")
    public TbUser findBuName(@PathVariable String code){
        List<TbUser> users = userService.findAll();
        for(TbUser tbUser : users){
            if(tbUser.getUsername().equals(code)){
                return tbUser;
            }
        }
        System.out.println("没有找到用户");
        return null;
    }

    @RequestMapping("findByIdAndName/{code}")
    public TbUser findByIdAndName(@PathVariable String code){
        String[] args = code.split("-");
        List<TbUser> users = userService.findAll();
        for(TbUser tbUser : users){
            if(tbUser.getId().equals(args[0]) && tbUser.getUsername().equals(args[1])){
                return tbUser;
            }
        }
        System.out.println("没有找到用户");
        return null;
    }


}
