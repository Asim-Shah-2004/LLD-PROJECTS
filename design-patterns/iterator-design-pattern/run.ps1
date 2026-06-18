# Compile the project
Write-Host "Compiling Java files..." -ForegroundColor Cyan
if (-not (Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}

# Find all Java files recursively and compile them
$javaFiles = (Get-ChildItem -Path src/main/java -Recurse -Filter *.java).FullName
javac -d bin -sourcepath src/main/java $javaFiles

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful. Running the application:`n" -ForegroundColor Green
    java -cp bin Main
} else {
    Write-Host "Compilation failed." -ForegroundColor Red
}

# Clean up artifacts (bin directory)
if (Test-Path "bin") {
    Write-Host "`nCleaning up compiled artifacts..." -ForegroundColor Yellow
    Remove-Item -Recurse -Force "bin"
    Write-Host "Cleanup complete." -ForegroundColor Green
}
