package team.softwarede.confersys.dtomapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import team.softwarede.confersys.dto.UGroupSearch;
import team.softwarede.confersys.dto.UserAndGroup;
import team.softwarede.confersys.dto.UserSearch;

/**
 * @author Mity1299
 *
 */
@Mapper
public interface UserAndGroupMapper {

   // List<UserAndGroup> selectUserFuzzyBykeyword(@Param("keyword")String keyword);
    
    List<UserSearch> selectUserFuzzyBykeyword(String keyword);

    List<UGroupSearch> selectGroupFuzzyBykeyword(@Param("createrIdList")List<String> createrIdList,
                                                 @Param("keyword")String keyword);
    
}

