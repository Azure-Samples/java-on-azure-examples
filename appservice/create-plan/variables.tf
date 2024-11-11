variable "app_service_plan_tier" {
  description = "The pricing tier for the App Service Plan"
  default     = "PremiumV3"
}

variable "app_service_plan_size" {
  description = "The instance size for the App Service Plan"
  default     = "P1v3"
}