# 알림 발송 서버(Mock Server) 안내
안녕하세요 🙂  
이 코드는 **맘시터 서버 개발자 사전 과제**를 위해 준비된 *알림 발송 서버(Mock Server)* 입니다.  
아래 안내에 따라 실행해 주신 뒤, 직접 구현하신 **알림 발송 예약 서버**와 연동해 사용해 주세요.

---

## 실행 방법
1. 이 Repository의 `main` 브랜치를 pull 합니다.
2. Local Repository 경로에서 아래 명령어 실행하면 서버가 실행됩니다.

```bash
$ ./gradlew clean
$ ./gradlew bootRun
```

> 위 명령어는 예시일 뿐이니, 본인에게 편한 방법으로 실행하셔도 괜찮습니다.

---

## 꼭 확인해 주세요
- 이 서버는 **8010 포트**를 사용합니다. 실행 전에 혹시 해당 포트를 쓰는 다른 프로그램이 있다면 먼저 종료해 주세요.

---

## 알림 발송 API 명세
`POST http://localhost:8010/notifications/send`
- **Request Body**
  ```json
  {
    "phoneNumber": "01012345678",
    "title": "알림 제목",
    "contents": "알림 내용 본문"
  }
  ```

  | 필드          | 타입     | 필수 | 설명       |
    |-------------|--------|---:|----------|
  | phoneNumber | string |  ✅ | 수신자 전화번호 |
  | title       | string |  ✅ | 알림 제목    |
  | contents    | string |  ✅ | 알림 본문    |

- **Response - `200 OK`**
  ```json
  { 
    "result": "SUCCESS" 
  }
  ```
  | 필드     | 타입     | 설명          |
    |--------|--------|-------------|
  | result | string | `"SUCCESS"` |

- **Response - `500 Internal Server Error`**
  ```json
  { 
    "errorMessage": "예외 발생" 
  }
  ```
  | 필드           | 타입     | 설명        |
  |--------------|--------|-----------|
  | errorMessage | string | 에러 메시지 내용 |

---

## 예시
### cURL
```bash
curl -X POST "http://localhost:8010/notifications/send" \
  -H "Content-Type: application/json" \
  -d '{
    "phoneNumber": "01012345678",
    "title": "테스트 알림",
    "contents": "본문입니다."
  }'
```

성공(예):
```json
{ 
  "result": "SUCCESS"
}
```

예외(예):
```json
{ 
  "errorMessage": "예외 발생"
}
```

## Request & Response 데이터 모델 (참고)

```kotlin
data class NotificationRequest(
    val phoneNumber: String,
    val title: String,
    val contents: String,
)

data class NotificationResponse(
    val result: String,
)
```
