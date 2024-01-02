import { Component, OnInit } from '@angular/core';
import { TesteService } from '../shared/services/teste.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-remedio',
  templateUrl: './remedio.component.html',
  styleUrls: ['./remedio.component.css']
})
export class RemedioComponent implements OnInit {

  id: number = 0;
  dados: any;
  getGeral:any;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private testeService: TesteService) { }

  ngOnInit(): void {
  // this.testeService.getRemedioById(this.id).subscribe((data) => {
  //    this.dados = data;
  //  });
     // Obtendo o id da rota
  this.route.params.subscribe(params => {
    const id = params['id'];
    console.log('ID recebido em RemediosComponent:', id);

    // Agora você pode usar o id para buscar dados e exibi-los na tela
     this.testeService.getRemedioById(id).subscribe(
      (data) => {
        this.dados = data;
        console.log('Dados do Remédio:', this.dados);
      },
      (error) => {
        console.error('Erro ao buscar dados do remédio:', error);
      }
    );
  });

  this.testeService.getDados().subscribe(
    (data) => {
      this.getGeral = data;
    }
  )

  }

  onInputChange(event: any) {
    // Aqui você pode realizar qualquer validação ou manipulação desejada
    // antes de atualizar a propriedade no modelo
    this.id = event.target.valueAsNumber;
  }

  getRemedio(){
    this.testeService.getRemedioById(this.id).subscribe((data) => {
      this.dados = data;

    });
  }
}








