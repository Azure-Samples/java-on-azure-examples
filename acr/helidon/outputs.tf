output "acr_helidon_image" {
  description = "The name of the Helidon image"
  value       = var.acr_helidon_image
}

output "acr_helidon_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_helidon_build_output.filename
}
