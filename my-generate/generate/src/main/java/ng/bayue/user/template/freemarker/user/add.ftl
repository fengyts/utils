
<form name="addform" id="addform" action="/user/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "user.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	登录显示名:
            <@spring.formInput  "user.nickName" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	salt:
            <@spring.formInput  "user.salt" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	登录密码:
            <@spring.formInput  "user.password" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	手机号:
            <@spring.formInput  "user.mobile" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	邮箱:
            <@spring.formInput  "user.email" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	性别:
            <@spring.formInput  "user.sex" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	是否手机验证:
            <@spring.formInput  "user.isMobileVerified" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	是否推荐人:
            <@spring.formInput  "user.isReferrer" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	推荐人ID:
            <@spring.formInput  "user.referrerId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	被推荐人总数:
            <@spring.formInput  "user.referralCount" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	babytree对应userId:
            <@spring.formInput  "user.encUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	登录类型0:手机 1:email,用于babyTree:
            <@spring.formInput  "user.loginType" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建时间:
            <@spring.formInput  "user.createTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	ip地址:
            <@spring.formInput  "user.ip" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改时间:
            <@spring.formInput  "user.modifyTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	平台来源  0:pc 1:app 2:wap 3:ios 4:BTM  5:wx:
            <@spring.formInput  "user.platForm" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	网站来源 0:来自美囤 1:来自babytree:
            <@spring.formInput  "user.source" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	状态1:正常 0:不可用:
            <@spring.formInput  "user.state" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>