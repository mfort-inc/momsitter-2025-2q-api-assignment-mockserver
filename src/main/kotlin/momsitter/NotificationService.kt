package momsitter

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class NotificationService {

    fun send(): NotificationResponse {
        val resultType = NotificationResultType.random(60)
        val latencyMillis = Random.nextLong(1_000, 10_001)

        try {
            Thread.sleep(latencyMillis)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        return when (resultType) {
            NotificationResultType.SUCCESS -> NotificationResponse(resultType.name)
            NotificationResultType.FAIL -> throw RuntimeException("예외 발생")
        }
    }
}
