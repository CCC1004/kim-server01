/**
 * 初始化品种信息详情对话框
 */
var CoinKindInfoDlg = {
    coinKindInfoData : {},
    validateFields: {
        kindName: {
            validators: {
                notEmpty: {
                    message: '品种名称不能为空'
                },

            }
        },
        kindValue: {
            validators: {
                notEmpty: {
                    message: '面值不能为空'
                },
                stringLength: {
                    min: 0,
                    max: 10,
                    message: '长度必须在0到10位之间'
                },
            }
        },
        flId: {
            validators: {
                notEmpty: {
                    message: '精品分类不能为空'
                },
            }
        },
        flId: {
            validators: {
                notEmpty: {
                    message: '精品分类不能为空'
                },
            }
        },
        issueTime: {
            validators: {
                notEmpty: {
                    message: '发行日期不能为空'
                },
            }
        },
        issueSize: {
            validators: {
                notEmpty: {
                    message: '发行量不能为空'
                },
            }
        },

    }
};

/**
 * 清除数据
 */
CoinKindInfoDlg.clearData = function() {
    this.coinKindInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinKindInfoDlg.set = function(key, val) {
    this.coinKindInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CoinKindInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CoinKindInfoDlg.close = function() {
    parent.layer.close(window.parent.CoinKind.layerIndex);
}

/**
 * 收集数据
 */
CoinKindInfoDlg.collectData = function() {
    this
    .set('guid')
    .set('kindName')
    .set('kindValue')
    .set('kindDesc')
    .set('flId')
    .set('issueTime')
    .set('issueSize')
    .set('kindSize')
    .set('kindMaterial')
    .set('kindPacking')
    .set('nowPriseDown')
    .set('nowPriseUp')
    .set('kindImage')
    .set('kindImage2')
    .set('kindImage3')
    .set('kindImage4')
    .set('ts')
    .set('nt');
}

/**
 * 提交添加
 */
CoinKindInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    //验证
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinKind/add", function(data){
        Feng.success("添加成功!");
        window.parent.CoinKind.table.refresh();
        CoinKindInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinKindInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CoinKindInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();
    //验证
    if (!this.validate()) {
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/coinKind/update", function(data){
        Feng.success("修改成功!");
        window.parent.CoinKind.table.refresh();
        CoinKindInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.coinKindInfoData);
    ajax.start();
}

/**
 * 验证数据是否为空
 */
CoinKindInfoDlg.validate = function () {
    $('#coinKindInfo').data("bootstrapValidator").resetForm();
    $('#coinKindInfo').bootstrapValidator('validate');
    return $("#coinKindInfo").data('bootstrapValidator').isValid();
}

$(function() {

    //验证
    Feng.initValidator("coinKindInfo", CoinKindInfoDlg.validateFields);

});
