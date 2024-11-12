resource "null_resource" "acr_build" {
  provisioner "local-exec" {
    command = <<EOT
      az acr build --registry ${azurerm_container_registry.joazcr.name} --resource-group ${azurerm_container_registry.joazcr.resource_group_name} --image ${var.acr_wildfly_image} . | tee acr_wildfly_build_output.txt
    EOT
  }
  depends_on = [azurerm_container_registry.joazcr]
}

resource "local_file" "acr_wildfly_build_output" {
  content  = file("acr_wildfly_build_output.txt")
  filename = "${path.module}/acr_wildfly_build_output.txt"
}