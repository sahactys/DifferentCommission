import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun main() {
    }

    @Test
    fun calculatingTheCommission_paymentSystem_Vkpay() {
        val sum = 100000
        val sumPastTransfer = 0
        val paymentSystem: PaymentSystem = PaymentSystem.VkPay

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(0,result)
    }

    @Test
    fun calculatingTheCommission_paymentSystem_Visa() {
        val sum = 100000
        val sumPastTransfer = 0
        val paymentSystem: PaymentSystem = PaymentSystem.Visa

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(3500,result)
    }

    @Test
    fun calculatingTheCommission_paymentSystem_MsterCard() {
        val sum = 100000
        val sumPastTransfer = 0
        val paymentSystem: PaymentSystem = PaymentSystem.MasterCard

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(2600,result)
    }

    @Test
    fun calculatingTheCommission_paymentSystem_Maestro() {
        val sum = 100000
        val sumPastTransfer = 0
        val paymentSystem: PaymentSystem = PaymentSystem.Maestro

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(2600,result)
    }

    @Test
    fun calculatingTheCommission_paymentSystem_Mir() {
        val sum = 100000
        val sumPastTransfer = 0
        val paymentSystem: PaymentSystem = PaymentSystem.Mir

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(3500,result)
    }

    @Test
    fun calculatingTheCommission_default() {
        val sum = 100000


        val result = calculatingTheCommission(
            sum = sum
        )

        assertEquals(0,result)
    }

    @Test
    fun calculatingTheCommission_MasterCard_sumPastTransfer() {
        val sum = 100000
        val sumPastTransfer = 100000
        val paymentSystem: PaymentSystem = PaymentSystem.MasterCard

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(0,result)
    }

    @Test
    fun calculatingTheCommission_Mir_bigSum() {
        val sum = 1000000
        val sumPastTransfer = 100000
        val paymentSystem: PaymentSystem = PaymentSystem.Mir

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(7500,result)
    }

    @Test
    fun calculatingTheCommission_Maestro_sumPastTransfer() {
        val sum = 100000
        val sumPastTransfer = 30000
        val paymentSystem: PaymentSystem = PaymentSystem.Maestro

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(0,result)
    }

}