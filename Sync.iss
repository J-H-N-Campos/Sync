#define MyAppName "Sync"
#define MyAppVersion "1"
#define MyAppPublisher "Reggente"
#define MyAppURL ""

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{BB5053BE-21CE-4EAA-B5C1-F4D6E5BEAE06}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
AllowNoIcons=yes
OutputBaseFilename=setup
SetupIconFile=C:\Users\eduar\Sync\Sync\src\sync\Assets\logo_way.ico
Compression=lzma
SolidCompression=yes
AlwaysRestart=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "C:\Users\Sync\postgresql-12.3-2-windows-x64.exe"; DestDir:{tmp};
Source: "C:\Users\Sync\database.bat"; DestDir: "{tmp}"; DestName: "database.bat";
Source: "C:\Users\Sync\jdk-8u241-windows-x64.exe"; DestDir: {tmp};
Source: "C:\Users\Sync\lib\*"; DestDir: "{app}\lib";
Source: "C:\Users\Sync\Sync.exe"; DestDir: "{app}";


[Run]
Filename: "{tmp}\postgresql-12.3-2-windows-x64.exe"; StatusMsg: Instalando PostgreSQL; Parameters:  --superpassword postgres;
;--create_shortcuts 0 (Adicione para não criar atalhos no postgre)
Filename: "{tmp}\database.bat"; Parameters: """{pf32}"" ""{pf32}"""; StatusMsg: Atualizando o banco de dados;
Filename: "{tmp}\jdk-8u241-windows-x64.exe"; Flags: runminimized; StatusMsg: Instalando JDK;
Filename: "{app}\Sync.exe"; Parameters: """{pf32}"" ""{pf32}""" ;  StatusMsg: Iniciando o programa;
