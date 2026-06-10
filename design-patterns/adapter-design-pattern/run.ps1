Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

$Root    = $PSScriptRoot
$SrcRoot = Join-Path $Root "src\main\java"
$OutDir  = Join-Path $Root "out"

$OldOutputEncoding = [Console]::OutputEncoding
$OldInputEncoding  = [Console]::InputEncoding
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8
[Console]::InputEncoding  = [System.Text.Encoding]::UTF8
chcp 65001 | Out-Null

Write-Host ""
Write-Host "+------------------------------------------+" -ForegroundColor Cyan
Write-Host "|    Adapter Pattern - Data Converter      |" -ForegroundColor Cyan
Write-Host "+------------------------------------------+" -ForegroundColor Cyan
Write-Host ""

try {

    if (-not (Get-Command javac -ErrorAction SilentlyContinue)) {
        Write-Host "[ERROR] 'javac' not found. Please install JDK 11+ and add it to PATH." -ForegroundColor Red
        exit 1
    }

    $javaVersion = (javac -version 2>&1)
    Write-Host "[INFO] Using: $javaVersion" -ForegroundColor DarkGray

    if (Test-Path $OutDir) {
        Remove-Item -Recurse -Force $OutDir
    }

    New-Item -ItemType Directory -Path $OutDir | Out-Null
    Write-Host "[INFO] Output directory: $OutDir"

    $JavaFiles = Get-ChildItem -Path $SrcRoot -Recurse -Filter "*.java" |
                 Select-Object -ExpandProperty FullName

    Write-Host "[INFO] Found $($JavaFiles.Count) source file(s):"
    $JavaFiles | ForEach-Object {
        Write-Host "       $_" -ForegroundColor DarkGray
    }

    Write-Host ""
    Write-Host "[STEP] Compiling..." -ForegroundColor Yellow

    $CompileArgs = @("-d", $OutDir, "-encoding", "UTF-8", "-sourcepath", $SrcRoot) + $JavaFiles
    & javac @CompileArgs

    if ($LASTEXITCODE -ne 0) {
        Write-Host "[ERROR] Compilation failed." -ForegroundColor Red
        exit 1
    }

    Write-Host "[OK]   Compilation successful." -ForegroundColor Green

    Write-Host ""
    Write-Host "[STEP] Running Main..." -ForegroundColor Yellow
    Write-Host "---------------------------------------------"
    Write-Host ""

    & java "-Dfile.encoding=UTF-8" "-Dstdout.encoding=UTF-8" "-Dstderr.encoding=UTF-8" -cp $OutDir Main

    Write-Host ""
    Write-Host "---------------------------------------------"
    Write-Host "[DONE] Demo finished." -ForegroundColor Green
    Write-Host ""

}
finally {

    if (Test-Path $OutDir) {
        Write-Host "[STEP] Cleaning up output directory..." -ForegroundColor Yellow
        Remove-Item -Recurse -Force $OutDir
        Write-Host "[OK]   Deleted '$OutDir'." -ForegroundColor Green
    }

    if ($OldOutputEncoding) {
        [Console]::OutputEncoding = $OldOutputEncoding
        chcp $OldOutputEncoding.CodePage | Out-Null
    }
    if ($OldInputEncoding) {
        [Console]::InputEncoding = $OldInputEncoding
    }

}
