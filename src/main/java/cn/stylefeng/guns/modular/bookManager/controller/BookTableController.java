package cn.stylefeng.guns.modular.bookManager.controller;

import cn.stylefeng.guns.core.common.annotion.Permission;
import cn.stylefeng.guns.modular.system.warpper.BookWarpper;
import cn.stylefeng.guns.modular.system.warpper.RoleWarpper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.Condition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.system.model.BookTable;
import cn.stylefeng.guns.modular.bookManager.service.IBookTableService;

import java.util.List;
import java.util.Map;

/**
 * 书籍管理控制器
 *
 * @author fengshuonan
 * @Date 2018-10-29 16:26:18
 */
@Controller
@RequestMapping("/bookTable")
public class BookTableController extends BaseController {

    private String PREFIX = "/bookManager/bookTable/";

    @Autowired
    private IBookTableService bookTableService;

    /**
     * 跳转到书籍管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "bookTable.html";
    }

    /**
     * 跳转到添加书籍管理
     */
    @RequestMapping("/bookTable_add")
    public String bookTableAdd() {
        return PREFIX + "bookTable_add.html";
    }

    /**
     * 跳转到修改书籍管理
     */
    @RequestMapping("/bookTable_update/{bookTableId}")
    public String bookTableUpdate(@PathVariable Integer bookTableId, Model model) {
        BookTable bookTable = bookTableService.selectById(bookTableId);
        model.addAttribute("item",bookTable);
        LogObjectHolder.me().set(bookTable);
        return PREFIX + "bookTable_edit.html";
    }

    /**
     * 获取书籍管理列表
     */
    @Permission
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String bookName) {
        List<Map<String, Object>> books = this.bookTableService.selectBooks(super.getPara("bookName"));
        return super.warpObject(new BookWarpper(books));
//        return bookTableService.selectList(null);
    }

    /**
     * 获取根据书名称查询列表
     */
    @RequestMapping(value = "/listForBookName")
    @ResponseBody
    public Object listForBookName(@RequestParam(required = true) String bookName) {
        return bookTableService.selectBooks(bookName);
    }

    /**
     * 新增书籍管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(BookTable bookTable) {
        bookTableService.insert(bookTable);
        return SUCCESS_TIP;
    }

    /**
     * 删除书籍管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer bookTableId) {
        bookTableService.deleteById(bookTableId);
        return SUCCESS_TIP;
    }

    /**
     * 修改书籍管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(BookTable bookTable) {
        bookTableService.updateById(bookTable);
        return SUCCESS_TIP;
    }

    /**
     * 书籍管理详情
     */
    @RequestMapping(value = "/detail/{bookTableId}")
    @ResponseBody
    public Object detail(@PathVariable("bookTableId") Integer bookTableId) {
        return bookTableService.selectById(bookTableId);
    }
}
