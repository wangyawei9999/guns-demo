package cn.stylefeng.guns.modular.bookManager.service;

import cn.stylefeng.guns.modular.system.model.BookTable;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangyawei
 * @since 2018-10-29
 */
public interface IBookTableService extends IService<BookTable> {
    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    List<Map<String, Object>> selectBooks(String condition);
}
