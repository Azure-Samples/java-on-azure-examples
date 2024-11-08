
resource "azurerm_resource_group" "rg" {
    name     = "joaz-rg"
    location = var.resource_group_location
}
