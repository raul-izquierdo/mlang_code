@echo off
rem Don't remove the next "cd". ANTLR has a bug and appends the folder of the grammar file to the target folder.
rem So if 'specifications\Grammar.g4' is written, code will be generated in 'src\parser\specifications' instead of 'src\parser'.

cd specifications

java -jar "..\tools\antlr\antlr-4.11.1-complete.jar" -no-listener -package parser -o ..\src\parser Grammar.g4

cd ..
del src\parser\*.tokens
del src\parser\*.interp
