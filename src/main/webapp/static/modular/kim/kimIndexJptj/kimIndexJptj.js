/**
 * 精品推荐管理初始化
 */
var KimIndexJptj = {
    id: "KimIndexJptjTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
KimIndexJptj.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键自增', field: 'guid', visible: false, align: 'center', valign: 'middle'},
            {title: '精品名称', field: 'jpName', visible: true, align: 'center', valign: 'middle'},
            {title: '精品图片id', field: 'jpImage', visible: false, align: 'center', valign: 'middle'},
            {title: '精品描述', field: 'jpDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'jpSort', visible: true, align: 'center', valign: 'middle'},
            {title: '是否显示', field: 'jpStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
            {title: '时间戳', field: 'ts', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
KimIndexJptj.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        KimIndexJptj.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加精品推荐
 */
KimIndexJptj.openAddKimIndexJptj = function () {
    var index = layer.open({
        type: 2,
        title: '添加精品推荐',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/kimIndexJptj/kimIndexJptj_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看精品推荐详情
 */
KimIndexJptj.openKimIndexJptjDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '精品推荐详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/kimIndexJptj/kimIndexJptj_update/' + KimIndexJptj.seItem.guid
        });
        this.layerIndex = index;
    }
};

/**
 * 删除精品推荐
 */
KimIndexJptj.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/kimIndexJptj/delete", function (data) {
            Feng.success("删除成功!");
            KimIndexJptj.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("kimIndexJptjId",this.seItem.guid);
        ajax.start();
    }
};

/**
 * 查询精品推荐列表
 */
KimIndexJptj.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    KimIndexJptj.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = KimIndexJptj.initColumn();
    var table = new BSTable(KimIndexJptj.id, "/kimIndexJptj/list", defaultColunms);
    table.setPaginationType("client");
    KimIndexJptj.table = table.init();
});
