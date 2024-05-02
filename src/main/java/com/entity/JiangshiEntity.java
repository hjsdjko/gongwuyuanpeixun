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
 * 讲师
 *
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("jiangshi")
public class JiangshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiangshiEntity() {

	}

	public JiangshiEntity(T t) {
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
     * 讲师名称
     */
    @TableField(value = "jiangshi_name")

    private String jiangshiName;


    /**
     * 讲师性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 讲师头像
     */
    @TableField(value = "jiangshi_photo")

    private String jiangshiPhoto;


    /**
     * 讲师联系方式
     */
    @TableField(value = "jiangshi_phone")

    private String jiangshiPhone;


    /**
     * 讲师薪资
     */
    @TableField(value = "jiangshi_money")

    private Double jiangshiMoney;


    /**
     * 讲师详情
     */
    @TableField(value = "jiangshi_content")

    private String jiangshiContent;


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
	 * 设置：讲师名称
	 */
    public String getJiangshiName() {
        return jiangshiName;
    }


    /**
	 * 获取：讲师名称
	 */

    public void setJiangshiName(String jiangshiName) {
        this.jiangshiName = jiangshiName;
    }
    /**
	 * 设置：讲师性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：讲师性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：讲师头像
	 */
    public String getJiangshiPhoto() {
        return jiangshiPhoto;
    }


    /**
	 * 获取：讲师头像
	 */

    public void setJiangshiPhoto(String jiangshiPhoto) {
        this.jiangshiPhoto = jiangshiPhoto;
    }
    /**
	 * 设置：讲师联系方式
	 */
    public String getJiangshiPhone() {
        return jiangshiPhone;
    }


    /**
	 * 获取：讲师联系方式
	 */

    public void setJiangshiPhone(String jiangshiPhone) {
        this.jiangshiPhone = jiangshiPhone;
    }
    /**
	 * 设置：讲师薪资
	 */
    public Double getJiangshiMoney() {
        return jiangshiMoney;
    }


    /**
	 * 获取：讲师薪资
	 */

    public void setJiangshiMoney(Double jiangshiMoney) {
        this.jiangshiMoney = jiangshiMoney;
    }
    /**
	 * 设置：讲师详情
	 */
    public String getJiangshiContent() {
        return jiangshiContent;
    }


    /**
	 * 获取：讲师详情
	 */

    public void setJiangshiContent(String jiangshiContent) {
        this.jiangshiContent = jiangshiContent;
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
        return "Jiangshi{" +
            "id=" + id +
            ", jiangshiName=" + jiangshiName +
            ", sexTypes=" + sexTypes +
            ", jiangshiPhoto=" + jiangshiPhoto +
            ", jiangshiPhone=" + jiangshiPhone +
            ", jiangshiMoney=" + jiangshiMoney +
            ", jiangshiContent=" + jiangshiContent +
            ", createTime=" + createTime +
        "}";
    }
}
