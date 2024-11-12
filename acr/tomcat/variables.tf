variable "acr_tomcat_image" {
  description = "The name of the Docker image to be built and pushed"
  type        = string
  default     = "tomcat:latest"
}