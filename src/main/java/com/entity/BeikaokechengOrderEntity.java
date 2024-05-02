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
 * 备考课程预定
 *
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("beikaokecheng_order")
public class BeikaokechengOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BeikaokechengOrderEntity() {

	}

	public BeikaokechengOrderEntity(T t) {
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
     * 预定人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预定课程
     */
    @TableField(value = "beikaokecheng_id")

    private Integer beikaokechengId;


    /**
     * 预定时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：预定人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：预定人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预定课程
	 */
    public Integer getBeikaokechengId() {
        return beikaokechengId;
    }


    /**
	 * 获取：预定课程
	 */

    public void setBeikaokechengId(Integer beikaokechengId) {
        this.beikaokechengId = beikaokechengId;
    }
    /**
	 * 设置：预定时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：预定时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "BeikaokechengOrder{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", beikaokechengId=" + beikaokechengId +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
