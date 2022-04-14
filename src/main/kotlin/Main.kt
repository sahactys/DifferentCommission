enum class PaymentSystem {
    MasterCard, Maestro, VkPay, Visa, Mir
}

const val CONSTANT_COMMISSION: Int = 2000
const val MIN_COMMISSION: Int = 3500

fun main() {
    var paymentSystemChoice: Int
    var sum: Int
    val sumPastTransfer = 0
    println("Введите сумму перевода")
    while (true) {
        try {
            sum = (readLine()?.toInt() ?: return) * 100
            if (sum < 0) error(0)
            break
        } catch (e: Exception) {
            println("Ошибка ввода, попробуйте еще раз")
        }
    }
    println("Выбор патежной системы")
    println("0. MasterCard")
    println("1. Maestro")
    println("2. Vk Pay")
    println("3. Visa")
    println("4. Мир")
    while (true) {
        try {
            paymentSystemChoice = readLine()?.toInt() ?: return
            if (paymentSystemChoice < 0) error(0)
            break
        } catch (e: Exception) {
            println("Ошибка ввода, попробуйте еще раз")
        }
    }

    val paymentSystem = PaymentSystem.values().getOrElse(paymentSystemChoice) {
        error("Неизвестная платежная система")
    }
    val commission = calculatingTheCommission(sum, sumPastTransfer, paymentSystem)
    println(output(sum, commission))
}

fun calculatingTheCommission(
    sum: Int,
    sumPastTransfer: Int = 0,
    paymentSystem: PaymentSystem = PaymentSystem.VkPay
): Int {

    return when (paymentSystem) {
        PaymentSystem.VkPay -> 0
        PaymentSystem.Maestro, PaymentSystem.MasterCard -> {
            if (sumPastTransfer in 30000..7500000) 0
            else (sum * 0.006 + CONSTANT_COMMISSION).toInt()
        }
        PaymentSystem.Visa, PaymentSystem.Mir -> {
            val calcCommission = sum * 0.0075
            if (calcCommission > MIN_COMMISSION) (calcCommission).toInt() else MIN_COMMISSION
        }
    }
}

fun output(sum: Int, commission: Int = 0): String {
    return if (commission == 0) {

        ("Комиссия не взымается \n" +
                "Сумма перевода ${rubKop(sum / 100, sum % 100)}")
    } else {
        ("Комиссия ${rubKop(commission / 100, commission % 100)} \n" +
                "Сумма перевода ${rubKop((sum + commission) / 100, (sum + commission) % 100)}")
    }


}

fun rubKop(rub: Int, kop: Int): String {
    return "$rub руб. $kop коп."
}