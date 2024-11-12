output "acr_wildfly_image" {
  description = "The name of the Docker image"
  value       = var.acr_wildfly_image
}

output "acr_wildfly_build_output" {
  description = "The output of the ACR build command"
  value       = local_file.acr_wildfly_build_output.content
}