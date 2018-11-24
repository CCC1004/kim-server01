package cn.stylefeng.guns.modular.system.model;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资源文件信息表
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@TableName("kim_resources")
public class KimResources extends Model<KimResources> {

    private static final long serialVersionUID = 1L;

    /**
     * 文件代码
     */
    @TableId("FILE_CD")
    private String fileCd;
    /**
     * 文件标题
     */
    @TableField("FILE_TITL")
    private String fileTitl;
    /**
     * 关键词
     */
    @TableField("KEY_WORD")
    private String keyWord;
    /**
     * 编制单位名称
     */
    @TableField("EST_ORG")
    private String estOrg;
    /**
     * 编制单位代码
     */
    @TableField("ORGCD")
    private String orgcd;
    /**
     * 编制人员
     */
    @TableField("EST_PERS")
    private String estPers;
    /**
     * 编制完成日期
     */
    @TableField("EST_DT")
    private Date estDt;
    /**
     * 发布单位名称
     */
    @TableField("PUB_ORG")
    private String pubOrg;
    /**
     * 发布单位代码
     */
    @TableField("PUB_ORGCD")
    private String pubOrgcd;
    /**
     * 发布日期
     */
    @TableField("PUB_DT")
    private Date pubDt;
    /**
     * 摘要信息
     */
    @TableField("ABS")
    private String abs;
    /**
     * 多媒体文件类型（1文档资料；2图片资料；3视音资料；4其他文件）
     */
    @TableField("MUL_TP")
    private String mulTp;
    /**
     * 文件路径
     */
    @TableField("FILE_PATH")
    private String filePath;
    /**
     * 文件名
     */
    @TableField("FILE_NM")
    private String fileNm;
    /**
     * 文件大小
     */
    @TableField("FILE_SIZE")
    private BigDecimal fileSize;
    /**
     * 文件扩展名
     */
    @TableField("FILE_EXT")
    private String fileExt;
    /**
     * 是否密件
     */
    @TableField("IS_SEC")
    private Integer isSec;
    /**
     * 密件等级（1：公开级 2：限制级 3：秘密级 4：机密级 5：绝密级）
     */
    @TableField("SEC_G")
    private String secG;
    /**
     * 资料类别
     */
    @TableField("DOC_TP")
    private String docTp;
    /**
     * 时间戳
     */
    @TableField("TS")
    private Date ts;
    /**
     * 备注
     */
    @TableField("NT")
    private String nt;


    public String getFileCd() {
        return fileCd;
    }

    public void setFileCd(String fileCd) {
        this.fileCd = fileCd;
    }

    public String getFileTitl() {
        return fileTitl;
    }

    public void setFileTitl(String fileTitl) {
        this.fileTitl = fileTitl;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getEstOrg() {
        return estOrg;
    }

    public void setEstOrg(String estOrg) {
        this.estOrg = estOrg;
    }

    public String getOrgcd() {
        return orgcd;
    }

    public void setOrgcd(String orgcd) {
        this.orgcd = orgcd;
    }

    public String getEstPers() {
        return estPers;
    }

    public void setEstPers(String estPers) {
        this.estPers = estPers;
    }

    public Date getEstDt() {
        return estDt;
    }

    public void setEstDt(Date estDt) {
        this.estDt = estDt;
    }

    public String getPubOrg() {
        return pubOrg;
    }

    public void setPubOrg(String pubOrg) {
        this.pubOrg = pubOrg;
    }

    public String getPubOrgcd() {
        return pubOrgcd;
    }

    public void setPubOrgcd(String pubOrgcd) {
        this.pubOrgcd = pubOrgcd;
    }

    public Date getPubDt() {
        return pubDt;
    }

    public void setPubDt(Date pubDt) {
        this.pubDt = pubDt;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getMulTp() {
        return mulTp;
    }

    public void setMulTp(String mulTp) {
        this.mulTp = mulTp;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileNm() {
        return fileNm;
    }

    public void setFileNm(String fileNm) {
        this.fileNm = fileNm;
    }

    public BigDecimal getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public Integer getIsSec() {
        return isSec;
    }

    public void setIsSec(Integer isSec) {
        this.isSec = isSec;
    }

    public String getSecG() {
        return secG;
    }

    public void setSecG(String secG) {
        this.secG = secG;
    }

    public String getDocTp() {
        return docTp;
    }

    public void setDocTp(String docTp) {
        this.docTp = docTp;
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

    @Override
    protected Serializable pkVal() {
        return this.fileCd;
    }

    @Override
    public String toString() {
        return "KimResources{" +
        ", fileCd=" + fileCd +
        ", fileTitl=" + fileTitl +
        ", keyWord=" + keyWord +
        ", estOrg=" + estOrg +
        ", orgcd=" + orgcd +
        ", estPers=" + estPers +
        ", estDt=" + estDt +
        ", pubOrg=" + pubOrg +
        ", pubOrgcd=" + pubOrgcd +
        ", pubDt=" + pubDt +
        ", abs=" + abs +
        ", mulTp=" + mulTp +
        ", filePath=" + filePath +
        ", fileNm=" + fileNm +
        ", fileSize=" + fileSize +
        ", fileExt=" + fileExt +
        ", isSec=" + isSec +
        ", secG=" + secG +
        ", docTp=" + docTp +
        ", ts=" + ts +
        ", nt=" + nt +
        "}";
    }
}
