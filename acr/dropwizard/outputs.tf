output "acr_dropwizard_image" {
  description = "The name of the DropWizard image"
  value       = var.acr_dropwizard_image
}

output "acr_dropwizard_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_dropwizard_build_output.filename
}
