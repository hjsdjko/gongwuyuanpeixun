package com.entity.model;

import com.entity.BeikaokechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 备考课程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-07
 */
public class BeikaokechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String beikaokechengName;


    /**
     * 预览视频
     */
    private String beikaokechengVideo;


    /**
     * 课程图片
     */
    private String beikaokechengPhoto;


    /**
     * 课程价格
     */
    private String beikaokechengMoney;


    /**
     * 讲师
     */
    private Integer jiangshiId;


    /**
     * 课程详情
     */
    private String beikaokechengContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：课程名称
	 */
    public String getBeikaokechengName() {
        return beikaokechengName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setBeikaokechengName(String beikaokechengName) {
        this.beikaokechengName = beikaokechengName;
    }
    /**
	 * 获取：预览视频
	 */
    public String getBeikaokechengVideo() {
        return beikaokechengVideo;
    }


    /**
	 * 设置：预览视频
	 */
    public void setBeikaokechengVideo(String beikaokechengVideo) {
        this.beikaokechengVideo = beikaokechengVideo;
    }
    /**
	 * 获取：课程图片
	 */
    public String getBeikaokechengPhoto() {
        return beikaokechengPhoto;
    }


    /**
	 * 设置：课程图片
	 */
    public void setBeikaokechengPhoto(String beikaokechengPhoto) {
        this.beikaokechengPhoto = beikaokechengPhoto;
    }
    /**
	 * 获取：课程价格
	 */
    public String getBeikaokechengMoney() {
        return beikaokechengMoney;
    }


    /**
	 * 设置：课程价格
	 */
    public void setBeikaokechengMoney(String beikaokechengMoney) {
        this.beikaokechengMoney = beikaokechengMoney;
    }
    /**
	 * 获取：讲师
	 */
    public Integer getJiangshiId() {
        return jiangshiId;
    }


    /**
	 * 设置：讲师
	 */
    public void setJiangshiId(Integer jiangshiId) {
        this.jiangshiId = jiangshiId;
    }
    /**
	 * 获取：课程详情
	 */
    public String getBeikaokechengContent() {
        return beikaokechengContent;
    }


    /**
	 * 设置：课程详情
	 */
    public void setBeikaokechengContent(String beikaokechengContent) {
        this.beikaokechengContent = beikaokechengContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
