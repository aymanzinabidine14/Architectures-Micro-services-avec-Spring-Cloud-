import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-costumers',
  templateUrl: './costumers.component.html',
  styleUrl: './costumers.component.css'
})
export class CostumersComponent implements OnInit{

  customers:any;
  constructor(private http:HttpClient,private router:Router) {
  }
  ngOnInit() {
    this.http.get("http://localhost:9999/costumer-service/customers?projection=fullCustomer").subscribe({
      next:(data)=>{

        this.customers=data;

      },
      error:(err)=>{

      }
    })

  }

  getOrders(c: any) {
    this.router.navigateByUrl("/orders/"+c.id)



  }
}
