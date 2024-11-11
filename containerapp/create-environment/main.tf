
resource "azurerm_container_app_environment" "joazcae" {
  name                = var.aca_environment_name
  location            = azurerm_resource_group.joazrg.location
  resource_group_name = azurerm_resource_group.joazrg.name
}
