
<form name="addform" id="addform" action="/sysRole/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "sysRole.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	角色名称:
            <@spring.formInput  "sysRole.name" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	角色代码:
            <@spring.formInput  "sysRole.code" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	角色类型:
            <@spring.formInput  "sysRole.type" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	是否可用:1-可用;0-不可用:
            <@spring.formInput  "sysRole.status" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	备注:
            <@spring.formInput  "sysRole.remark" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建人id:
            <@spring.formInput  "sysRole.createUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建时间:
            <@spring.formInput  "sysRole.createTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改时间:
            <@spring.formInput  "sysRole.modifyTime" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>