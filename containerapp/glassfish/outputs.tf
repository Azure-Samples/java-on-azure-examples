output "aca_app_name" {
  description = "The name of the Azure Container App"
  value       = azurerm_container_app.joazca.name
}

output "aca_app_url" {
  description = "The URL of the Azure Container App"
  value       = azurerm_container_app.joazca.configuration[0].ingress[0].fqdn
}