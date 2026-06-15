if (Test-Path bin) {
    Remove-Item -Recurse -Force bin
}
New-Item -ItemType Directory -Path bin | Out-Null
javac -d bin -sourcepath src/main/java src/main/java/Main.java
java -cp bin Main
if (Test-Path bin) {
    Remove-Item -Recurse -Force bin
}
