package com.entity.view;

import com.entity.BeikaokechengOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 备考课程预定
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-07
 */
@TableName("beikaokecheng_order")
public class BeikaokechengOrderView extends BeikaokechengOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 beikaokecheng
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

		//级联表 yonghu
			/**
			* 考生姓名
			*/
			private String yonghuName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 学校
			*/
			private String yonghuXuexiao;
			/**
			* 专业
			*/
			private String yonghuZhuanye;
			/**
			* 余额
			*/
			private Double yonghuNewMoney;

	public BeikaokechengOrderView() {

	}

	public BeikaokechengOrderView(BeikaokechengOrderEntity beikaokechengOrderEntity) {
		try {
			BeanUtils.copyProperties(this, beikaokechengOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}








				//级联表的get和set beikaokecheng
					/**
					* 获取： 课程名称
					*/
					public String getBeikaokechengName() {
						return beikaokechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setBeikaokechengName(String beikaokechengName) {
						this.beikaokechengName = beikaokechengName;
					}
					/**
					* 获取： 预览视频
					*/
					public String getBeikaokechengVideo() {
						return beikaokechengVideo;
					}
					/**
					* 设置： 预览视频
					*/
					public void setBeikaokechengVideo(String beikaokechengVideo) {
						this.beikaokechengVideo = beikaokechengVideo;
					}
					/**
					* 获取： 课程图片
					*/
					public String getBeikaokechengPhoto() {
						return beikaokechengPhoto;
					}
					/**
					* 设置： 课程图片
					*/
					public void setBeikaokechengPhoto(String beikaokechengPhoto) {
						this.beikaokechengPhoto = beikaokechengPhoto;
					}
					/**
					* 获取： 课程价格
					*/
					public String getBeikaokechengMoney() {
						return beikaokechengMoney;
					}
					/**
					* 设置： 课程价格
					*/
					public void setBeikaokechengMoney(String beikaokechengMoney) {
						this.beikaokechengMoney = beikaokechengMoney;
					}
					/**
					* 获取： 讲师
					*/
					public Integer getJiangshiId() {
						return jiangshiId;
					}
					/**
					* 设置： 讲师
					*/
					public void setJiangshiId(Integer jiangshiId) {
						this.jiangshiId = jiangshiId;
					}
					/**
					* 获取： 课程详情
					*/
					public String getBeikaokechengContent() {
						return beikaokechengContent;
					}
					/**
					* 设置： 课程详情
					*/
					public void setBeikaokechengContent(String beikaokechengContent) {
						this.beikaokechengContent = beikaokechengContent;
					}

















				//级联表的get和set yonghu
					/**
					* 获取： 考生姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 考生姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 学校
					*/
					public String getYonghuXuexiao() {
						return yonghuXuexiao;
					}
					/**
					* 设置： 学校
					*/
					public void setYonghuXuexiao(String yonghuXuexiao) {
						this.yonghuXuexiao = yonghuXuexiao;
					}
					/**
					* 获取： 专业
					*/
					public String getYonghuZhuanye() {
						return yonghuZhuanye;
					}
					/**
					* 设置： 专业
					*/
					public void setYonghuZhuanye(String yonghuZhuanye) {
						this.yonghuZhuanye = yonghuZhuanye;
					}
					/**
					* 获取： 余额
					*/
					public Double getYonghuNewMoney() {
						return yonghuNewMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setYonghuNewMoney(Double yonghuNewMoney) {
						this.yonghuNewMoney = yonghuNewMoney;
					}










}
