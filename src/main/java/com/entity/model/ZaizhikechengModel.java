package com.entity.model;

import com.entity.ZaizhikechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 在职培训课程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-07
 */
public class ZaizhikechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称
     */
    private String zaizhikechengName;


    /**
     * 预览视频
     */
    private String zaizhikechengVideo;


    /**
     * 课程类型
     */
    private Integer zaizhikechengTypes;


    /**
     * 课程图片
     */
    private String zaizhikechengPhoto;


    /**
     * 课程价格
     */
    private String zaizhikechengMoney;


    /**
     * 讲师
     */
    private Integer jiangshiId;


    /**
     * 课程详情
     */
    private String zaizhikechengContent;


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
    public String getZaizhikechengName() {
        return zaizhikechengName;
    }


    /**
	 * 设置：课程名称
	 */
    public void setZaizhikechengName(String zaizhikechengName) {
        this.zaizhikechengName = zaizhikechengName;
    }
    /**
	 * 获取：预览视频
	 */
    public String getZaizhikechengVideo() {
        return zaizhikechengVideo;
    }


    /**
	 * 设置：预览视频
	 */
    public void setZaizhikechengVideo(String zaizhikechengVideo) {
        this.zaizhikechengVideo = zaizhikechengVideo;
    }
    /**
	 * 获取：课程类型
	 */
    public Integer getZaizhikechengTypes() {
        return zaizhikechengTypes;
    }


    /**
	 * 设置：课程类型
	 */
    public void setZaizhikechengTypes(Integer zaizhikechengTypes) {
        this.zaizhikechengTypes = zaizhikechengTypes;
    }
    /**
	 * 获取：课程图片
	 */
    public String getZaizhikechengPhoto() {
        return zaizhikechengPhoto;
    }


    /**
	 * 设置：课程图片
	 */
    public void setZaizhikechengPhoto(String zaizhikechengPhoto) {
        this.zaizhikechengPhoto = zaizhikechengPhoto;
    }
    /**
	 * 获取：课程价格
	 */
    public String getZaizhikechengMoney() {
        return zaizhikechengMoney;
    }


    /**
	 * 设置：课程价格
	 */
    public void setZaizhikechengMoney(String zaizhikechengMoney) {
        this.zaizhikechengMoney = zaizhikechengMoney;
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
    public String getZaizhikechengContent() {
        return zaizhikechengContent;
    }


    /**
	 * 设置：课程详情
	 */
    public void setZaizhikechengContent(String zaizhikechengContent) {
        this.zaizhikechengContent = zaizhikechengContent;
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
