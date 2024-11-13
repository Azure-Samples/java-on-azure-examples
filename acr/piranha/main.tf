resource "null_resource" "acr_build" {
  provisioner "local-exec" {
    command = <<EOT
      az acr build --registry ${azurerm_container_registry.joazcr.name} --resource-group ${azurerm_container_registry.joazcr.resource_group_name} --image ${var.acr_piranha_image} .
    EOT
  }
  depends_on = [azurerm_container_registry.joazcr]
}