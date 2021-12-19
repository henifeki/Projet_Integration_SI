import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../client';

@Injectable({
  providedIn: 'root'
})
export class GestionMagasinAngService {
  client: Client = new Client("", "");

  constructor(private http: HttpClient) { }

  public postClient(client: Client) {
    return this.http.post("http://localhost:9010/client/save", client, { responseType: "text" as "json" });
  }

  public getClients() {
    return this.http.get("http://localhost:9010/client/find");

  }
}
