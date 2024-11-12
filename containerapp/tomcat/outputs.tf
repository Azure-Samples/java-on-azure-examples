output "aca_tomcat_name" {
  description = "The name of the Azure Container App for Tomcat"
  value       = azurerm_container_app.joazca.name
}

output "aca_tomcat_url" {
  description = "The URL of the Azure Container App for Tomcat"
  value       = azurerm_container_app.joazca.configuration[0].ingress[0].fqdn
}
