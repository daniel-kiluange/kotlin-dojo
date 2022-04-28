package service

import DiscountType.FLAT_PERCENT
import DiscountType.QUANTITY
import data.Product
import strategy.FlatPercentDiscountStrategy
import strategy.QuantityDiscountStrategy
import usecase.DiscountUseCase
import java.math.BigDecimal
import java.math.RoundingMode

class DiscountCalculator : DiscountUseCase {
    override fun applyDiscount(product: Product): BigDecimal {
        val total = when (product.discountType) {
            QUANTITY -> QuantityDiscountStrategy
            FLAT_PERCENT -> FlatPercentDiscountStrategy
        }.calc(product)

        return BigDecimal.valueOf(total).divide(BigDecimal.valueOf(100L))
            .setScale(2, RoundingMode.HALF_UP)
    }
}