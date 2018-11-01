package cn.stylefeng.guns.modular.system.warpper;

import cn.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

public class BookWarpper extends BaseControllerWrapper {

    public BookWarpper(Map<String, Object> single) {
        super(single);
    }

    public BookWarpper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public BookWarpper(Page<Map<String, Object>> page) {
        super(page);
    }

    public BookWarpper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("bookName", ConstantFactory.me().getBookName((Integer) map.get("id")));
        map.put("bookAuth", ConstantFactory.me().getBookAuth((Integer) map.get("id")));
        map.put("bookDesc", ConstantFactory.me().getBookDesc((Integer) map.get("id")));
        map.put("bookPrice", ConstantFactory.me().getBookPrice((Integer) map.get("id")));
        map.put("bookDate", ConstantFactory.me().getBookDate((Integer) map.get("id")));
//        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("deptid")));
    }

}
