package team.softwarede.confersys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.Permission;

@Mapper
public interface PermissionMapper {

    List<Permission> selectByRoleId(Integer roleId);
    
    List<Permission> selectAll();
    
    int insert(Permission record);

    int insertSelective(Permission record);
    
}