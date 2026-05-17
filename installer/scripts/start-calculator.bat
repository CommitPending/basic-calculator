@echo off
title Calculator Application

echo Starting Calculator Application...
echo.

REM Get the directory where this script is located
set SCRIPT_DIR=%~dp0
set APP_DIR=%SCRIPT_DIR%..

REM Check if Java is available
where java >nul 2>nul
if %ERRORLEVEL% NEQ 0 (
    echo Java not found in PATH. Using bundled JRE...
    set JAVA_HOME=%APP_DIR%\jre
    set PATH=%JAVA_HOME%\bin;%PATH%
)

REM Start the backend server
echo Starting backend server on port 8080...
start "Calculator Backend" /MIN java -jar "%APP_DIR%\backend\calculator-backend-1.0.0.jar"

REM Wait for backend to start
timeout /t 5 /nobreak >nul

REM Start the frontend (open in default browser)
echo Starting frontend...
echo Opening http://localhost:8080 in your default browser...
start "" "http://localhost:8080"

echo.
echo Calculator Application is now running!
echo Backend: http://localhost:8080
echo.
echo To stop the application, run stop-calculator.bat or close the backend window.
echo.
pause
