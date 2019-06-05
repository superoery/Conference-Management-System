package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Role;

@Mapper
public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    //根据权限名称查找权限
    Role selectByName(String name);
    
    Role selectByUId(String userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}