# AutomateCalc – Tự động hóa ứng dụng Máy tính Android bằng Appium + Java

Dự án này sử dụng **Java + Appium** để tự động mở ứng dụng **Google Calculator** trên Android và thực hiện phép tính `8 + 2 = 10`, sau đó kiểm tra kết quả.

---

## 1. Yêu cầu môi trường

Trước khi chạy dự án, cần chuẩn bị:

- **Java JDK 8+**
- **Maven** (nếu dùng Maven để quản lý thư viện)
- **Android SDK** (đã cài và cấu hình biến môi trường `ANDROID_HOME`)
- **Thiết bị Android thật** hoặc **Android Emulator** (đã bật USB Debugging)
- **Appium Server** (phiên bản 2.x khuyến nghị)
- **Node.js** (Appium yêu cầu Node.js để chạy)
- IDE như **IntelliJ IDEA** hoặc **Eclipse**

---

## 2. Cài đặt thư viện cần thiết

Nếu dùng Maven, thêm vào `pom.xml`:

```xml
<dependencies>
    <!-- Selenium Java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>

    <!-- Appium Java Client -->
    <dependency>
        <groupId>io.appium</groupId>
        <artifactId>java-client</artifactId>
        <version>9.0.0</version>
    </dependency>
</dependencies>
Nếu không dùng Maven, tải file .jar và add vào project thủ công.

3. Chuẩn bị thiết bị Android
Dùng thiết bị thật
Bật Developer Options → USB Debugging.

Kết nối với máy tính qua USB.

Kiểm tra thiết bị đã kết nối:

bash
Sao chép
Chỉnh sửa
adb devices
Dùng Android Emulator
Khởi động emulator:

bash
Sao chép
Chỉnh sửa
emulator -avd emulator-5554
Kiểm tra thiết bị:

bash
Sao chép
Chỉnh sửa
adb devices
4. Khởi chạy Appium Server
Mở terminal và chạy:

bash
Sao chép
Chỉnh sửa
appium
Hoặc chỉ định cổng:

bash
Sao chép
Chỉnh sửa
appium -p 4723
5. Cấu hình trong code
Trong method getCalculatorCapabilities():

java
Sao chép
Chỉnh sửa
capabilities.setCapability("appium:deviceName", "emulator-5554");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("appium:automationName", "uiautomator2");
capabilities.setCapability("appium:platformVersion", "15");
capabilities.setCapability("appium:appPackage", "com.google.android.calculator");
capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
appium:deviceName: tên thiết bị từ adb devices

appium:platformVersion: phiên bản Android

appium:appPackage & appium:appActivity: thông tin ứng dụng Calculator

6. Cách chạy chương trình
Đảm bảo Appium Server đang chạy.

Kết nối thiết bị hoặc mở emulator.

Mở project trong IntelliJ IDEA hoặc Eclipse.

Mở file AutomateCalc.java.

Run chương trình.

7. Kết quả mong đợi
Nếu kết quả là 10:

rust
Sao chép
Chỉnh sửa
Test Passed: Result = 10
Nếu khác:

cpp
Sao chép
Chỉnh sửa
Test Failed: Result = <kết_quả_thực_tế>
8. Lỗi thường gặp và cách khắc phục
Thiết bị không nhận:

bash
Sao chép
Chỉnh sửa
adb kill-server
adb start-server
adb devices
Appium không chạy:

bash
Sao chép
Chỉnh sửa
appium-doctor --android
Sai package/activity:

bash
Sao chép
Chỉnh sửa
adb shell dumpsys window | grep -E 'mCurrentFocus'
9. Tài liệu tham khảo
Appium Documentation

Selenium Documentation
