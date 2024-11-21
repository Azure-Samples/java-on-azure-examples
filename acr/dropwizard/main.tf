resource "null_resource" "acr_build" {
  provisioner "local-exec" {
    command = <<EOT
      az acr build --registry ${azurerm_container_registry.joazcr.name} --resource-group ${azurerm_resource_group.joazrg.name} --image ${var.acr_dropwizard_image} .
    EOT
  }
  depends_on = [azurerm_container_registry.joazcr]
}

resource "local_file" "acr_dropwizard_build_output" {
  content  = file("acr_dropwizard_build_output.txt")
  filename = "${path.module}/acr_dropwizard_build_output.txt"
}
