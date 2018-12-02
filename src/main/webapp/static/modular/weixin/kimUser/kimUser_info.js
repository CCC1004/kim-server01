/**
 * 初始化微信用户详情对话框
 */
var KimUserInfoDlg = {
    kimUserInfoData : {}
};

/**
 * 清除数据
 */
KimUserInfoDlg.clearData = function() {
    this.kimUserInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimUserInfoDlg.set = function(key, val) {
    this.kimUserInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimUserInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
KimUserInfoDlg.close = function() {
    parent.layer.close(window.parent.KimUser.layerIndex);
}

/**
 * 收集数据
 */
KimUserInfoDlg.collectData = function() {
    this
    .set('uuid')
    .set('username')
    .set('password')
    .set('age')
    .set('sex')
    .set('job')
    .set('realname')
    .set('faceImage')
    .set('province')
    .set('city')
    .set('district')
    .set('address')
    .set('openid')
    .set('nt')
    .set('ts');
}

/**
 * 提交添加
 */
KimUserInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimUser/add", function(data){
        Feng.success("添加成功!");
        window.parent.KimUser.table.refresh();
        KimUserInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimUserInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
KimUserInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimUser/update", function(data){
        Feng.success("修改成功!");
        window.parent.KimUser.table.refresh();
        KimUserInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimUserInfoData);
    ajax.start();
}

$(function() {

});
