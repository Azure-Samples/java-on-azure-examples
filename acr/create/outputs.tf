output "acr_name" {
  description = "The name of the Azure Container Registry"
  value       = azurerm_container_registry.joazcr.name
}

output "acr_sku" {
  description = "The SKU of the Azure Container Registry"
  value       = azurerm_container_registry.joazcr.sku
}
