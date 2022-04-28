package strategy

import data.Product

object FlatPercentDiscountStrategy : DiscountStrategy {

    override fun calc(product: Product): Long {
        val value = product.price
        val total = value * product.quantity

        var percentage = when {
            product.quantity in (2..4) -> 10L
            product.quantity > 4 -> 15L
            else -> 0L
        }

        return (total * percentage) / 100
    }
}