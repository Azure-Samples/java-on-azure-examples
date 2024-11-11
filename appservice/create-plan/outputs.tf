output "app_service_plan_name" {
  value = azurerm_app_service_plan.joazasp.name
}

output "app_service_plan_tier" {
  value = azurerm_app_service_plan.joazasp.sku[0].tier
}

output "app_service_plan_size" {
  value = azurerm_app_service_plan.joazasp.sku[0].size
}
