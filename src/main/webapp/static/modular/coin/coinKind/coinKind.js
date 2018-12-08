/**
 * 品种信息管理初始化
 */
var CoinKind = {
    id: "CoinKindTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CoinKind.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '主键uuid', field: 'guid', visible: true, align: 'center', valign: 'middle'},
            {title: '品种名称', field: 'kindName', visible: true, align: 'center', valign: 'middle'},
            {title: '面值', field: 'kindValue', visible: true, align: 'center', valign: 'middle'},
            {title: '品种描述', field: 'kindDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '精品分类id', field: 'flId', visible: true, align: 'center', valign: 'middle'},
            {title: '发行日期', field: 'issueTime', visible: true, align: 'center', valign: 'middle'},
            {title: '发行量', field: 'issueSize', visible: true, align: 'center', valign: 'middle'},
            {title: '规格', field: 'kindSize', visible: true, align: 'center', valign: 'middle'},
            {title: '材质', field: 'kindMaterial', visible: true, align: 'center', valign: 'middle'},
            {title: '品种包装', field: 'kindPacking', visible: true, align: 'center', valign: 'middle'},
            {title: '目前价格下限', field: 'nowPriseDown', visible: true, align: 'center', valign: 'middle'},
            {title: '目前价格上限', field: 'nowPriseUp', visible: false, align: 'center', valign: 'middle'},
            // {title: '品种图片1（与资源表id关联）', field: 'kindImage', visible: true, align: 'center', valign: 'middle'},
            // {title: '品种图片2', field: 'kindImage2', visible: true, align: 'center', valign: 'middle'},
            // {title: '品种图片3', field: 'kindImage3', visible: true, align: 'center', valign: 'middle'},
            // {title: '品种图片4', field: 'kindImage4', visible: true, align: 'center', valign: 'middle'},
            // {title: '时间戳', field: 'ts', visible: true, align: 'center', valign: 'middle'},
            // {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CoinKind.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CoinKind.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加品种信息
 */
CoinKind.openAddCoinKind = function () {
    var index = layer.open({
        type: 2,
        title: '添加品种信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/coinKind/coinKind_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看品种信息详情
 */
CoinKind.openCoinKindDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '品种信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/coinKind/coinKind_update/' + CoinKind.seItem.guid
        });
        this.layerIndex = index;
    }
};

/**
 * 删除品种信息
 */
CoinKind.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/coinKind/delete", function (data) {
            Feng.success("删除成功!");
            CoinKind.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("coinKindId",CoinKind.seItem.guid);
        ajax.start();
    }
};

/**
 * 查询品种信息列表
 */
CoinKind.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CoinKind.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CoinKind.initColumn();
    var table = new BSTable(CoinKind.id, "/coinKind/list", defaultColunms);
    table.setPaginationType("client");
    CoinKind.table = table.init();
});
