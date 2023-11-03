#!/bin/sh
#title           :hash-jamaica-builds.sh
#description     :This script invokes hash calculations for jamaica components
#author		 :Francisco Franco
#date            :March 19, 2021
#version         :1.0
#==============================================================================

CRYPTO_GEN_HOME="C:/cygwin64/home/franc/eval/cryptography"
JENKINS_WORKSPACE="C:/Windows/System32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/Jamaica/Tags/GLI Certification"
logName="$CRYPTO_GEN_HOME"/log/hash-jamaica.log

echo ===================================================== 
echo ===================================================== >> $logName

echo $(date) EXECUTING COPY FOR JENKINS JAMAICA BUILDS
echo $(date) EXECUTING COPY FOR JENKINS JAMAICA BUILDS >> $logName

cp "$JENKINS_WORKSPACE"/admin-pf-jamaica_2022090600/target/admin-pf-jamaica.war ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/common-cs_2021030900/target/common-cs.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/common-jamaica_2022110300/target/common-jamaica.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/cp-manager-jamaica_2021030900/target/cp-manager-jamaica.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/msgsubsys-jamaica_2022110900/target/msgsubsys-jamaica.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/msgsubsys-rest-jamaica_2022090600/target/msgsubsys-rest-jamaica.war ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/rng_2021030900/target/rng.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/scheduler-jamaica_2021032600/target/scheduler-jamaica.jar ../../builds >> $logName 2>&1
cp "$JENKINS_WORKSPACE"/em-wallet-jamaica_2022110200/target/em-wallet-jamaica.war ../../builds >> $logName 2>&1

echo $(date) COPY DONE!
echo $(date) COPY DONE! >> $logName

echo ===================================================== 
echo ===================================================== >> $logName

cd ../../

echo $(date) EXECUTING CryptoGenerator -h TO CREATE PLAIN TEXT HASH FILE 
echo $(date) EXECUTING CryptoGenerator -h >> $logName

java CryptoGenerator -h >> $logName 2>&1

echo $(date) PLAIN TEXT HASH FILE CREATION DONE!
echo $(date) PLAIN TEXT HASH FILE CREATION DONE! >> $logName

echo ===================================================== 
echo ===================================================== >> $logName

echo $(date) EXECUTING CryptoGenerator -e TO CREATE ENCRYPTED FILE 
echo $(date) EXECUTING CryptoGenerator -e >> $logName

java CryptoGenerator -e >> $logName 2>&1

echo $(date) ENCRYPTED FILE CREATION DONE!
echo $(date) ENCRYPTED FILE CREATION DONE! >> $logName

echo ===================================================== 
echo ===================================================== >> $logName

echo $(date) EXECUTING CryptoGenerator -d TO DECRYPT FILE 
echo $(date) EXECUTING CryptoGenerator -d >> $logName

java CryptoGenerator -d >> $logName 2>&1

echo $(date) DECRYPT FILE DONE!
echo $(date) DECRYPT FILE DONE! >> $logName

read -p "Press any key to end ..."
    