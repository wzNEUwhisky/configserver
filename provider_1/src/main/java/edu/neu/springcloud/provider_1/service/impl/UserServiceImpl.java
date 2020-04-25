package edu.neu.springcloud.provider_1.service.impl;

import edu.neu.springcloud.provider_1.bean.TbUser;
import edu.neu.springcloud.provider_1.bean.TbUserExample;
import edu.neu.springcloud.provider_1.repository.TbUserMapper;
import edu.neu.springcloud.provider_1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    TbUserMapper tbUserMapper;

    @Override
    public List<TbUser> findAll() {
        TbUserExample tbUserExample = new TbUserExample();
        return tbUserMapper.selectByExample(tbUserExample);

    }

    @Override
    public TbUser findByCode(String code) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(code));
        return tbUserMapper.selectByExample(tbUserExample).get(0);
    }

    @Override
    public int deleteByCode(String code) {

        int id = Integer.parseInt(code);
        return tbUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addUser(TbUser user) {
        return tbUserMapper.insert(user);
    }

    @Override
    public int changeUser(TbUser user) {
        return tbUserMapper.updateByPrimaryKey(user);
    }
}
