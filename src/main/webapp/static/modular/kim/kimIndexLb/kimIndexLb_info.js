/**
 * 初始化轮播图详情对话框
 */
var KimIndexLbInfoDlg = {
    kimIndexLbInfoData : {}
};

/**
 * 清除数据
 */
KimIndexLbInfoDlg.clearData = function() {
    this.kimIndexLbInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexLbInfoDlg.set = function(key, val) {
    this.kimIndexLbInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexLbInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
KimIndexLbInfoDlg.close = function() {
    parent.layer.close(window.parent.KimIndexLb.layerIndex);
}

/**
 * 收集数据
 */
KimIndexLbInfoDlg.collectData = function() {
    this
    .set('guid')
    .set('lbName')
    .set('lbImage')
    .set('lbSort')
    .set('lbStatus')
    .set('nt')
    .set('ts');
}

/**
 * 提交添加
 */
KimIndexLbInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimIndexLb/add", function(data){
        Feng.success("添加成功!");
        window.parent.KimIndexLb.table.refresh();
        KimIndexLbInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexLbInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
KimIndexLbInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimIndexLb/update", function(data){
        Feng.success("修改成功!");
        window.parent.KimIndexLb.table.refresh();
        KimIndexLbInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexLbInfoData);
    ajax.start();
}

$(function() {

});
