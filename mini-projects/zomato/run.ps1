$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$src = Join-Path $root "src\main\java"
$out = Join-Path $root "out"

if (Test-Path $out) {
    Remove-Item -Recurse -Force $out
}

New-Item -ItemType Directory -Path $out -Force | Out-Null

$files = Get-ChildItem -Path $src -Recurse -Filter "*.java" | ForEach-Object { $_.FullName }

if (-not $files -or $files.Count -eq 0) {
    throw "No Java files found under $src"
}

javac -d $out -sourcepath $src $files
java -cp $out Zomato

Remove-Item -Recurse -Force $out
