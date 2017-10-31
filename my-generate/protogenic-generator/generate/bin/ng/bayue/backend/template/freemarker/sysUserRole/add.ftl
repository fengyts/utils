
<form name="addform" id="addform" action="/sysUserRole/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "sysUserRole.userId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	主键:
            <@spring.formInput  "sysUserRole.roleId" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>