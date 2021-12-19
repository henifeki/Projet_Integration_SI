import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AjoutClientComponent } from './ajout-client/ajout-client.component';
import { AllClientsComponent } from './all-clients/all-clients.component';

const routes: Routes = [


  {
    path: "all-clients", component: AllClientsComponent
  },
  {
    path: "ajout-client", component: AjoutClientComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
