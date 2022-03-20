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

        assertEquals(0, result)
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

        assertEquals(3500, result)
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

        assertEquals(2600, result)
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

        assertEquals(2600, result)
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

        assertEquals(3500, result)
    }

    @Test
    fun calculatingTheCommission_default() {
        val sum = 100000


        val result = calculatingTheCommission(
            sum = sum
        )

        assertEquals(0, result)
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

        assertEquals(0, result)
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

        assertEquals(7500, result)
    }

    @Test
    fun calculatingTheCommission_Maestro_sumPastTransfer() {
        val sum = 100000
        val sumPastTransfer = 75000000
        val paymentSystem: PaymentSystem = PaymentSystem.Maestro

        val result = calculatingTheCommission(
            sum = sum,
            sumPastTransfer = sumPastTransfer,
            paymentSystem = paymentSystem
        )

        assertEquals(2600, result)
    }

    @Test
    fun output_comission_0() {
        val sum = 300
        val commission = 0

        val result = output(
            sum = sum,
            commission = commission
        )

        assertEquals(
            "Комиссия не взымается \n" +
                    "Сумма перевода " + sum / 100 + "руб. " + sum % 100 + " коп.", result
        )
    }

    @Test
    fun output_commissionNotZero() {
        val sum = 30000
        val commission = 1000

        val result = output(
            sum = sum,
            commission = commission
        )

        assertEquals(
            "Комиссия " + commission / 100 + "руб. " + commission % 100 + " коп. \n" +
                    "Сумма перевода " + (sum - commission) / 100 + "руб. " + (sum - commission) % 100 + "коп.", result
        )
    }

    @Test
    fun output_deault() {
        val sum = 300

        val result = output(
            sum = sum,
        )

        assertEquals(
            "Комиссия не взымается \n" +
                    "Сумма перевода " + sum / 100 + "руб. " + sum % 100 + " коп.", result
        )
    }
}

