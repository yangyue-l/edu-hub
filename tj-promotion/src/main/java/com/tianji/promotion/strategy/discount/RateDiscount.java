package com.tianji.promotion.strategy.discount;

import com.tianji.common.utils.NumberUtils;
import com.tianji.common.utils.StringUtils;
import com.tianji.promotion.domain.po.Coupon;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RateDiscount implements Discount {

    private static final String RULE_TEMPLATE = "满{}打{}折，上限{}元";

    private final Integer discountValue;
    private final Integer thresholdAmount;
    private final Integer maxDiscountAmount;

    @Override
    public boolean canUse(int totalAmount, Coupon coupon) {
        return totalAmount >= thresholdAmount;
    }

    @Override
    public int calculateDiscount(int totalAmount,  Coupon coupon) {
        return Math.min(maxDiscountAmount, totalAmount * (100 - discountValue) / 100);
    }

    @Override
    public String getRule( Coupon coupon) {
        return StringUtils.format(
                RULE_TEMPLATE,
                NumberUtils.scaleToStr(thresholdAmount, 2),
                NumberUtils.scaleToStr(discountValue, 1),
                NumberUtils.scaleToStr(maxDiscountAmount, 2)
        );
    }
}
