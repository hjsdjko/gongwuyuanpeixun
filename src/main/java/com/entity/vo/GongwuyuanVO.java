package com.entity.vo;

import com.entity.GongwuyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 在职公务员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("gongwuyuan")
public class GongwuyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
    private Double gongwuyuanNewMoney;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：余额
	 */
    public Double getGongwuyuanNewMoney() {
        return gongwuyuanNewMoney;
    }


    /**
	 * 获取：余额
	 */

    public void setGongwuyuanNewMoney(Double gongwuyuanNewMoney) {
        this.gongwuyuanNewMoney = gongwuyuanNewMoney;
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

}
