package momsitter

data class NotificationRequest(
    val phoneNumber: String,
    val title: String,
    val contents: String,
)
