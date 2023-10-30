import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RemedioComponent } from './remedio/remedio.component';
import { ListaRemedioComponent } from './lista-remedio/lista-remedio.component';
import { CadastroRemedioComponent } from './cadastro-remedio/cadastro-remedio.component';
import { SharedModule } from './shared/shared.module';
import { BootstrapModule } from './bootstrap/bootstrap.module';
import { AppState } from './AppState';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    RemedioComponent,
    ListaRemedioComponent,
    CadastroRemedioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    BootstrapModule,
    FormsModule

  ],
  providers: [AppState],
  bootstrap: [AppComponent]
})
export class AppModule { }
