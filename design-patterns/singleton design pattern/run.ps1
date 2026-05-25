$ErrorActionPreference = "Stop"

$srcDir = Join-Path $PSScriptRoot "java\main\src"

Push-Location $srcDir
try {
    javac SingletonDesignPattern.java
    if ($LASTEXITCODE -ne 0) {
        exit $LASTEXITCODE
    }

    java Driver
    $exitCode = $LASTEXITCODE
} finally {
    Get-ChildItem -Path $srcDir -Filter "*.class" -File -ErrorAction SilentlyContinue | Remove-Item -Force -ErrorAction SilentlyContinue
    Pop-Location
}

exit $exitCode
