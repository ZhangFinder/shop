<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <#if user??>
            <#if user.usertype==1>卖家<#else>买家</#if>你好，<span class="name">${user.username}</span>！<a href="/shop/user/logout">[退出]</a>
        <#else>
            请<a href="/shop/login.html">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="/shop/product/index">首页</a></li>
            <#if user?? && user.usertype==0>
            <li><a href="/shop/product/authaccount">财务</a></li>
            <li><a href="/shop/product/authsettleaccount">购物车</a></li>
            </#if>
            <#if user?? && user.usertype==1>
            <li><a href="/shop/product/authpublic">发布</a></li>
            </#if>
        </ul>
    </div>
</div>