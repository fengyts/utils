
<form name="addform" id="addform" action="/city/save" method="POST">
        <div>
        	主键:
            <@spring.formInput  "city.id" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.name" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.spelling" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.parentId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.isDelete" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.addDate" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.lastDate" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.agencyId" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.fristWord" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.simpleSpelling" />
            <@spring.showErrors "<br>" />
        </div>
        <div>
        	:
            <@spring.formInput  "city.type" />
            <@spring.showErrors "<br>" />
        </div>
        <br>
        <div><input type="submit" value="确定添加" /></div>
</form>