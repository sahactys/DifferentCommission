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
    println("1. Vk pay")
    println("2. Master card")
    println("3. Maestro")
    println("4. Visa")
    println("5. Мир")
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
        error("Неизвестная плаежная система")
    }
//    val paymentSystem: PaymentSystem = when (paymentSystemChoice) {
//        1 -> PaymentSystem.VkPay
//        2 -> PaymentSystem.MasterCard
//        3 -> PaymentSystem.Maestro
//        4 -> PaymentSystem.Visa
//        5 -> PaymentSystem.Mir
//        else -> error("Неизвестная плаежная система")
//    }
    val commission = calculatingTheCommission(sum, sumPastTransfer, paymentSystem)
    println(output(sum, commission))
}

fun calculatingTheCommission(
    sum: Int,
    sumPastTransfer: Int = 0,
    paymentSystem: PaymentSystem = PaymentSystem.VkPay
): Int {
    val calcCommission = sum * 0.0075
    return when (paymentSystem) {
        PaymentSystem.VkPay -> 0
        PaymentSystem.Maestro, PaymentSystem.MasterCard -> {
            if (sumPastTransfer in 30000..7500000) 0
            else (sum * 0.006 + CONSTANT_COMMISSION).toInt()
        }
        PaymentSystem.Visa, PaymentSystem.Mir -> if (calcCommission > MIN_COMMISSION) (calcCommission).toInt() else MIN_COMMISSION
    }
}

fun output(sum: Int, commission: Int = 0): String {
    return if (commission == 0) {

        ("Комиссия не взымается \n" +
                "Сумма перевода ${sum / 100} руб. ${sum % 100} коп.")
    } else {
        ("Комиссия ${commission / 100} руб. ${commission % 100} коп. \n" +
                "Сумма перевода ${(sum - commission) / 100} руб. ${(sum - commission) % 100} коп.")
    }


}