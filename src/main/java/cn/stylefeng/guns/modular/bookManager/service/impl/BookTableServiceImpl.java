package cn.stylefeng.guns.modular.bookManager.service.impl;

import cn.stylefeng.guns.modular.system.model.BookTable;
import cn.stylefeng.guns.modular.system.dao.BookTableMapper;
import cn.stylefeng.guns.modular.bookManager.service.IBookTableService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyawei
 * @since 2018-10-29
 */
@Service
public class BookTableServiceImpl extends ServiceImpl<BookTableMapper, BookTable> implements IBookTableService {

    @Override
    public List<Map<String, Object>> selectBooks(String condition) {
        return this.baseMapper.selectBooks(condition);
    }
}
