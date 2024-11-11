variable "acr_name" {
  description = "The name of the Azure Container Registry"
  type        = string
  default     = "joazcr"
}

variable "acr_sku" {
  description = "The SKU of the Azure Container Registry"
  type        = string
  default     = "Basic"
}
