variable "acr_wildfly_image" {
  description = "The name of the Docker image to be built and pushed"
  type        = string
  default     = "wildfly:latest"
}