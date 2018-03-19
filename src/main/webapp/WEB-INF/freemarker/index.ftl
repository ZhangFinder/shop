<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">

<div class="g-doc">
  
    <#if !productList??>
    <div class="n-result">
        <h3>暂无内容！</h3>
    </div>
    <#else>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
        <#if user?? && user.usertype == 0 && listType == 1>
            <#list productList as x>
                <#if !x.buy>
                <li id="p-${x.id}">
                    <a href="/show?id=${x.id}" class="link">
                        <div class="img"><img src="${x.image}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                    </a>
                </li>
                </#if>
            </#list>
        <#else>
            <#list productList as x>
                <li id="p-${x.id}">
                    <a href="/show?id=${x.id}" class="link">
                        <div class="img"><img src="${x.image}" alt="${x.title}"></div>
                        <h3>${x.title}</h3>
                        <div class="price"><span class="v-unit">¥</span><span class="v-value">${x.price}</span></div>
                        <#if user?? && user.usertype==0 && x.buy><span class="had"><b>已购买</b></span></#if>
                        <#if user?? && user.usertype==1 && x.sell><span class="had"><b>已售出</b></span></#if>
                    </a>
                    <#if user?? && user.usertype==1 && !x.sell><span class="u-btn u-btn-normal u-btn-xs del" data-del="${x.id}">删除</span></#if>
                </li>
            </#list>
        </#if>
        </ul>
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
<script type="text/javascript" src="/shop/js/global.js"></script>
<script type="text/javascript" src="/shop/js/pageIndex.js"></script>
</body>
</html>