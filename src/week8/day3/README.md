내용이 day1 와 이어지는 부분이 많아서 day1 에 대부분 추가로 정리했습니다.
---

# MultiPartUpload
> Multipart 업로드는 클라이언트에서 서버로 여러 개의 파일 또는 데이터를 동시에 전송하는 방식입니다.

## MultiPartUpload 특징
1. Multipart 업로드는 일반적으로 파일 업로드와 함께 폼 데이터를 함께 전송할 때 사용됩니다.
2. 여러 개의 파일 또는 데이터를 동시에 전송하기 위해 enctype 속성이 multipart/form-data로 설정된 HTML 폼을 사용합니다. 클라이언트에서 해당 폼을 제출하면, 서버는 Multipart 요청을 받아 파일 및 데이터를 처리합니다.

## Spring MVC 에서의 MultipartUpload 
컨트롤러에서 Multipart 요청을 처리하기 위해 MultipartFile 파라미터를 사용합니다.<br> 
MultipartFile은 업로드된 파일의 메타데이터 및 파일 내용을 저장하는 객체입니다.<br>
예시: <br>
```java
@PostMapping("/upload")
public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
        try {
            byte[] bytes = file.getBytes();
            // 파일 처리 로직
            // ...
            return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed";
        }
    } else {
        return "No file uploaded";
    }
}
```