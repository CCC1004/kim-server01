/**
 * 轮播图管理初始化
 */
var KimIndexLb = {
    id: "KimIndexLbTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
KimIndexLb.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键自增', field: 'guid', visible: false, align: 'center', valign: 'middle'},
            {title: '轮播页名称', field: 'lbName', visible: true, align: 'center', valign: 'middle'},
            {title: '轮播图片id', field: 'lbImage', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'lbSort', visible: true, align: 'center', valign: 'middle'},
            {title: '是否显示', field: 'lbStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
            {title: '时间戳', field: 'ts', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
KimIndexLb.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        KimIndexLb.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加轮播图
 */
KimIndexLb.openAddKimIndexLb = function () {
    var index = layer.open({
        type: 2,
        title: '添加轮播图',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/kimIndexLb/kimIndexLb_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看轮播图详情
 */
KimIndexLb.openKimIndexLbDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '轮播图详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/kimIndexLb/kimIndexLb_update/' + KimIndexLb.seItem.guid
        });
        this.layerIndex = index;
    }
};

/**
 * 删除轮播图
 */
KimIndexLb.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/kimIndexLb/delete", function (data) {
                Feng.success("删除成功!");
                KimIndexLb.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("kimIndexLbId",KimIndexLb.seItem.guid);
            ajax.start();
        }
        Feng.confirm("是否刪除?", operation);
    }
};

/**
 * 查询轮播图列表
 */
KimIndexLb.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    KimIndexLb.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = KimIndexLb.initColumn();
    var table = new BSTable(KimIndexLb.id, "/kimIndexLb/list", defaultColunms);
    table.setPaginationType("client");
    KimIndexLb.table = table.init();
});
