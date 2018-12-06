/**
 * 初始化轮播图详情对话框
 */
var CoinIndexLbInfoDlg = {
    coinIndexLbInfoData : {}
};

/**
 * 清除数据
 */
CoinIndexLbInfoDlg.clearData = function() {
    this.coinIndexLbInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinIndexLbInfoDlg.set = function(key, val) {
    this.coinIndexLbInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinIndexLbInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CoinIndexLbInfoDlg.close = function() {
    parent.layer.close(window.parent.CoinIndexLb.layerIndex);
}

/**
 * 收集数据
 */
CoinIndexLbInfoDlg.collectData = function() {
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
CoinIndexLbInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinIndexLb/add", function(data){
        Feng.success("添加成功!");
        window.parent.CoinIndexLb.table.refresh();
        CoinIndexLbInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinIndexLbInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CoinIndexLbInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinIndexLb/update", function(data){
        Feng.success("修改成功!");
        window.parent.CoinIndexLb.table.refresh();
        CoinIndexLbInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinIndexLbInfoData);
    ajax.start();
}

$(function() {

});
