import { TesteService } from '../shared/services/teste.service';

import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-cadastro-remedio',
  templateUrl: './cadastro-remedio.component.html',
  styleUrls: ['./cadastro-remedio.component.css']
})

export class CadastroRemedioComponent implements OnInit {

  nome: string = '';
  quantidade: number = 0;
  id: number = 0;


  dados:any;

  constructor(
    private testeService: TesteService
  ) { }

  ngOnInit(): void {
    this.testeService.getDados().subscribe((data) => {
      this.dados = data;
    });
  }

  enviarDados() {
    this.testeService.postNomeQuantidade(this.nome, this.quantidade).subscribe(
      (response) => {
        // Lógica para tratar a resposta da API
      },
      (error) => {
        // Lógica para tratar erros
      }
    );
    alert("cadastrado com sucesso");
    location.reload();
  }

  deletar(){
    this.testeService.delete(this.id).subscribe(
      (response) => {
        // Lógica para tratar a resposta da API

      },
      (error) => {
        alert("id não existe");
      }
    );

    location.reload();
  }

  semana(){
    this.testeService.semana().subscribe(
      (response) => {
        // Lógica para tratar a resposta da API
      },
      (error) => {
        // Lógica para tratar erros
      }

    );
    alert("feito");
    location.reload();
  }

  editar(){
    this.testeService.editar(this.nome, this.quantidade, this.id).subscribe(
      (response) => {
        // Lógica para tratar a resposta da API
      },
      (error) => {
        // Lógica para tratar erros
      }
    )
    alert("editado");
    location.reload();

  }


}

