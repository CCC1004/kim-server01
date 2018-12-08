/**
 * 精品分类管理初始化
 */
var CoinIndexJpfl = {
    id: "CoinIndexJpflTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CoinIndexJpfl.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键自增', field: 'guid', visible: false, align: 'center', valign: 'middle'},
            {title: '分类名称', field: 'flName', visible: true, align: 'center', valign: 'middle'},
            // {title: '分类图片', field: 'flImage', visible: true, align: 'center', valign: 'middle'},
            {title: '分类图片', field: 'filePath', visible: true, align: 'center', valign: 'middle', formatter: imgFormatter},
            {title: '分类描述', field: 'flDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '排序', field: 'flSort', visible: true, align: 'center', valign: 'middle'},
            {title: '是否显示', field: 'flStatus', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'nt', visible: true, align: 'center', valign: 'middle'},
            // {title: '时间戳', field: 'ts', visible: false, align: 'center', valign: 'middle'}
    ];
};

function imgFormatter(value,row,index){
    var str = '<div class="form-group" style="margin: 0px;padding: 0px;">\n' +
        '          <div class="col-sm-8">\n' +
        '               <div><img width="50px" height="50px" src="'+ Feng.ctxPath + value +'"></div>\n' +
        '          </div>\n' +
        '      </div>'
    return str;
}

/**
 * 检查是否选中
 */
CoinIndexJpfl.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CoinIndexJpfl.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加精品分类
 */
CoinIndexJpfl.openAddCoinIndexJpfl = function () {
    var index = layer.open({
        type: 2,
        title: '添加精品分类',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/coinIndexJpfl/coinIndexJpfl_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看精品分类详情
 */
CoinIndexJpfl.openCoinIndexJpflDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '精品分类详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/coinIndexJpfl/coinIndexJpfl_update/' + CoinIndexJpfl.seItem.guid
        });
        this.layerIndex = index;
    }
};

/**
 * 删除精品分类
 */
CoinIndexJpfl.delete = function () {
    if (this.check()) {
        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/coinIndexJpfl/delete", function (data) {
                Feng.success("删除成功!");
                CoinIndexJpfl.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("coinIndexJpflId",CoinIndexJpfl.seItem.guid);
            ajax.start();
        }
        Feng.confirm("是否刪除?", operation);
    }
};

/**
 * 查询精品分类列表
 */
CoinIndexJpfl.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CoinIndexJpfl.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CoinIndexJpfl.initColumn();
    var table = new BSTable(CoinIndexJpfl.id, "/coinIndexJpfl/list", defaultColunms);
    table.setPaginationType("server");
    CoinIndexJpfl.table = table.init();
});
