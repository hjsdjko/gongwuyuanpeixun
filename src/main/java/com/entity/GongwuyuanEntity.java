package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 在职公务员
 *
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("gongwuyuan")
public class GongwuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongwuyuanEntity() {

	}

	public GongwuyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 公务员姓名
     */
    @TableField(value = "gongwuyuan_name")

    private String gongwuyuanName;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 身份证号
     */
    @TableField(value = "gongwuyuan_id_number")

    private String gongwuyuanIdNumber;


    /**
     * 手机号
     */
    @TableField(value = "gongwuyuan_phone")

    private String gongwuyuanPhone;


    /**
     * 照片
     */
    @TableField(value = "gongwuyuan_photo")

    private String gongwuyuanPhoto;


    /**
     * 单位
     */
    @TableField(value = "gongwuyuan_types")

    private Integer gongwuyuanTypes;


    /**
     * 余额
     */
    @TableField(value = "new_money")

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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：公务员姓名
	 */
    public String getGongwuyuanName() {
        return gongwuyuanName;
    }


    /**
	 * 获取：公务员姓名
	 */

    public void setGongwuyuanName(String gongwuyuanName) {
        this.gongwuyuanName = gongwuyuanName;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：身份证号
	 */
    public String getGongwuyuanIdNumber() {
        return gongwuyuanIdNumber;
    }


    /**
	 * 获取：身份证号
	 */

    public void setGongwuyuanIdNumber(String gongwuyuanIdNumber) {
        this.gongwuyuanIdNumber = gongwuyuanIdNumber;
    }
    /**
	 * 设置：手机号
	 */
    public String getGongwuyuanPhone() {
        return gongwuyuanPhone;
    }


    /**
	 * 获取：手机号
	 */

    public void setGongwuyuanPhone(String gongwuyuanPhone) {
        this.gongwuyuanPhone = gongwuyuanPhone;
    }
    /**
	 * 设置：照片
	 */
    public String getGongwuyuanPhoto() {
        return gongwuyuanPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setGongwuyuanPhoto(String gongwuyuanPhoto) {
        this.gongwuyuanPhoto = gongwuyuanPhoto;
    }
    /**
	 * 设置：单位
	 */
    public Integer getGongwuyuanTypes() {
        return gongwuyuanTypes;
    }


    /**
	 * 获取：单位
	 */

    public void setGongwuyuanTypes(Integer gongwuyuanTypes) {
        this.gongwuyuanTypes = gongwuyuanTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Gongwuyuan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", gongwuyuanName=" + gongwuyuanName +
            ", sexTypes=" + sexTypes +
            ", gongwuyuanIdNumber=" + gongwuyuanIdNumber +
            ", gongwuyuanPhone=" + gongwuyuanPhone +
            ", gongwuyuanPhoto=" + gongwuyuanPhoto +
            ", gongwuyuanTypes=" + gongwuyuanTypes +
            ", newMoney=" + newMoney +
            ", createTime=" + createTime +
        "}";
    }
}
