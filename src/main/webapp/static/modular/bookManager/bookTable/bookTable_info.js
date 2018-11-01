/**
 * 初始化书籍管理详情对话框
 */
var BookTableInfoDlg = {
    bookTableInfoData : {}
};

/**
 * 清除数据
 */
BookTableInfoDlg.clearData = function() {
    this.bookTableInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BookTableInfoDlg.set = function(key, val) {
    this.bookTableInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
BookTableInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
BookTableInfoDlg.close = function() {
    parent.layer.close(window.parent.BookTable.layerIndex);
}

/**
 * 收集数据
 */
BookTableInfoDlg.collectData = function() {
    this
    .set('id')
    .set('bookName')
    .set('bookAuth')
    .set('bookDesc')
    .set('bookPrice')
    .set('bookDate');
}

/**
 * 提交添加
 */
BookTableInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bookTable/add", function(data){
        Feng.success("添加成功!");
        window.parent.BookTable.table.refresh();
        BookTableInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bookTableInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
BookTableInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/bookTable/update", function(data){
        Feng.success("修改成功!");
        window.parent.BookTable.table.refresh();
        BookTableInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.bookTableInfoData);
    ajax.start();
}

$(function() {

});
