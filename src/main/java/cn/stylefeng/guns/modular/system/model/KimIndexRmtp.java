package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 热门图片信息
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@TableName("kim_index_rmtp")
public class KimIndexRmtp extends Model<KimIndexRmtp> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId("GUID")
    private String guid;
    /**
     * 热门名称
     */
    @TableField("rm_name")
    private String rmName;
    /**
     * 热门图片id(与资源信息主键匹配)
     */
    @TableField("rm_image")
    private String rmImage;
    /**
     * 头像图片id(与资源信息主键匹配)
     */
    @TableField("rm_head_img")
    private String rmHeadImg;
    /**
     * 标题
     */
    @TableField("rm_title")
    private String rmTitle;
    /**
     * 内容
     */
    @TableField("rm_context")
    private String rmContext;
    /**
     * 排序
     */
    @TableField("rm_sort")
    private String rmSort;
    /**
     * 状态/是否显示（1显示；2不显示）
     */
    @TableField("rm_status")
    private String rmStatus;
    /**
     * 备注
     */
    @TableField("NT")
    private String nt;
    /**
     * 时间戳
     */
    @TableField("TS")
    private Date ts;


    public String getRmStatus() {
        return rmStatus;
    }

    public void setRmStatus(String rmStatus) {
        this.rmStatus = rmStatus;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmImage() {
        return rmImage;
    }

    public void setRmImage(String rmImage) {
        this.rmImage = rmImage;
    }

    public String getRmHeadImg() {
        return rmHeadImg;
    }

    public void setRmHeadImg(String rmHeadImg) {
        this.rmHeadImg = rmHeadImg;
    }

    public String getRmTitle() {
        return rmTitle;
    }

    public void setRmTitle(String rmTitle) {
        this.rmTitle = rmTitle;
    }

    public String getRmContext() {
        return rmContext;
    }

    public void setRmContext(String rmContext) {
        this.rmContext = rmContext;
    }

    public String getRmSort() {
        return rmSort;
    }

    public void setRmSort(String rmSort) {
        this.rmSort = rmSort;
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
        return "KimIndexRmtp{" +
                "guid='" + guid + '\'' +
                ", rmName='" + rmName + '\'' +
                ", rmImage='" + rmImage + '\'' +
                ", rmHeadImg='" + rmHeadImg + '\'' +
                ", rmTitle='" + rmTitle + '\'' +
                ", rmContext='" + rmContext + '\'' +
                ", rmSort='" + rmSort + '\'' +
                ", rmStatus='" + rmStatus + '\'' +
                ", nt='" + nt + '\'' +
                ", ts=" + ts +
                '}';
    }
}
