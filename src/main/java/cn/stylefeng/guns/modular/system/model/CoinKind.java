package cn.stylefeng.guns.modular.system.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 品种信息表
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-08
 */
@TableName("coin_kind")
public class CoinKind extends Model<CoinKind> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键uuid
     */
    @TableId("GUID")
    private String guid;
    /**
     * 品种名称
     */
    @TableField("kind_name")
    private String kindName;
    /**
     * 面值
     */
    @TableField("kind_value")
    private String kindValue;
    /**
     * 品种描述
     */
    @TableField("kind_desc")
    private String kindDesc;
    /**
     * 发行机构
     */
    @TableField("kind_org")
    private String kindOrg;
    /**
     * 正面
     */
    @TableField("kind_head")
    private String kindHead;
    /**
     * 背面
     */
    @TableField("kind_tail")
    private String kindTail;
    /**
     * 精品分类id
     */
    @TableField("fl_id")
    private String flId;
    /**
     * 发行日期
     */
    @TableField("issue_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date issueTime;
    /**
     * 发行量
     */
    @TableField("issue_size")
    private String issueSize;
    /**
     * 规格
     */
    @TableField("kind_size")
    private String kindSize;
    /**
     * 材质
     */
    @TableField("kind_material")
    private String kindMaterial;
    /**
     * 品种包装
     */
    @TableField("kind_packing")
    private String kindPacking;
    /**
     * 目前价格下限
     */
    @TableField("now_prise_down")
    private BigDecimal nowPriseDown;
    /**
     * 目前价格上限
     */
    @TableField("now_prise_up")
    private BigDecimal nowPriseUp;
    /**
     * 品种图片1（与资源表id关联）
     */
    @TableField("kind_image")
    private String kindImage;
    /**
     * 品种图片2
     */
    @TableField("kind_image2")
    private String kindImage2;
    /**
     * 品种图片3
     */
    @TableField("kind_image3")
    private String kindImage3;
    /**
     * 品种图片4
     */
    @TableField("kind_image4")
    private String kindImage4;
    /**
     * 排序
     */
    @TableField("kind_sort")
    private String kindSort;
    /**
     * 时间戳
     */
    private Date ts;
    /**
     * 备注
     */
    private String nt;


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getKindValue() {
        return kindValue;
    }

    public void setKindValue(String kindValue) {
        this.kindValue = kindValue;
    }

    public String getKindDesc() {
        return kindDesc;
    }

    public void setKindDesc(String kindDesc) {
        this.kindDesc = kindDesc;
    }

    public String getFlId() {
        return flId;
    }

    public void setFlId(String flId) {
        this.flId = flId;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(String issueSize) {
        this.issueSize = issueSize;
    }

    public String getKindSize() {
        return kindSize;
    }

    public void setKindSize(String kindSize) {
        this.kindSize = kindSize;
    }

    public String getKindMaterial() {
        return kindMaterial;
    }

    public void setKindMaterial(String kindMaterial) {
        this.kindMaterial = kindMaterial;
    }

    public String getKindPacking() {
        return kindPacking;
    }

    public void setKindPacking(String kindPacking) {
        this.kindPacking = kindPacking;
    }

    public BigDecimal getNowPriseDown() {
        return nowPriseDown;
    }

    public void setNowPriseDown(BigDecimal nowPriseDown) {
        this.nowPriseDown = nowPriseDown;
    }

    public BigDecimal getNowPriseUp() {
        return nowPriseUp;
    }

    public void setNowPriseUp(BigDecimal nowPriseUp) {
        this.nowPriseUp = nowPriseUp;
    }

    public String getKindImage() {
        return kindImage;
    }

    public void setKindImage(String kindImage) {
        this.kindImage = kindImage;
    }

    public String getKindImage2() {
        return kindImage2;
    }

    public void setKindImage2(String kindImage2) {
        this.kindImage2 = kindImage2;
    }

    public String getKindImage3() {
        return kindImage3;
    }

    public void setKindImage3(String kindImage3) {
        this.kindImage3 = kindImage3;
    }

    public String getKindImage4() {
        return kindImage4;
    }

    public void setKindImage4(String kindImage4) {
        this.kindImage4 = kindImage4;
    }

    public String getKindSort() {
        return kindSort;
    }

    public void setKindSort(String kindSort) {
        this.kindSort = kindSort;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public String getKindHead() {
        return kindHead;
    }

    public void setKindHead(String kindHead) {
        this.kindHead = kindHead;
    }

    public String getKindTail() {
        return kindTail;
    }

    public void setKindTail(String kindTail) {
        this.kindTail = kindTail;
    }

    public String getKindOrg() {
        return kindOrg;
    }

    public void setKindOrg(String kindOrg) {
        this.kindOrg = kindOrg;
    }

    @Override
    protected Serializable pkVal() {
        return this.guid;
    }

    @Override
    public String toString() {
        return "CoinKind{" +
                "guid='" + guid + '\'' +
                ", kindName='" + kindName + '\'' +
                ", kindValue='" + kindValue + '\'' +
                ", kindDesc='" + kindDesc + '\'' +
                ", kindOrg='" + kindOrg + '\'' +
                ", kindHead='" + kindHead + '\'' +
                ", kindTail='" + kindTail + '\'' +
                ", flId='" + flId + '\'' +
                ", issueTime=" + issueTime +
                ", issueSize='" + issueSize + '\'' +
                ", kindSize='" + kindSize + '\'' +
                ", kindMaterial='" + kindMaterial + '\'' +
                ", kindPacking='" + kindPacking + '\'' +
                ", nowPriseDown=" + nowPriseDown +
                ", nowPriseUp=" + nowPriseUp +
                ", kindImage='" + kindImage + '\'' +
                ", kindImage2='" + kindImage2 + '\'' +
                ", kindImage3='" + kindImage3 + '\'' +
                ", kindImage4='" + kindImage4 + '\'' +
                ", kindSort='" + kindSort + '\'' +
                ", ts=" + ts +
                ", nt='" + nt + '\'' +
                '}';
    }
}
