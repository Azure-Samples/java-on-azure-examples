resource "azurerm_container_registry" "joazcr" {
  name                = var.acr_name
  resource_group_name = azurerm_resource_group.joazrg.name
  location            = azurerm_resource_group.joazrg.location
  sku                 = var.acr_sku
  admin_enabled       = true
}
