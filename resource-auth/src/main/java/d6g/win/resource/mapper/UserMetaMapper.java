package d6g.win.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import d6g.win.resource.entity.UserEntity;
import d6g.win.resource.entity.UserMetaEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMetaMapper extends BaseMapper<UserMetaEntity> {


}
