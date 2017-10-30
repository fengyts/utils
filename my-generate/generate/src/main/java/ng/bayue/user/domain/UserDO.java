package ng.bayue.user.domain;

import ng.bayue.common.BaseDO;

import java.util.Date;

/**
* 
* @author fengyts Mon Oct 30 23:01:45 CST 2017
*/

public class UserDO extends BaseDO {

/** 主键 */
private Long id;

/** 登录显示名 */
private String nickName;

/** salt */
private String salt;

/** 登录密码 */
private String password;

/** 手机号 */
private String mobile;

/** 邮箱 */
private String email;

/** 性别 */
private Boolean sex;

/** 是否手机验证 */
private Boolean isMobileVerified;

/** 是否推荐人 */
private Boolean isReferrer;

/** 推荐人ID */
private Long referrerId;

/** 被推荐人总数 */
private Integer referralCount;

/** babytree对应userId */
private String encUserId;

/** 登录类型0:手机 1:email,用于babyTree */
private Long loginType;

/** 创建时间 */
private Date createTime;

/** ip地址 */
private String ip;

/** 修改时间 */
private Date modifyTime;

/** 平台来源  0:pc 1:app 2:wap 3:ios 4:BTM  5:wx */
private Boolean platForm;

/** 网站来源 0:来自美囤 1:来自babytree */
private Boolean source;

/** 状态1:正常 0:不可用 */
private Boolean state;

/**
* 设置 主键
* @param id
*/
	public void setId(Long id) {
	this.id = id;
}
/**
* 设置 登录显示名
* @param nickName
*/
	public void setNickName(String nickName) {
	this.nickName = nickName;
}
/**
* 设置 salt
* @param salt
*/
	public void setSalt(String salt) {
	this.salt = salt;
}
/**
* 设置 登录密码
* @param password
*/
	public void setPassword(String password) {
	this.password = password;
}
/**
* 设置 手机号
* @param mobile
*/
	public void setMobile(String mobile) {
	this.mobile = mobile;
}
/**
* 设置 邮箱
* @param email
*/
	public void setEmail(String email) {
	this.email = email;
}
/**
* 设置 性别
* @param sex
*/
	public void setSex(Boolean sex) {
	this.sex = sex;
}
/**
* 设置 是否手机验证
* @param isMobileVerified
*/
	public void setIsMobileVerified(Boolean isMobileVerified) {
	this.isMobileVerified = isMobileVerified;
}
/**
* 设置 是否推荐人
* @param isReferrer
*/
	public void setIsReferrer(Boolean isReferrer) {
	this.isReferrer = isReferrer;
}
/**
* 设置 推荐人ID
* @param referrerId
*/
	public void setReferrerId(Long referrerId) {
	this.referrerId = referrerId;
}
/**
* 设置 被推荐人总数
* @param referralCount
*/
	public void setReferralCount(Integer referralCount) {
	this.referralCount = referralCount;
}
/**
* 设置 babytree对应userId
* @param encUserId
*/
	public void setEncUserId(String encUserId) {
	this.encUserId = encUserId;
}
/**
* 设置 登录类型0:手机 1:email,用于babyTree
* @param loginType
*/
	public void setLoginType(Long loginType) {
	this.loginType = loginType;
}
/**
* 设置 创建时间
* @param createTime
*/
	public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
/**
* 设置 ip地址
* @param ip
*/
	public void setIp(String ip) {
	this.ip = ip;
}
/**
* 设置 修改时间
* @param modifyTime
*/
	public void setModifyTime(Date modifyTime) {
	this.modifyTime = modifyTime;
}
/**
* 设置 平台来源  0:pc 1:app 2:wap 3:ios 4:BTM  5:wx
* @param platForm
*/
	public void setPlatForm(Boolean platForm) {
	this.platForm = platForm;
}
/**
* 设置 网站来源 0:来自美囤 1:来自babytree
* @param source
*/
	public void setSource(Boolean source) {
	this.source = source;
}
/**
* 设置 状态1:正常 0:不可用
* @param state
*/
	public void setState(Boolean state) {
	this.state = state;
}
/**
* 获取 主键
* @return id
*/
	public Long getId() {
	return id;
}
/**
* 获取 登录显示名
* @return nickName
*/
	public String getNickName() {
	return nickName;
}
/**
* 获取 salt
* @return salt
*/
	public String getSalt() {
	return salt;
}
/**
* 获取 登录密码
* @return password
*/
	public String getPassword() {
	return password;
}
/**
* 获取 手机号
* @return mobile
*/
	public String getMobile() {
	return mobile;
}
/**
* 获取 邮箱
* @return email
*/
	public String getEmail() {
	return email;
}
/**
* 获取 性别
* @return sex
*/
	public Boolean getSex() {
	return sex;
}
/**
* 获取 是否手机验证
* @return isMobileVerified
*/
	public Boolean getIsMobileVerified() {
	return isMobileVerified;
}
/**
* 获取 是否推荐人
* @return isReferrer
*/
	public Boolean getIsReferrer() {
	return isReferrer;
}
/**
* 获取 推荐人ID
* @return referrerId
*/
	public Long getReferrerId() {
	return referrerId;
}
/**
* 获取 被推荐人总数
* @return referralCount
*/
	public Integer getReferralCount() {
	return referralCount;
}
/**
* 获取 babytree对应userId
* @return encUserId
*/
	public String getEncUserId() {
	return encUserId;
}
/**
* 获取 登录类型0:手机 1:email,用于babyTree
* @return loginType
*/
	public Long getLoginType() {
	return loginType;
}
/**
* 获取 创建时间
* @return createTime
*/
	public Date getCreateTime() {
	return createTime;
}
/**
* 获取 ip地址
* @return ip
*/
	public String getIp() {
	return ip;
}
/**
* 获取 修改时间
* @return modifyTime
*/
	public Date getModifyTime() {
	return modifyTime;
}
/**
* 获取 平台来源  0:pc 1:app 2:wap 3:ios 4:BTM  5:wx
* @return platForm
*/
	public Boolean getPlatForm() {
	return platForm;
}
/**
* 获取 网站来源 0:来自美囤 1:来自babytree
* @return source
*/
	public Boolean getSource() {
	return source;
}
/**
* 获取 状态1:正常 0:不可用
* @return state
*/
	public Boolean getState() {
	return state;
}

}