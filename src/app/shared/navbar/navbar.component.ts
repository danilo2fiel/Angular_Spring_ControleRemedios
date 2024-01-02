import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TesteService } from '../services/teste.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  id: number = 0;
  nome: string = '';
  dados: any;

  constructor(
    private router: Router,
    private testeService: TesteService
    ) { }

  navigateToRemedios() {
      // Navegar para a rota "/remedios" com parâmetro de ID
    this.router.navigate(['/remedios', this.id]);
  }

  onInputChange(event: any) {
    // Aqui você pode realizar qualquer validação ou manipulação desejada
    // antes de atualizar a propriedade no modelo
    this.id = event.target.valueAsNumber;
  }

  resposta() {
    // Verificar se o ID é válido antes de navegar
    if (this.id && this.id > 0) {
      // Realizar a busca no serviço pelo ID
      this.testeService.getRemedioById(this.id).subscribe(
        (result) => {
          // Verificar se o remédio foi encontrado
          if (result) {
            console.log('Remédio encontrado:', result);
            this.navigateToRemedios();
          } else {
            console.log('Remédio não encontrado');
          }
        },
        (error) => {
          console.error('Erro ao buscar remédio:', error);
        }
      );
    } else {
      console.warn('ID inválido');
    }
  }



}
