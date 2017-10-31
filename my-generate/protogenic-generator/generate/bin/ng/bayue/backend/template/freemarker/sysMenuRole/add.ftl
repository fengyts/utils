
<form name="addform" id="addform" action="/sysMenuRole/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "sysMenuRole.roleId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	主键:
            <@spring.formInput  "sysMenuRole.menuId" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>