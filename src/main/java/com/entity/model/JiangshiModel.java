package com.entity.model;

import com.entity.JiangshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 讲师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-07
 */
public class JiangshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 讲师名称
     */
    private String jiangshiName;


    /**
     * 讲师性别
     */
    private Integer sexTypes;


    /**
     * 讲师头像
     */
    private String jiangshiPhoto;


    /**
     * 讲师联系方式
     */
    private String jiangshiPhone;


    /**
     * 讲师薪资
     */
    private Double jiangshiMoney;


    /**
     * 讲师详情
     */
    private String jiangshiContent;


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
	 * 获取：讲师名称
	 */
    public String getJiangshiName() {
        return jiangshiName;
    }


    /**
	 * 设置：讲师名称
	 */
    public void setJiangshiName(String jiangshiName) {
        this.jiangshiName = jiangshiName;
    }
    /**
	 * 获取：讲师性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：讲师性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：讲师头像
	 */
    public String getJiangshiPhoto() {
        return jiangshiPhoto;
    }


    /**
	 * 设置：讲师头像
	 */
    public void setJiangshiPhoto(String jiangshiPhoto) {
        this.jiangshiPhoto = jiangshiPhoto;
    }
    /**
	 * 获取：讲师联系方式
	 */
    public String getJiangshiPhone() {
        return jiangshiPhone;
    }


    /**
	 * 设置：讲师联系方式
	 */
    public void setJiangshiPhone(String jiangshiPhone) {
        this.jiangshiPhone = jiangshiPhone;
    }
    /**
	 * 获取：讲师薪资
	 */
    public Double getJiangshiMoney() {
        return jiangshiMoney;
    }


    /**
	 * 设置：讲师薪资
	 */
    public void setJiangshiMoney(Double jiangshiMoney) {
        this.jiangshiMoney = jiangshiMoney;
    }
    /**
	 * 获取：讲师详情
	 */
    public String getJiangshiContent() {
        return jiangshiContent;
    }


    /**
	 * 设置：讲师详情
	 */
    public void setJiangshiContent(String jiangshiContent) {
        this.jiangshiContent = jiangshiContent;
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
