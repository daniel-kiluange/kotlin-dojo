package usecase

import data.Product
import java.math.BigDecimal

interface DiscountCalculatorUseCase {
    suspend fun applyDiscount(product: Product): BigDecimal
}