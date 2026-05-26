Param(
    [string]$MainClass = "Main"
)

$ErrorActionPreference = "Stop"

$root = Split-Path -Parent $MyInvocation.MyCommand.Path
$srcDir = Join-Path $root "src\main\java"
$buildDir = Join-Path $root "build"

# Clean common build output folders.
$cleanupDirs = @(
    $buildDir,
    (Join-Path $root "out"),
    (Join-Path $root "bin"),
    (Join-Path $root "target")
)
foreach ($dir in $cleanupDirs) {
    if (Test-Path $dir) {
        Remove-Item -Recurse -Force $dir
    }
}

# Compile sources into build folder.
New-Item -ItemType Directory -Force -Path $buildDir | Out-Null
$javaFiles = Get-ChildItem -Path $srcDir -Recurse -Filter "*.java" | Select-Object -ExpandProperty FullName

if (-not $javaFiles) {
    throw "No .java files found under $srcDir"
}

try {
    javac -d $buildDir $javaFiles

    # Run the main class.
    java -cp $buildDir $MainClass
}
finally {
    if (Test-Path $buildDir) {
        Remove-Item -Recurse -Force $buildDir
    }
}
