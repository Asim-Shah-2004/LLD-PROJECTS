$ErrorActionPreference = "Stop"

$Root = Split-Path -Parent $MyInvocation.MyCommand.Path
$SrcDir = Join-Path $Root "src\main\java"
$OutDir = Join-Path $Root "out"

if (-not (Test-Path $SrcDir)) {
    throw "Source directory not found: $SrcDir"
}

# Always delete any compiled artifacts at the end.
try {
    if (Test-Path $OutDir) {
        Remove-Item -Recurse -Force $OutDir
    }

    $javaFiles = Get-ChildItem -Path $SrcDir -Recurse -Filter "*.java" | Select-Object -ExpandProperty FullName
    if (-not $javaFiles) {
        throw "No Java files found under: $SrcDir"
    }

    javac -d $OutDir @javaFiles
    java -cp $OutDir client.Client
}
finally {
    if (Test-Path $OutDir) {
        Remove-Item -Recurse -Force $OutDir
    }
}
