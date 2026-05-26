$ErrorActionPreference = "Stop"

$root = $PSScriptRoot
$src = Join-Path $root "src\main\java"
$build = Join-Path $root "build"

try {
    if (Test-Path $build) {
        Remove-Item -Recurse -Force $build
    }
    New-Item -ItemType Directory -Path $build | Out-Null

    $javaFiles = Get-ChildItem -Path $src -Filter "*.java" -Recurse | Select-Object -ExpandProperty FullName
    if ($javaFiles.Count -eq 0) {
        throw "No Java files found under $src"
    }

    javac -d $build $javaFiles
    java -cp $build Main
}
finally {
    if (Test-Path $build) {
        Remove-Item -Recurse -Force $build
    }
}
