resource "azurerm_container_app" "joazca" {
  name                = var.aca_wildfly_name
  resource_group_name = azurerm_resource_group.joazrg.name
  container_app_environment_id = azurerm_container_app_environment.joazcae.id
  location            = azurerm_resource_group.joazrg.location
  template {
    container {
      name   = var.aca_wildfly_name
      image  = "${azurerm_container_registry.joazcr.login_server}/${var.acr_wildfly_image}"
      cpu    = "0.5"
      memory = "1.0"
    }
    ingress {
      external_enabled = true
      target_port      = 8080
    }
  }
  registry {
    server   = azurerm_container_registry.joazcr.login_server
    username = azurerm_container_registry.joazcr.admin_username
    password = azurerm_container_registry.joazcr.admin_password
  }
}