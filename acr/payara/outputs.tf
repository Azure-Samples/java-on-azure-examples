output "acr_payara_image" {
  description = "The name of the Payara image"
  value       = var.acr_payara_image
}

output "acr_payara_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_payara_build_output.filename
}
