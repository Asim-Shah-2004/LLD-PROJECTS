$files = Get-ChildItem -Path "src" -Filter "*.java" -Recurse | ForEach-Object { $_.FullName }
javac -d bin $files
java -cp bin Main
Remove-Item -Path bin -Recurse -Force -ErrorAction SilentlyContinue
