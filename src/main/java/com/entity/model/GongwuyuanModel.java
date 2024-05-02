package com.entity.model;

import com.entity.GongwuyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 在职公务员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-07
 */
public class GongwuyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 公务员姓名
     */
    private String gongwuyuanName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 身份证号
     */
    private String gongwuyuanIdNumber;


    /**
     * 手机号
     */
    private String gongwuyuanPhone;


    /**
     * 照片
     */
    private String gongwuyuanPhoto;


    /**
     * 单位
     */
    private Integer gongwuyuanTypes;


    /**
     * 余额
     */
    private Double newMoney;

    public Double getNewMoney() {
        return newMoney;
    }

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }

    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：公务员姓名
	 */
    public String getGongwuyuanName() {
        return gongwuyuanName;
    }


    /**
	 * 设置：公务员姓名
	 */
    public void setGongwuyuanName(String gongwuyuanName) {
        this.gongwuyuanName = gongwuyuanName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getGongwuyuanIdNumber() {
        return gongwuyuanIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setGongwuyuanIdNumber(String gongwuyuanIdNumber) {
        this.gongwuyuanIdNumber = gongwuyuanIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getGongwuyuanPhone() {
        return gongwuyuanPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setGongwuyuanPhone(String gongwuyuanPhone) {
        this.gongwuyuanPhone = gongwuyuanPhone;
    }
    /**
	 * 获取：照片
	 */
    public String getGongwuyuanPhoto() {
        return gongwuyuanPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setGongwuyuanPhoto(String gongwuyuanPhoto) {
        this.gongwuyuanPhoto = gongwuyuanPhoto;
    }
    /**
	 * 获取：单位
	 */
    public Integer getGongwuyuanTypes() {
        return gongwuyuanTypes;
    }


    /**
	 * 设置：单位
	 */
    public void setGongwuyuanTypes(Integer gongwuyuanTypes) {
        this.gongwuyuanTypes = gongwuyuanTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
