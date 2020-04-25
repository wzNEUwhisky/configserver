package edu.neu.springcloud.provider_2.service;

import edu.neu.springcloud.provider_2.bean.TbUser;

import java.util.List;

public interface UserService {
    public List<TbUser> findAll();
    public TbUser findByCode(String code);
    public int deleteByCode(String code);
    public int addUser(TbUser user);
    public int changeUser(TbUser user);

}
