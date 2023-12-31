import { HomeComponent } from './pages/home/home.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RemedioComponent } from './remedio/remedio.component';
import { ListaRemedioComponent } from './lista-remedio/lista-remedio.component';
import { CadastroRemedioComponent } from './cadastro-remedio/cadastro-remedio.component';

const routes: Routes = [
  {path:'remedios', component: RemedioComponent},
  {path:'remedios/:id', component: RemedioComponent},
  {path:'lista', component: ListaRemedioComponent},
  {path:'cadastro', component:CadastroRemedioComponent},
  {path: '', component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
