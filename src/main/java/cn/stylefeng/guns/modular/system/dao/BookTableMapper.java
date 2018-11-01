package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.BookTable;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangyawei
 * @since 2018-10-29
 */
public interface BookTableMapper extends BaseMapper<BookTable> {
    /**
     * 根据条件查询
     * @param condition
     * @return
     */
    List<Map<String, Object>> selectBooks(@Param("condition") String condition);
}
