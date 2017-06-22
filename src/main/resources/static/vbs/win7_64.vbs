'#######################################
'Registry Change Script Windows 7 64bit VER
'#######################################

Option Explicit

'#######################################
'SET PROPERTY
'#######################################
Dim shell : Set shell = WScript.CreateObject("WScript.Shell")
Dim message01
Dim message02
Dim URL
Dim reqParam
Dim pcName
Dim beforeReg
Dim afterReg
Dim req

message01 = "ERROR:001 レジストリの変更に失敗しました。管理者へ連絡してください。"
message02 = "ERROR:002 レジストリの変更結果の送信に失敗しました。管理者へ連絡してください。"

'#######################################
'Regstry Update
'#######################################
On Error Resume Next
  Set shell = WScript.CreateObject("WScript.Shell")
  pcName = shell.RegRead("HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\ComputerName\ComputerName\ComputerName")
  beforeReg = shell.RegRead("HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyServer")

  shell.RegWrite "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyEnable", 1, "REG_DWORD"
  shell.RegWrite "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyOverride", "<local>"
  shell.RegWrite "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyServer", "13.113.215.208:3128"

  afterReg = shell.RegRead("HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings\ProxyServer")
  
'#######################################
'Post Result Data
'#######################################
'URL = "http://13.114.27.220/regUpdate/change"
URL = "http://localhost:8080/regUpdate/change"
reqParam= "pcName="&pcName&"&beforeReg="&beforeReg&"&afterReg="&afterReg
Set req = WScript.CreateObject("MSXML2.XMLHTTP.3.0")
Call req.Open("POST", URL, False)
Call req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
Call req.Send(reqParam)

'#######################################
'End
'#######################################
WScript.Echo(req.responseText)
Set req = Nothing

'#######################################
'Check
'#######################################
