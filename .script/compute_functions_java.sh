#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION

curl https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg
sudo mv microsoft.gpg /etc/apt/trusted.gpg.d/microsoft.gpg
sudo sh -c 'echo "deb [arch=amd64] https://packages.microsoft.com/repos/microsoft-ubuntu-$(lsb_release -cs)-prod $(lsb_release -cs) main" > /etc/apt/sources.list.d/dotnetdev.list'
sudo apt-get update
sudo apt-get install azure-functions-core-tools-3
func


cd compute/functions/java
mkdir .mvn
echo "-ntp" > .mvn/maven.config

export FUNCTIONS_JAVA=functions-java-$RANDOM
mvn -DappName=$FUNCTIONS_JAVA -DresourceGroup=$RESOURCE_GROUP package
mvn -DappName=$FUNCTIONS_JAVA  -DresourceGroup=$RESOURCE_GROUP \
clean package azure-functions:deploy
echo `az functionapp show \
--resource-group $RESOURCE_GROUP \
--name $FUNCTIONS_JAVA \
--query hostNames \
--output tsv`/api/helloworld

cd ../../..


az group delete --name $RESOURCE_GROUP --yes || true