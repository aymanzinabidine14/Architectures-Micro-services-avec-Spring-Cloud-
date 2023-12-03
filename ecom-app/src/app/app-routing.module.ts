import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./products/products.component";
import {CostumersComponent} from "./costumers/costumers.component";
import {OrdersComponent} from "./orders/orders.component";
import {OrderDetailsComponent} from "./order-details/order-details.component";

const routes: Routes = [
  {
    path :"products",component:ProductsComponent
  },
  {
    path :"costumers",component:CostumersComponent
  },
  {
    path :"orders/:customerId",component:OrdersComponent
  },
  {
    path :"order-details/:orderId",component:OrderDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
