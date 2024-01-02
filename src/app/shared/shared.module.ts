import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RemediosService } from './services/remedios.service';
import { DaoService } from './services/dao.service';
import { HttpClientModule } from '@angular/common/http';
import { TesteService } from './services/teste.service';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    NavbarComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [
    DaoService,
    RemediosService,
    TesteService

  ],

  exports: [
    NavbarComponent
  ]
})
export class SharedModule { }
