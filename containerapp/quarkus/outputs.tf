output "aca_quarkus_name" {
  description = "The name of the Azure Container App for Quarkus"
  value       = azurerm_container_app.joazca.name
}

output "aca_quarkus_url" {
  description = "The URL of the Azure Container App for Quarkus"
  value       = azurerm_container_app.joazca.configuration[0].ingress[0].fqdn
}
