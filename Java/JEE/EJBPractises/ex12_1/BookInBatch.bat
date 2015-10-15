@echo off
REM * Books <count> passages for a Customer on a particular Cruise 
REM * Uses command-line parameters:   
REM * BookInBatch.bat <cruiseID> <count>
REM
ant.bat run.bookinbatch -Dparam.cruise=%1 -Dparam.count=%2
