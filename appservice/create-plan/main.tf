resource "azurerm_app_service_plan" "joaz" {
  name                = "joaz-asp"
  location            = azurerm_resource_group.example.location
  resource_group_name = azurerm_resource_group.example.name
  sku {
    tier = var.app_service_plan_tier
    size = var.app_service_plan_size
  }
  os_type = "Linux"
}
