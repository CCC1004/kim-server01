package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 精品推荐表
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@TableName("kim_index_jptj")
public class KimIndexJptj extends Model<KimIndexJptj> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    private String guid;
    /**
     * 精品名称
     */
    @TableField("jp_name")
    private String jpName;
    /**
     * 精品图片id(与资源信息主键匹配)
     */
    @TableField("jp_image")
    private String jpImage;
    /**
     * 精品描述
     */
    @TableField("jp_desc")
    private String jpDesc;
    /**
     * 排序
     */
    @TableField("jp_sort")
    private String jpSort;
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

    public String getJpName() {
        return jpName;
    }

    public void setJpName(String jpName) {
        this.jpName = jpName;
    }

    public String getJpImage() {
        return jpImage;
    }

    public void setJpImage(String jpImage) {
        this.jpImage = jpImage;
    }

    public String getJpDesc() {
        return jpDesc;
    }

    public void setJpDesc(String jpDesc) {
        this.jpDesc = jpDesc;
    }

    public String getJpSort() {
        return jpSort;
    }

    public void setJpSort(String jpSort) {
        this.jpSort = jpSort;
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
        return "KimIndexJptj{" +
        ", guid=" + guid +
        ", jpName=" + jpName +
        ", jpImage=" + jpImage +
        ", jpDesc=" + jpDesc +
        ", jpSort=" + jpSort +
        ", nt=" + nt +
        ", ts=" + ts +
        "}";
    }
}
