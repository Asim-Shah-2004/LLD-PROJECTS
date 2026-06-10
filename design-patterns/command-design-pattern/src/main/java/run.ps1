# ─────────────────────────────────────────────────────────────
#  run.ps1  –  Compile & run the Command Design Pattern demo
#  Run from:  src/main/java/
# ─────────────────────────────────────────────────────────────

$ErrorActionPreference = "Stop"

# ── Paths ────────────────────────────────────────────────────
$SRC_ROOT  = $PSScriptRoot                          # src/main/java/
$OUT_DIR   = Join-Path $SRC_ROOT "out"              # src/main/java/out/

# ── Create output directory ──────────────────────────────────
if (-not (Test-Path $OUT_DIR)) {
    New-Item -ItemType Directory -Path $OUT_DIR | Out-Null
}

# ── Collect all .java source files ──────────────────────────
$sources = Get-ChildItem -Path $SRC_ROOT -Recurse -Filter "*.java" |
           Where-Object { $_.FullName -notlike "*\out\*" } |
           ForEach-Object { $_.FullName }

if ($sources.Count -eq 0) {
    Write-Error "No .java files found under $SRC_ROOT"
    exit 1
}

# ── Compile ──────────────────────────────────────────────────
Write-Host "Compiling $($sources.Count) source file(s)..." -ForegroundColor Cyan
javac -d $OUT_DIR $sources
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed."
    exit $LASTEXITCODE
}
Write-Host "Compilation successful." -ForegroundColor Green

# ── Run ──────────────────────────────────────────────────────
Write-Host ""
Write-Host "Running Main..." -ForegroundColor Cyan
Write-Host ("-" * 50)
java -cp $OUT_DIR Main
Write-Host ("-" * 50)
Write-Host "Done." -ForegroundColor Green