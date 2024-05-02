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
 * 备考课程
 *
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("beikaokecheng")
public class BeikaokechengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BeikaokechengEntity() {

	}

	public BeikaokechengEntity(T t) {
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
    @TableField(value = "beikaokecheng_name")

    private String beikaokechengName;


    /**
     * 预览视频
     */
    @TableField(value = "beikaokecheng_video")

    private String beikaokechengVideo;


    /**
     * 课程图片
     */
    @TableField(value = "beikaokecheng_photo")

    private String beikaokechengPhoto;


    /**
     * 课程价格
     */
    @TableField(value = "beikaokecheng_money")

    private Double beikaokechengMoney;


    /**
     * 讲师
     */
    @TableField(value = "jiangshi_id")

    private Integer jiangshiId;


    /**
     * 课程详情
     */
    @TableField(value = "beikaokecheng_content")

    private String beikaokechengContent;


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
    public String getBeikaokechengName() {
        return beikaokechengName;
    }


    /**
	 * 获取：课程名称
	 */

    public void setBeikaokechengName(String beikaokechengName) {
        this.beikaokechengName = beikaokechengName;
    }
    /**
	 * 设置：预览视频
	 */
    public String getBeikaokechengVideo() {
        return beikaokechengVideo;
    }


    /**
	 * 获取：预览视频
	 */

    public void setBeikaokechengVideo(String beikaokechengVideo) {
        this.beikaokechengVideo = beikaokechengVideo;
    }
    /**
	 * 设置：课程图片
	 */
    public String getBeikaokechengPhoto() {
        return beikaokechengPhoto;
    }


    /**
	 * 获取：课程图片
	 */

    public void setBeikaokechengPhoto(String beikaokechengPhoto) {
        this.beikaokechengPhoto = beikaokechengPhoto;
    }
    /**
	 * 设置：课程价格
	 */
    public Double getBeikaokechengMoney() {
        return beikaokechengMoney;
    }


    /**
	 * 获取：课程价格
	 */

    public void setBeikaokechengMoney(Double beikaokechengMoney) {
        this.beikaokechengMoney = beikaokechengMoney;
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
    public String getBeikaokechengContent() {
        return beikaokechengContent;
    }


    /**
	 * 获取：课程详情
	 */

    public void setBeikaokechengContent(String beikaokechengContent) {
        this.beikaokechengContent = beikaokechengContent;
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
        return "Beikaokecheng{" +
            "id=" + id +
            ", beikaokechengName=" + beikaokechengName +
            ", beikaokechengVideo=" + beikaokechengVideo +
            ", beikaokechengPhoto=" + beikaokechengPhoto +
            ", beikaokechengMoney=" + beikaokechengMoney +
            ", jiangshiId=" + jiangshiId +
            ", beikaokechengContent=" + beikaokechengContent +
            ", createTime=" + createTime +
        "}";
    }
}
