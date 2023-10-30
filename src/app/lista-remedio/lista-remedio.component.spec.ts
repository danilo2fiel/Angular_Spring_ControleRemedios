import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaRemedioComponent } from './lista-remedio.component';

describe('ListaRemedioComponent', () => {
  let component: ListaRemedioComponent;
  let fixture: ComponentFixture<ListaRemedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaRemedioComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaRemedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
