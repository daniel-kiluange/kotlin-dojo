package service

import data.DiscountType
import data.Product
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DiscountCalculatorTest {

    @Test
    fun `flat percent discount test1`() = runBlocking{
        val product = Product(1000, DiscountType.FLAT_PERCENT, 10)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        println(value)
        assertEquals("15.00", value.toString())
    }

    @Test
    fun `flat percent discount test2`() = runBlocking{
        val product = Product(997, DiscountType.FLAT_PERCENT, 10)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        assertEquals("14.95", value.toString())
    }

    @Test
    fun `flat percent discount test3`() = runBlocking{
        val product = Product(997, DiscountType.FLAT_PERCENT, 4)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        println(value)
        assertEquals("3.98", value.toString())
    }

    @Test
    fun `flat percent discount test4`() = runBlocking{
        val product = Product(997, DiscountType.FLAT_PERCENT, 5)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        assertEquals("7.47", value.toString())
    }

    @Test
    fun `quantity discount test1`() = runBlocking{
        val product = Product(1000, DiscountType.QUANTITY, 10)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        assertEquals("30.00", value.toString())
    }

    @Test
    fun `quantity discount test2`() = runBlocking{
        val product = Product(1000, DiscountType.QUANTITY, 2)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        assertEquals("0.00", value.toString())
    }

    @Test
    fun `quantity discount test3`() = runBlocking{
        val product = Product(1000, DiscountType.QUANTITY, 5)
        val calculator = DiscountCalculatorCalculator()
        val value = calculator.applyDiscount(product)
        assertEquals("10.00", value.toString())
    }
}