package usecase

import data.Product
import java.math.BigDecimal

interface DiscountUseCase {
    suspend fun applyDiscount(product: Product): BigDecimal
}