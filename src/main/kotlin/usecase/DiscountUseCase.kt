package usecase

import data.Product
import java.math.BigDecimal

interface DiscountUseCase {
    fun applyDiscount(product: Product): BigDecimal
}