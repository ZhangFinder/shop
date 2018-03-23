<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc">
    <#if !product??>
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
    <#else>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${product.imageUrl}" alt=""></div>
        <div class="cnt">
            <h2>${product.title}</h2>
            <p class="summary">${product.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${product.price}</span>
            </div>
            <div class="oprt f-cb">
                <#if user?? && user.usertype==0>
                    <#if !(product.soldAmmount==0) >
                    <span class="u-btn u-btn-primary z-dis">已购买，购买数量：${product.soldAmmount}件</span>
                    <span class="buyprice">当时购买价格：¥${product.price}</span>
                    <#else>
                    
                    <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">1</span><span id="addNum" class="moreNum"><a>+</a></span></div>
                     <div class="oprt f-cb">
                    <button class="u-btn u-btn-primary" id="add" data-id="${product.id}" data-title="${product.title}" data-price="${product.price}">
                                                                          加入购物车</button>
                    </div>
                    
                    </#if>
                </#if>
                <#if user?? && user.usertype==1>
                <a href="/shop/product/edit?id=${product.id}" class="u-btn u-btn-primary">编 辑</a>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        ${product.detail}
    </div>
    </#if>
</div>
<#include "/include/footer.ftl">
<script type="text/javascript" src="/shop/js/global.js"></script>
<script type="text/javascript" src="/shop/js/pageShow.js"></script>
</body>
</html>