package com.tianji.promotion.strategy.discount;

import com.tianji.common.utils.NumberUtils;
import com.tianji.common.utils.StringUtils;
import com.tianji.promotion.domain.po.Coupon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PerPriceDiscount implements Discount {

    private final static String RULE_TEMPLATE = "每满{}减{}，上限{}";

    private final Integer discountValue;
    private final Integer thresholdAmount;
    private final Integer maxDiscountAmount;

    @Override
    public boolean canUse(int totalAmount, Coupon coupon) {
        return totalAmount >= thresholdAmount;
    }

    @Override
    public int calculateDiscount(int totalAmount, Coupon coupon) {
        int discount = 0;
        int remaining = totalAmount;
        while (remaining >= thresholdAmount) {
            discount += discountValue;
            remaining -= thresholdAmount;
        }
        return Math.min(discount, maxDiscountAmount);
    }

    @Override
    public String getRule(Coupon coupon) {
        return StringUtils.format(
                RULE_TEMPLATE,
                NumberUtils.scaleToStr(thresholdAmount, 2),
                NumberUtils.scaleToStr(discountValue, 2),
                NumberUtils.scaleToStr(maxDiscountAmount, 2));
    }
}
