package cn.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * kim小程序用户表
 * </p>
 *
 * @author superc
 * @since 2018-12-02
 */
@TableName("kim_user")
public class KimUser extends Model<KimUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String uuid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别（0女1男2保密）
     */
    private String sex;
    /**
     * 职业类型(1：Java开发 2：前端开发 3：大数据开发 4：ios开发 5：Android开发 10：学生 11：其它)
     */
    private String job;
    /**
     * 真实姓名
     */
    private String realname;
    /**
     * 头像地址（资源表主键）
     */
    private String faceImage;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 微信登录id
     */
    private String openid;
    /**
     * 备注
     */
    private String nt;
    /**
     * 时间戳
     */
    private Date ts;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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
        return this.uuid;
    }

    @Override
    public String toString() {
        return "KimUser{" +
        ", uuid=" + uuid +
        ", username=" + username +
        ", password=" + password +
        ", age=" + age +
        ", sex=" + sex +
        ", job=" + job +
        ", realname=" + realname +
        ", faceImage=" + faceImage +
        ", province=" + province +
        ", city=" + city +
        ", district=" + district +
        ", address=" + address +
        ", openid=" + openid +
        ", nt=" + nt +
        ", ts=" + ts +
        "}";
    }
}
