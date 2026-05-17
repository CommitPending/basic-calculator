[Setup]
AppName=Calculator Application
AppVersion=1.0.0
AppPublisher=Calculator Team
AppPublisherURL=https://github.com/yourusername/calculator-app
DefaultDirName={autopf}\CalculatorApp
DefaultGroupName=Calculator Application
OutputDir=Output
OutputBaseFilename=CalculatorApp-Setup-1.0.0
Compression=lzma2
SolidCompression=yes
ArchitecturesInstallIn64BitMode=x64
UninstallDisplayIcon={app}\calculator.ico
SetupIconFile=calculator.ico
WizardStyle=modern
PrivilegesRequired=admin
LicenseFile=LICENSE.txt

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked
Name: "quicklaunchicon"; Description: "{cm:CreateQuickLaunchIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked; OnlyBelowVersion: 6.1; Check: not IsAdminInstallMode

[Files]
Source: "..\backend\target\calculator-backend-1.0.0.jar"; DestDir: "{app}\backend"; Flags: ignoreversion
Source: "..\frontend\dist\calculator-frontend\*"; DestDir: "{app}\frontend"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "scripts\*"; DestDir: "{app}\scripts"; Flags: ignoreversion recursesubdirs
Source: "jre\*"; DestDir: "{app}\jre"; Flags: ignoreversion recursesubdirs createallsubdirs; Check: not JavaInstalled
Source: "calculator.ico"; DestDir: "{app}"; Flags: ignoreversion
Source: "LICENSE.txt"; DestDir: "{app}"; Flags: ignoreversion
Source: "README.txt"; DestDir: "{app}"; Flags: ignoreversion isreadme

[Icons]
Name: "{group}\Calculator Application"; Filename: "{app}\scripts\start-calculator.bat"; IconFilename: "{app}\calculator.ico"
Name: "{group}\Stop Calculator"; Filename: "{app}\scripts\stop-calculator.bat"; IconFilename: "{app}\calculator.ico"
Name: "{group}\{cm:UninstallProgram,Calculator Application}"; Filename: "{uninstallexe}"
Name: "{autodesktop}\Calculator Application"; Filename: "{app}\scripts\start-calculator.bat"; IconFilename: "{app}\calculator.ico"; Tasks: desktopicon
Name: "{userappdata}\Microsoft\Internet Explorer\Quick Launch\Calculator Application"; Filename: "{app}\scripts\start-calculator.bat"; IconFilename: "{app}\calculator.ico"; Tasks: quicklaunchicon

[Run]
Filename: "{app}\scripts\start-calculator.bat"; Description: "{cm:LaunchProgram,Calculator Application}"; Flags: nowait postinstall skipifsilent shellexec

[UninstallRun]
Filename: "{app}\scripts\stop-calculator.bat"; Flags: runhidden

[Code]
function JavaInstalled: Boolean;
var
  ResultCode: Integer;
begin
  Result := Exec('cmd.exe', '/c java -version', '', SW_HIDE, ewWaitUntilTerminated, ResultCode) and (ResultCode = 0);
end;

function InitializeSetup(): Boolean;
begin
  Result := True;
  if not JavaInstalled then
  begin
    if MsgBox('Java 23 or higher is required but not found. The installer will include a Java runtime. Continue?', mbConfirmation, MB_YESNO) = IDNO then
      Result := False;
  end;
end;
