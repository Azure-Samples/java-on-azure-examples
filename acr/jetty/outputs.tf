output "acr_jetty_image" {
  description = "The name of the Jetty image"
  value       = var.acr_jetty_image
}

output "acr_jetty_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_jetty_build_output.filename
}
