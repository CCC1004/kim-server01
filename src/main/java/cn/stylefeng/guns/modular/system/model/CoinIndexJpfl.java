package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 精品分类表
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
@TableName("coin_index_jpfl")
public class CoinIndexJpfl extends Model<CoinIndexJpfl> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    private String guid;
    /**
     * 分类名称
     */
    @TableField("fl_name")
    private String flName;
    /**
     * 分类图片id(与资源信息主键匹配)
     */
    @TableField("fl_image")
    private String flImage;
    /**
     * 分类描述
     */
    @TableField("fl_desc")
    private String flDesc;
    /**
     * 排序
     */
    @TableField("fl_sort")
    private String flSort;
    /**
     * 是否显示（1显示；2不显示）
     */
    @TableField("fl_status")
    private String flStatus;
    /**
     * 备注
     */
    private String nt;
    /**
     * 时间戳
     */
    private Date ts;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    public String getFlImage() {
        return flImage;
    }

    public void setFlImage(String flImage) {
        this.flImage = flImage;
    }

    public String getFlDesc() {
        return flDesc;
    }

    public void setFlDesc(String flDesc) {
        this.flDesc = flDesc;
    }

    public String getFlSort() {
        return flSort;
    }

    public void setFlSort(String flSort) {
        this.flSort = flSort;
    }

    public String getFlStatus() {
        return flStatus;
    }

    public void setFlStatus(String flStatus) {
        this.flStatus = flStatus;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Override
    protected Serializable pkVal() {
        return this.guid;
    }

    @Override
    public String toString() {
        return "CoinIndexJpfl{" +
        ", guid=" + guid +
        ", flName=" + flName +
        ", flImage=" + flImage +
        ", flDesc=" + flDesc +
        ", flSort=" + flSort +
        ", flStatus=" + flStatus +
        ", nt=" + nt +
        ", ts=" + ts +
        "}";
    }
}
