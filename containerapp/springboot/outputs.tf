output "aca_springboot_name" {
  description = "The name of the Azure Container App for Spring Boot"
  value       = azurerm_container_app.joazca.name
}

output "aca_springboot_url" {
  description = "The URL of the Azure Container App for Spring Boot"
  value       = azurerm_container_app.joazca.configuration[0].ingress[0].fqdn
}
