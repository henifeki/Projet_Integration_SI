import { TestBed } from '@angular/core/testing';

import { GestionMagasinAngService } from './gestion-magasin-ang.service';

describe('GestionMagasinAngService', () => {
  let service: GestionMagasinAngService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionMagasinAngService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
