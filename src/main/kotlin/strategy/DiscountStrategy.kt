package strategy

import data.Product

interface DiscountStrategy {
    fun calc(product: Product): Long
}