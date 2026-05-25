New-Item -ItemType Directory -Force -Name out | Out-Null
javac -d out (Get-ChildItem -Recurse -Filter "*.java" src/main/java | % { $_.FullName })
java -cp out client.DocumentClient
Remove-Item -Recurse -Force -ErrorAction SilentlyContinue out
