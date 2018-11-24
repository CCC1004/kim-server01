package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 轮播图信息
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@TableName("kim_index_lb")
public class KimIndexLb extends Model<KimIndexLb> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    private String guid;
    /**
     * 轮播页名称
     */
    @TableField("lb_name")
    private String lbName;
    /**
     * 轮播图片id(与资源信息主键匹配)
     */
    @TableField("lb_image")
    private String lbImage;
    /**
     * 排序
     */
    @TableField("lb_sort")
    private String lbSort;
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

    public String getLbName() {
        return lbName;
    }

    public void setLbName(String lbName) {
        this.lbName = lbName;
    }

    public String getLbImage() {
        return lbImage;
    }

    public void setLbImage(String lbImage) {
        this.lbImage = lbImage;
    }

    public String getLbSort() {
        return lbSort;
    }

    public void setLbSort(String lbSort) {
        this.lbSort = lbSort;
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
        return "KimIndexLb{" +
        ", guid=" + guid +
        ", lbName=" + lbName +
        ", lbImage=" + lbImage +
        ", lbSort=" + lbSort +
        ", nt=" + nt +
        ", ts=" + ts +
        "}";
    }
}
