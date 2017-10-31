
<form name="addform" id="addform" action="/sysMenu/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "sysMenu.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	菜单code:
            <@spring.formInput  "sysMenu.code" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	父菜单id，如果为空，则为根菜单:
            <@spring.formInput  "sysMenu.parentId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	菜单名称:
            <@spring.formInput  "sysMenu.name" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	菜单请求链接:
            <@spring.formInput  "sysMenu.url" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	所属:
            <@spring.formInput  "sysMenu.category" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	菜单类型（0 :主导航 1：菜单  2：按钮）:
            <@spring.formInput  "sysMenu.menuType" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建人id:
            <@spring.formInput  "sysMenu.createUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改人id:
            <@spring.formInput  "sysMenu.modifyUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	创建时间:
            <@spring.formInput  "sysMenu.createTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改时间:
            <@spring.formInput  "sysMenu.modifyTime" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	状态:
            <@spring.formInput  "sysMenu.status" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>