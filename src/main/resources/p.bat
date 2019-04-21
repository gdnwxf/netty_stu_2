@echo off
set errorlevel=0
echo.
echo generate proto
protoc --java_out=./ PushMessagePB.proto
echo success!

set curr_dir=%~dp0
set source_dir=%curr_dir%com
set dest_dir=%curr_dir%..\..\main\java\com
echo %curr_dir%
echo %source_dir%
echo %dest_dir%

echo copy proto java file to base
xcopy %source_dir% %dest_dir% /e /r /-y
rd /s /q com
echo success!
pause