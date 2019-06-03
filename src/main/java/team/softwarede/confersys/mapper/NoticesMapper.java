package team.softwarede.confersys.mapper;

import org.apache.ibatis.annotations.Mapper;

import team.softwarede.confersys.entity.NoticesKey;

@Mapper
public interface NoticesMapper {

    int deleteByPrimaryKey(NoticesKey key);

    int insert(NoticesKey record);

    int insertSelective(NoticesKey record);
}