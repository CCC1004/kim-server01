/**
 * 热门图片管理初始化
 */
var KimIndexRmtp = {
    id: "KimIndexRmtpTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
KimIndexRmtp.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键自增', field: 'guid', visible: true, align: 'center', valign: 'middle'},
            {title: '热门名称', field: 'rmName', visible: true, align: 'center', valign: 'middle'},
            {title: '热门图片id(与资源信息主键匹配)', field: 'rmImage', visible: true, align: 'center', valign: 'middle'},
            {title: '头像图片id(与资源信息主键匹配)', field: 'rmHeadImg', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'rmTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '内容', field: 'rmContext', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'rmSort', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
            {title: '时间戳', field: 'ts', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
KimIndexRmtp.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        KimIndexRmtp.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加热门图片
 */
KimIndexRmtp.openAddKimIndexRmtp = function () {
    var index = layer.open({
        type: 2,
        title: '添加热门图片',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/kimIndexRmtp/kimIndexRmtp_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看热门图片详情
 */
KimIndexRmtp.openKimIndexRmtpDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '热门图片详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/kimIndexRmtp/kimIndexRmtp_update/' + KimIndexRmtp.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除热门图片
 */
KimIndexRmtp.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/kimIndexRmtp/delete", function (data) {
            Feng.success("删除成功!");
            KimIndexRmtp.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("kimIndexRmtpId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询热门图片列表
 */
KimIndexRmtp.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    KimIndexRmtp.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = KimIndexRmtp.initColumn();
    var table = new BSTable(KimIndexRmtp.id, "/kimIndexRmtp/list", defaultColunms);
    table.setPaginationType("client");
    KimIndexRmtp.table = table.init();
});
