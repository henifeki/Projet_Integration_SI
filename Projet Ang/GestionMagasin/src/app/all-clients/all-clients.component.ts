import { Component, OnInit } from '@angular/core';
import { GestionMagasinAngService } from '../services/gestion-magasin-ang.service';

@Component({
  selector: 'app-all-clients',
  templateUrl: './all-clients.component.html',
  styleUrls: ['./all-clients.component.scss']
})
export class AllClientsComponent implements OnInit {

  client: any;
  constructor(private service: GestionMagasinAngService) { }

  ngOnInit() {
    let response = this.service.getClients();
    response.subscribe(data => this.client = data);
  }

}
