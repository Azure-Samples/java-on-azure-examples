output "acr_micronaut_image" {
  description = "The name of the Micronaut image"
  value       = var.acr_micronaut_image
}

output "acr_micronaut_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_micronaut_build_output.filename
}
