if (Test-Path bin) {
    Remove-Item -Recurse -Force bin
}
New-Item -ItemType Directory -Force -Path bin | Out-Null
javac -d bin src/main/java/PaymentGatewayApplication.java src/main/java/bankingsystemproxy/*.java src/main/java/controller/*.java src/main/java/enums/*.java src/main/java/factories/*.java src/main/java/models/*.java src/main/java/payment/*.java src/main/java/services/*.java
if ($LASTEXITCODE -eq 0) {
    java -cp bin PaymentGatewayApplication
}
