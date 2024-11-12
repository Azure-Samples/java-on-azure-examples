resource "null_resource" "acr_build" {
  provisioner "local-exec" {
    command = <<EOT
      az acr build --registry ${azurerm_container_registry.joazcr.name} --resource-group ${azurerm_container_registry.joazrg.resource_group_name} --image ${var.acr_tomcat_image} . | tee acr_tomcat_build_output.txt
    EOT
  }
  depends_on = [azurerm_container_registry.joazcr]
}

resource "local_file" "acr_tomcat_build_output" {
  content  = file("acr_tomcat_build_output.txt")
  filename = "${path.module}/acr_tomcat_build_output.txt"
}
