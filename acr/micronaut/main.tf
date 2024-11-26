resource "null_resource" "acr_build" {
  provisioner "local-exec" {
    command = <<EOT
      az acr build --registry ${azurerm_container_registry.joazcr.name} --resource-group ${azurerm_resource_group.joazrg.name} --image ${var.acr_micronaut_image} .
    EOT
  }
  depends_on = [azurerm_container_registry.example]
}

resource "local_file" "acr_micronaut_build_output" {
  content  = file("acr_micronaut_build_output.txt")
  filename = "${path.module}/acr_micronaut_build_output.txt"
}