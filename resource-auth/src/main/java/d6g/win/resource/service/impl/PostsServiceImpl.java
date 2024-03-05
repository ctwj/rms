package d6g.win.resource.service.impl;

import d6g.win.resource.entity.Posts;
import d6g.win.resource.mapper.PostsMapper;
import d6g.win.resource.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ctwj
 * @since 2024-03-05
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

}
