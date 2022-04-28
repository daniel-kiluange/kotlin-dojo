package strategy

import data.Product

object QuantityDiscountStrategy : DiscountStrategy {
    override fun calc(product: Product): Long {
        var totalDiscount = 0L

        val itemsQuantity = 3

        var totalOfItems = product.quantity

        while (totalOfItems >= itemsQuantity) {
            totalDiscount += product.price
            totalOfItems -= itemsQuantity
        }
        return totalDiscount
    }
}