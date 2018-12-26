
<form name="addform" id="addform" action="/icheccConstants/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "icheccConstants.constKey" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	常量值:
            <@spring.formInput  "icheccConstants.constValue" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	常量说明:
            <@spring.formInput  "icheccConstants.description" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改人:
            <@spring.formInput  "icheccConstants.modifyUserId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	修改时间:
            <@spring.formInput  "icheccConstants.modifyTime" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>