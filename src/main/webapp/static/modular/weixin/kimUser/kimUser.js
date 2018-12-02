/**
 * 微信用户管理初始化
 */
var KimUser = {
    id: "KimUserTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
KimUser.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'uuid', visible: true, align: 'center', valign: 'middle'},
            {title: '用户名', field: 'username', visible: true, align: 'center', valign: 'middle'},
            {title: '密码', field: 'password', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'age', visible: true, align: 'center', valign: 'middle'},
            {title: '性别（0女1男2保密）', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '职业类型(1：Java开发 2：前端开发 3：大数据开发 4：ios开发 5：Android开发 10：学生 11：其它)', field: 'job', visible: true, align: 'center', valign: 'middle'},
            {title: '真实姓名', field: 'realname', visible: true, align: 'center', valign: 'middle'},
            {title: '头像地址（资源表主键）', field: 'faceImage', visible: true, align: 'center', valign: 'middle'},
            {title: '省', field: 'province', visible: true, align: 'center', valign: 'middle'},
            {title: '市', field: 'city', visible: true, align: 'center', valign: 'middle'},
            {title: '区', field: 'district', visible: true, align: 'center', valign: 'middle'},
            {title: '详细地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '微信登录id', field: 'openid', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
            {title: '时间戳', field: 'ts', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
KimUser.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        KimUser.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加微信用户
 */
KimUser.openAddKimUser = function () {
    var index = layer.open({
        type: 2,
        title: '添加微信用户',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/kimUser/kimUser_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看微信用户详情
 */
KimUser.openKimUserDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '微信用户详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/kimUser/kimUser_update/' + KimUser.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除微信用户
 */
KimUser.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/kimUser/delete", function (data) {
            Feng.success("删除成功!");
            KimUser.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("kimUserId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询微信用户列表
 */
KimUser.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    KimUser.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = KimUser.initColumn();
    var table = new BSTable(KimUser.id, "/kimUser/list", defaultColunms);
    table.setPaginationType("client");
    KimUser.table = table.init();
});
