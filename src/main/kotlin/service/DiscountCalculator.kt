package service

import DiscountType.FLAT_PERCENT
import DiscountType.QUANTITY
import data.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import strategy.FlatPercentDiscountStrategy
import strategy.QuantityDiscountStrategy
import usecase.DiscountUseCase
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.coroutines.coroutineContext

class DiscountCalculator : DiscountUseCase {
    override suspend fun applyDiscount(product: Product): BigDecimal {
        println(Thread.currentThread().name)
        val total = withContext(Dispatchers.Default) {
            println(Thread.currentThread().name)
            async {
                when (product.discountType) {
                    QUANTITY -> QuantityDiscountStrategy
                    FLAT_PERCENT -> FlatPercentDiscountStrategy
                }.calc(product)
            }
        }

        return withContext(coroutineContext) {
            println(Thread.currentThread().name)
            BigDecimal.valueOf(total.await()).divide(BigDecimal.valueOf(100L))
                .setScale(2, RoundingMode.HALF_UP)
        }
    }
}