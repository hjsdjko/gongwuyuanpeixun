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
 * 在职培训课程
 *
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("zaizhikecheng")
public class ZaizhikechengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZaizhikechengEntity() {

	}

	public ZaizhikechengEntity(T t) {
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
     * 课程名称
     */
    @TableField(value = "zaizhikecheng_name")

    private String zaizhikechengName;


    /**
     * 预览视频
     */
    @TableField(value = "zaizhikecheng_video")

    private String zaizhikechengVideo;


    /**
     * 课程类型
     */
    @TableField(value = "zaizhikecheng_types")

    private Integer zaizhikechengTypes;


    /**
     * 课程图片
     */
    @TableField(value = "zaizhikecheng_photo")

    private String zaizhikechengPhoto;


    /**
     * 课程价格
     */
    @TableField(value = "zaizhikecheng_money")

    private Double zaizhikechengMoney;


    /**
     * 讲师
     */
    @TableField(value = "jiangshi_id")

    private Integer jiangshiId;


    /**
     * 课程详情
     */
    @TableField(value = "zaizhikecheng_content")

    private String zaizhikechengContent;


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
	 * 设置：课程名称
	 */
    public String getZaizhikechengName() {
        return zaizhikechengName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setZaizhikechengName(String zaizhikechengName) {
        this.zaizhikechengName = zaizhikechengName;
    }
    /**
	 * 设置：预览视频
	 */
    public String getZaizhikechengVideo() {
        return zaizhikechengVideo;
    }


    /**
	 * 获取：预览视频
	 */

    public void setZaizhikechengVideo(String zaizhikechengVideo) {
        this.zaizhikechengVideo = zaizhikechengVideo;
    }
    /**
	 * 设置：课程类型
	 */
    public Integer getZaizhikechengTypes() {
        return zaizhikechengTypes;
    }


    /**
	 * 获取：课程类型
	 */

    public void setZaizhikechengTypes(Integer zaizhikechengTypes) {
        this.zaizhikechengTypes = zaizhikechengTypes;
    }
    /**
	 * 设置：课程图片
	 */
    public String getZaizhikechengPhoto() {
        return zaizhikechengPhoto;
    }


    /**
	 * 获取：课程图片
	 */

    public void setZaizhikechengPhoto(String zaizhikechengPhoto) {
        this.zaizhikechengPhoto = zaizhikechengPhoto;
    }
    /**
	 * 设置：课程价格
	 */
    public Double getZaizhikechengMoney() {
        return zaizhikechengMoney;
    }


    /**
	 * 获取：课程价格
	 */

    public void setZaizhikechengMoney(Double zaizhikechengMoney) {
        this.zaizhikechengMoney = zaizhikechengMoney;
    }
    /**
	 * 设置：讲师
	 */
    public Integer getJiangshiId() {
        return jiangshiId;
    }


    /**
	 * 获取：讲师
	 */

    public void setJiangshiId(Integer jiangshiId) {
        this.jiangshiId = jiangshiId;
    }
    /**
	 * 设置：课程详情
	 */
    public String getZaizhikechengContent() {
        return zaizhikechengContent;
    }


    /**
	 * 获取：课程详情
	 */

    public void setZaizhikechengContent(String zaizhikechengContent) {
        this.zaizhikechengContent = zaizhikechengContent;
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
        return "Zaizhikecheng{" +
            "id=" + id +
            ", zaizhikechengName=" + zaizhikechengName +
            ", zaizhikechengVideo=" + zaizhikechengVideo +
            ", zaizhikechengTypes=" + zaizhikechengTypes +
            ", zaizhikechengPhoto=" + zaizhikechengPhoto +
            ", zaizhikechengMoney=" + zaizhikechengMoney +
            ", jiangshiId=" + jiangshiId +
            ", zaizhikechengContent=" + zaizhikechengContent +
            ", createTime=" + createTime +
        "}";
    }
}
