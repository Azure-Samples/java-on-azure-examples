output "aca_wildfly_name" {
  description = "The name of the Azure Container App for WildFly"
  value       = azurerm_container_app.joazca.name
}

output "aca_wildfly_url" {
  description = "The URL of the Azure Container App for WildFly"
  value       = azurerm_container_app.joazca.configuration[0].ingress[0].fqdn
}
