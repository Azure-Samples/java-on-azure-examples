resource "azurerm_app_service_plan" "joazasp" {
  name                = "joazasp"
  location            = azurerm_resource_group.joazrg.location
  resource_group_name = azurerm_resource_group.joazrg.name
  sku {
    tier = var.app_service_plan_tier
    size = var.app_service_plan_size
  }
  os_type = "Linux"
}
