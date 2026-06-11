# Spotify Mini-Project Run Script

# Compile all source files
Write-Host "Compiling Java files..." -ForegroundColor Green
if (Test-Path bin) { Remove-Item -Recurse -Force bin }
New-Item -ItemType Directory bin | Out-Null

$javaFiles = Get-ChildItem -Recurse src/main/java/*.java | ForEach-Object { $_.FullName }
javac -d bin -sourcepath src/main/java $javaFiles

if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilation failed!" -ForegroundColor Red
    exit $LASTEXITCODE
}

# Run the program
Write-Host "Running Main program..." -ForegroundColor Green
java -cp bin Main

# Clean up build artifacts (bin folder)
Write-Host "`nCleaning up compilation artifacts..." -ForegroundColor Yellow
if (Test-Path bin) { Remove-Item -Recurse -Force bin }
Write-Host "Clean up complete." -ForegroundColor Green
