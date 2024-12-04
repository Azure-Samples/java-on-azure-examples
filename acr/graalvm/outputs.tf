output "acr_graalvm_image" {
  description = "The name of the GraalVM image"
  value       = var.acr_graalvm_image
}

output "acr_graalvm_build_output" {
  description = "The output of the ACR build"
  value       = local_file.acr_graalvm_build_output.filename
}
