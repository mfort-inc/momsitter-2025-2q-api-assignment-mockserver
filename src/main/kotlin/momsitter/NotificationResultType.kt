package momsitter

import kotlin.random.Random

enum class NotificationResultType {
    SUCCESS,
    FAIL,
    ;

    companion object {

        fun random(successRate: Int): NotificationResultType{
            return if (Random.nextInt(100) < successRate) {
                SUCCESS
            } else {
                FAIL
            }
        }
    }
}
