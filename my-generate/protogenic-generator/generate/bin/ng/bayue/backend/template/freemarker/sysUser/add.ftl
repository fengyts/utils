
<form name="addform" id="addform" action="/sysUser/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "sysUser.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	登录名:
            <@spring.formInput  "sysUser.loginName" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	用户名:
            <@spring.formInput  "sysUser.userName" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	密码:
            <@spring.formInput  "sysUser.password" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	登录盐:
            <@spring.formInput  "sysUser.salt" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	email:
            <@spring.formInput  "sysUser.email" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	手机号:
            <@spring.formInput  "sysUser.mobile" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建人id:
            <@spring.formInput  "sysUser.createUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建时间:
            <@spring.formInput  "sysUser.createTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改人id:
            <@spring.formInput  "sysUser.modifyUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改时间:
            <@spring.formInput  "sysUser.modifyTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	最后登录时间:
            <@spring.formInput  "sysUser.lastLoginTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	最后登录ip:
            <@spring.formInput  "sysUser.lastLoginIp" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	用户状态:1-有效;0-无效:
            <@spring.formInput  "sysUser.status" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	用户扩展信息:
            <@spring.formInput  "sysUser.userDetail" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>