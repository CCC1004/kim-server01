/**
 * 初始化精品推荐详情对话框
 */
var KimIndexJptjInfoDlg = {
    kimIndexJptjInfoData : {}
};

/**
 * 清除数据
 */
KimIndexJptjInfoDlg.clearData = function() {
    this.kimIndexJptjInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexJptjInfoDlg.set = function(key, val) {
    this.kimIndexJptjInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KimIndexJptjInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
KimIndexJptjInfoDlg.close = function() {
    parent.layer.close(window.parent.KimIndexJptj.layerIndex);
    //刷新列表
    window.parent.KimIndexJptj.table.refresh();
}

/**
 * 收集数据
 */
KimIndexJptjInfoDlg.collectData = function() {
    this
    .set('guid')
    .set('jpName')
    .set('jpImage')
    .set('jpDesc')
    .set('jpSort')
    .set('jpStatus')
    .set('nt')
    .set('ts');
}

/**
 * 提交添加
 */
KimIndexJptjInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    // var ajax = new $ax(Feng.ctxPath + "/kimIndexJptj/add", function(data){
    var ajax = new $ax(Feng.ctxPath + "/kimIndexJptj/addJptj", function(data){
        Feng.success("添加成功!");
        window.parent.KimIndexJptj.table.refresh();
        KimIndexJptjInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexJptjInfoData);
    ajax.start();
}

/**
 * 添加精品图片
 */
$("#fileSubmit").click(function(){

    this.clearData();
    this.collectData();

    if($.browser.msie){
        window.uploadForm.submit();
    }else{
        $("#uploadForm").submit();
    }
});

/**
 * 提交修改
 */
KimIndexJptjInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/kimIndexJptj/update", function(data){
        Feng.success("修改成功!");
        window.parent.KimIndexJptj.table.refresh();
        KimIndexJptjInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.kimIndexJptjInfoData);
    ajax.start();
}

$(function() {


});
