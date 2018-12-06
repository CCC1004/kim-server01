/**
 * 初始化精品分类详情对话框
 */
var CoinIndexJpflInfoDlg = {
    coinIndexJpflInfoData : {}
};

/**
 * 清除数据
 */
CoinIndexJpflInfoDlg.clearData = function() {
    this.coinIndexJpflInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinIndexJpflInfoDlg.set = function(key, val) {
    this.coinIndexJpflInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinIndexJpflInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CoinIndexJpflInfoDlg.close = function() {
    parent.layer.close(window.parent.CoinIndexJpfl.layerIndex);
}

/**
 * 收集数据
 */
CoinIndexJpflInfoDlg.collectData = function() {
    this
    .set('guid')
    .set('flName')
    .set('flImage')
    .set('flDesc')
    .set('flSort')
    .set('flStatus')
    .set('nt')
    .set('ts');
}

/**
 * 提交添加
 */
CoinIndexJpflInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinIndexJpfl/add", function(data){
        Feng.success("添加成功!");
        window.parent.CoinIndexJpfl.table.refresh();
        CoinIndexJpflInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinIndexJpflInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CoinIndexJpflInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinIndexJpfl/update", function(data){
        Feng.success("修改成功!");
        window.parent.CoinIndexJpfl.table.refresh();
        CoinIndexJpflInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinIndexJpflInfoData);
    ajax.start();
}

$(function() {

});
