output "acr_glassfish_image" {
  description = "The name of the Glassfish image"
  value       = var.acr_glassfish_image
}

output "acr_glassfish_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_glassfish_build_output.filename
}
