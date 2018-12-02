/**
 * 初始化热门图片详情对话框
 */
var KimIndexRmtpInfoDlg = {
    kimIndexRmtpInfoData : {}
};

/**
 * 清除数据
 */
KimIndexRmtpInfoDlg.clearData = function() {
    this.kimIndexRmtpInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexRmtpInfoDlg.set = function(key, val) {
    this.kimIndexRmtpInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexRmtpInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
KimIndexRmtpInfoDlg.close = function() {
    parent.layer.close(window.parent.KimIndexRmtp.layerIndex);
    //刷新列表
    window.parent.KimIndexRmtp.table.refresh();
}

/**
 * 收集数据
 */
KimIndexRmtpInfoDlg.collectData = function() {
    this
    .set('guid')
    .set('rmName')
    .set('rmImage')
    .set('rmHeadImg')
    .set('rmTitle')
    .set('rmContext')
    .set('rmSort')
    .set('rmStatus')
    .set('nt')
    .set('ts');
}

/**
 * 提交添加
 */
KimIndexRmtpInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimIndexRmtp/add", function(data){
        Feng.success("添加成功!");
        window.parent.KimIndexRmtp.table.refresh();
        KimIndexRmtpInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexRmtpInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
KimIndexRmtpInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimIndexRmtp/update", function(data){
        Feng.success("修改成功!");
        window.parent.KimIndexRmtp.table.refresh();
        KimIndexRmtpInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexRmtpInfoData);
    ajax.start();
}

$(function() {

});
