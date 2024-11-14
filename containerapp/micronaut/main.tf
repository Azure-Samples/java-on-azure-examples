resource "azurerm_container_app" "joazca" {
  name                = var.container_app_name
  resource_group_name = azurerm_resource_group.joazrg.name
  location            = azurerm_resource_group.joazrg.location
  container_app_environment_id = azurerm_container_app_environment.joazcae.id

  template {
    container {
      name   = "micronaut"
      image  = "${azurerm_container_registry.joazcr.login_server}/${var.acr_micronaut_image}"
      cpu    = 0.5
      memory = 1.0
    }
  }
}
