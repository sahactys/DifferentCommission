enum class PaymentSystem {
    MasterCard, Maestro, VkPay, Visa, Mir
}

const val CONSTANT_COMMISSION: Int = 2000
const val MIN_COMMISSION: Int = 3500

fun main() {
    var paymentSystemChoice: Int
    var sum: Int
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
    val paymentSystem: PaymentSystem = when (paymentSystemChoice) {
        1 -> PaymentSystem.VkPay
        2 -> PaymentSystem.MasterCard
        3 -> PaymentSystem.Maestro
        4 -> PaymentSystem.Visa
        5 -> PaymentSystem.Mir
        else -> error("Неизвестная плаежная система")
    }
    calculatingTheCommission(sum, 0, paymentSystem)
}

fun calculatingTheCommission(
    sum: Int,
    sumPastTransfer: Int = 0,
    paymentSystem: PaymentSystem = PaymentSystem.VkPay
) {
    val commission: Int
    when (paymentSystem) {
        PaymentSystem.VkPay -> output(sum)
        PaymentSystem.Maestro, PaymentSystem.MasterCard -> {
            if (sumPastTransfer in 30000..7500000) {
                output(sum)
            } else {
                commission = (sum * 0.006 + CONSTANT_COMMISSION).toInt()
                output(sum, commission)
            }
        }
        PaymentSystem.Visa, PaymentSystem.Mir -> {
            commission = if (sum * 0.0075 > MIN_COMMISSION) (sum * 0.0075).toInt() else MIN_COMMISSION
            output(sum, commission)
        }
    }
}

fun output(sum: Int, commission: Int = 0) {
    if (commission == 0) {
        println("Комиссия не взымается")
        println("Сумма перевода " + sum / 100 + "руб. " + sum % 100 + "коп.")
    } else {
        println("Комиссия " + commission / 100 + "руб. " + commission % 100 + "коп.")
        println("Сумма перевода " + (sum - commission) / 100 + "руб. " + (sum - commission) % 100 + "коп.")
    }
}