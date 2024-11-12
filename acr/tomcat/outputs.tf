output "acr_tomcat_image" {
  description = "The name of the Docker image"
  value       = var.acr_tomcat_image
}

output "acr_tomcat_build_output" {
  description = "The output of the ACR build command"
  value       = local_file.acr_tomcat_build_output.content
}