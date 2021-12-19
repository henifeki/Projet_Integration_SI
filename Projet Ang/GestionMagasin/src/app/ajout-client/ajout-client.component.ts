import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { GestionMagasinAngService } from '../services/gestion-magasin-ang.service';

@Component({
  selector: 'app-ajout-client',
  templateUrl: './ajout-client.component.html',
  styleUrls: ['./ajout-client.component.scss']
})
export class AjoutClientComponent implements OnInit {
  client: Client = new Client("", "");
  message: any;

  constructor(private service: GestionMagasinAngService) { }

  ngOnInit(): void {
  }

  public ClientNew() {
    let response = this.service.postClient(this.client);
    response.subscribe(data => {
      this.message = data;
    })
  }

}
