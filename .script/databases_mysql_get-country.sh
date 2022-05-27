#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $MYSQL_NAME ]]; then
export MYSQL_NAME=mysql-$RANDOM
export MYSQL_USERNAME=mysql
export MYSQL_PASSWORD=p#ssw0rd-$RANDOM
fi

az mysql server create \
--admin-user $MYSQL_USERNAME \
--admin-password $MYSQL_PASSWORD \
--name $MYSQL_NAME \
--resource-group $RESOURCE_GROUP \
--sku B_Gen5_1 \
--ssl-enforcement Disabled
export LOCAL_IP=`curl -s whatismyip.akamai.com`

az mysql server firewall-rule create \
--resource-group $RESOURCE_GROUP \
--server $MYSQL_NAME \
--name AllowMyLocalIP \
--start-ip-address $LOCAL_IP \
--end-ip-address $LOCAL_IP

cd databases/mysql/load-your-mysql-database-with-data
export MYSQL_DNS_NAME=`az mysql server show \
--resource-group $RESOURCE_GROUP \
--name $MYSQL_NAME \
--query fullyQualifiedDomainName \
--output tsv`
export MYSQL_CLIENT_USERNAME="$MYSQL_USERNAME@$MYSQL_NAME"
mysql -h $MYSQL_DNS_NAME -u $MYSQL_CLIENT_USERNAME -p$MYSQL_PASSWORD < load.sql
cd ../../..


cd databases/mysql/get-country

mvn package
java -jar target/get-country.jar jdbc:mysql://$MYSQL_DNS_NAME:3306/demo?useSSL=true\&requireSSL=true $MYSQL_CLIENT_USERNAME $MYSQL_PASSWORD USA

cd ../../..


cd databases/mysql/get-country
export RESULT=$(java -jar target/get-country.jar jdbc:mysql://$MYSQL_DNS_NAME:3306/demo?useSSL=true\&requireSSL=true $MYSQL_CLIENT_USERNAME $MYSQL_PASSWORD USA)
cd ../../..
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != *"United States"* ]]; then
echo "Unable to get the correct country information"
exit 1
fi