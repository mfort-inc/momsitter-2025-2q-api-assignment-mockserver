package momsitter

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationController(
    private val notificationService: NotificationService,
) {

    @PostMapping("/notifications/send")
    fun sendNotification(@RequestBody request: NotificationRequest): NotificationResponse {
        return this.notificationService.send()
    }
}
