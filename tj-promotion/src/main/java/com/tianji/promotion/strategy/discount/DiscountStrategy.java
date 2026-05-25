package com.tianji.promotion.strategy.discount;

import com.tianji.promotion.domain.po.Coupon;

public class DiscountStrategy {

    public static Discount getDiscount(com.tianji.promotion.enums.DiscountType type, Coupon coupon) {
        return com.tianji.promotion.constants.DiscountType.of(type.getValue()).getDiscount(coupon);
    }
}
