# run.ps1 — Compile, run, and clean up the notification-system project
#
# Layout expected:
#   notification-system\src\main\java\
#   ├── Main.java
#   ├── run.ps1
#   ├── decorator\
#   ├── notification\
#   ├── observable\
#   ├── observer\
#   ├── services\
#   └── strategy\

$ErrorActionPreference = "Stop"

$SrcRoot   = $PSScriptRoot          # run.ps1 lives in src/main/java
$OutDir    = Join-Path $SrcRoot "out"
$MainClass = "Main"

# ── 1. Collect all .java files ───────────────────────────────────────────────
Write-Host "`n[1/3] Collecting source files..." -ForegroundColor Cyan

$javaFiles = Get-ChildItem -Path $SrcRoot -Recurse -Filter "*.java" |
             Select-Object -ExpandProperty FullName

Write-Host "      Found $($javaFiles.Count) file(s)."

# ── 2. Compile ───────────────────────────────────────────────────────────────
Write-Host "`n[2/3] Compiling..." -ForegroundColor Cyan

if (Test-Path $OutDir) { Remove-Item $OutDir -Recurse -Force }
New-Item -ItemType Directory -Path $OutDir | Out-Null

$fileList = $javaFiles -join " "
$compileCmd = "javac -d `"$OutDir`" -sourcepath `"$SrcRoot`" $fileList"

try {
    Invoke-Expression $compileCmd
    Write-Host "      Compilation successful." -ForegroundColor Green
} catch {
    Write-Host "      Compilation FAILED:" -ForegroundColor Red
    Write-Host $_.Exception.Message
    exit 1
}

# ── 3. Run ───────────────────────────────────────────────────────────────────
Write-Host "`n[3/3] Running $MainClass...`n" -ForegroundColor Cyan
Write-Host "────────────────────────────────────────────────────────────────"

try {
    java -cp $OutDir $MainClass
} catch {
    Write-Host "`nRuntime error:" -ForegroundColor Red
    Write-Host $_.Exception.Message
}

Write-Host "────────────────────────────────────────────────────────────────"

# ── Cleanup ──────────────────────────────────────────────────────────────────
Write-Host "`nCleaning up compiled artifacts..." -ForegroundColor Cyan

if (Test-Path $OutDir) {
    Remove-Item $OutDir -Recurse -Force
    Write-Host "      Removed: out\" -ForegroundColor DarkGray
}

Write-Host "`nDone.`n" -ForegroundColor Green
