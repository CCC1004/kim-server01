/**
 * 轮播图管理初始化
 */
var CoinIndexLb = {
    id: "CoinIndexLbTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CoinIndexLb.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '主键自增', field: 'guid', visible: false, align: 'center', valign: 'middle'},
        {title: '轮播页名称', field: 'lbName', visible: true, align: 'center', valign: 'middle'},
        {title: '轮播图片id', field: 'lbImage', visible: true, align: 'center', valign: 'middle'},
        {title: '排序', field: 'lbSort', visible: true, align: 'center', valign: 'middle'},
        {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
        {title: '是否显示', field: 'lbStatus', visible: true, align: 'center', valign: 'middle'},
        {title: '时间戳', field: 'ts', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CoinIndexLb.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CoinIndexLb.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加轮播图
 */
CoinIndexLb.openAddCoinIndexLb = function () {
    var index = layer.open({
        type: 2,
        title: '添加轮播图',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/coinIndexLb/coinIndexLb_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看轮播图详情
 */
CoinIndexLb.openCoinIndexLbDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '轮播图详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/coinIndexLb/coinIndexLb_update/' + CoinIndexLb.seItem.guid
        });
        this.layerIndex = index;
    }
};

/**
 * 删除轮播图
 */
CoinIndexLb.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/coinIndexLb/delete", function (data) {
                Feng.success("删除成功!");
                CoinIndexLb.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("coinIndexLbId",CoinIndexLb.seItem.guid);
            ajax.start();
        }
        Feng.confirm("是否刪除?", operation);
    }
};

/**
 * 查询轮播图列表
 */
CoinIndexLb.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CoinIndexLb.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CoinIndexLb.initColumn();
    var table = new BSTable(CoinIndexLb.id, "/coinIndexLb/list", defaultColunms);
    table.setPaginationType("client");
    CoinIndexLb.table = table.init();
});
