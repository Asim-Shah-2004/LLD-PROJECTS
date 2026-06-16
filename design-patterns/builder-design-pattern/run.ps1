# run.ps1 - Compile, run the project, and clean up build artifacts.

Write-Host "Cleaning up old build artifacts (class files)..." -ForegroundColor Cyan
Get-ChildItem -Path "src" -Filter "*.class" -Recurse -ErrorAction SilentlyContinue | Remove-Item -Force

Write-Host "Compiling Java source code..." -ForegroundColor Cyan
javac -sourcepath src/main/java src/main/java/Main.java
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed!"
    exit $LASTEXITCODE
}

Write-Host "Running Main program..." -ForegroundColor Cyan
java -cp src/main/java Main

Write-Host "Cleaning up build artifacts (class files)..." -ForegroundColor Cyan
Get-ChildItem -Path "src" -Filter "*.class" -Recurse -ErrorAction SilentlyContinue | Remove-Item -Force

Write-Host "Done!" -ForegroundColor Green
