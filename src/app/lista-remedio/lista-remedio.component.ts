import { Component, OnInit } from '@angular/core';
import { RemediosService } from '../shared/services/remedios.service';
import { TesteService } from '../shared/services/teste.service';

@Component({
  selector: 'app-lista-remedio',
  templateUrl: './lista-remedio.component.html',
  styleUrls: ['./lista-remedio.component.css']
})
export class ListaRemedioComponent implements OnInit {

  dados: any;

  constructor(private testeService: TesteService) { }

  ngOnInit() {
    this.testeService.getDados().subscribe((data) => {
      this.dados = data;
    });
  }
}
