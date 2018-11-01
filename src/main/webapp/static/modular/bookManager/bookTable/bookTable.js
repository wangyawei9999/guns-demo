/**
 * 书籍管理管理初始化
 */
var BookTable = {
    id: "BookTableTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BookTable.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '书籍编号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '书籍名称', field: 'bookName', visible: true, align: 'center', valign: 'middle'},
            {title: '书籍作者', field: 'bookAuth', visible: true, align: 'center', valign: 'middle'},
            {title: '书籍描述', field: 'bookDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '书籍价格', field: 'bookPrice', visible: true, align: 'center', valign: 'middle'},
            {title: '书籍发行日期', field: 'bookDate', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
BookTable.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        BookTable.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加书籍管理
 */
BookTable.openAddBookTable = function () {
    var index = layer.open({
        type: 2,
        title: '添加书籍管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/bookTable/bookTable_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看书籍管理详情
 */
BookTable.openBookTableDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '书籍管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/bookTable/bookTable_update/' + BookTable.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除书籍管理
 */
BookTable.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/bookTable/delete", function (data) {
            Feng.success("删除成功!");
            BookTable.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("bookTableId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询书籍管理列表
 */
BookTable.search = function () {
    var queryData = {};
    queryData['bookName'] = $("#bookName").val();
    BookTable.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = BookTable.initColumn();
    var table = new BSTable(BookTable.id, "/bookTable/list", defaultColunms);
    table.setPaginationType("client");
    BookTable.table = table.init();
});
