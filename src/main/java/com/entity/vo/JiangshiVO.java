package com.entity.vo;

import com.entity.JiangshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 讲师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("jiangshi")
public class JiangshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
