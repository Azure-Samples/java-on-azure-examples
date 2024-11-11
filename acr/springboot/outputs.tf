output "acr_springboot_image_name" {
  description = "The name of the Docker image"
  value       = var.acr_springboot_image_name
}

output "acr_springboot_build_output" {
  description = "The output of the ACR build command"
  value       = local_file.acr_springboot_build_output.content
}
