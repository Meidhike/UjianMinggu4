# Appium Mobile Automation (Zoom In & Out Test)

##  OVerview
Proyek ini adalah contoh implementasi **Appium + Java + TestNG** untuk menguji fitur **zoom in & zoom out menggunakan W3C Actions API** pada gambar produk di aplikasi **Swag Labs Mobile**.

---

## ⚙️ Persyaratan
Sebelum menjalankan proyek, pastikan sudah menginstal:
1. **Java JDK 17+**
2. **Maven 3.9.0+** 
3. **Appium Server** (`npm install -g appium`)
4. **Appium Inspector**
5. **IDE (Intellij IDEA) atau VSCODE**
6. **Android Studio (untuk Emulator)**
7. **Aktifkan USB Debugging di HP**

---
## Quick Installation
Please clone this project with the following command:
```
git clone <https://github.com/Meidhike/UjianMinggu4.git>
```
Running test with the following command:
`mvn clean test`

Test with Another Suite
`mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml`

## Menjalankan Appium Server
1. Buka terminal cmd dan jalankan:
```
appium
```
Server default berjalan di http://127.0.0.1:4723.


2. Pastikan device/emulator sudah aktif dan terdeteksi:
Buka terminal cmd dan jalankan:
```
adb devices
```
---


Author
[Meidhike](https://github.com/Meidhike)
