@echo off
title Stop Calculator Application

echo Stopping Calculator Application...
echo.

REM Kill Java processes running the calculator backend
for /f "tokens=2" %%i in ('tasklist ^| findstr /i "java.exe"') do (
    taskkill /F /PID %%i >nul 2>nul
)

echo Calculator Application stopped.
timeout /t 2 /nobreak >nul
