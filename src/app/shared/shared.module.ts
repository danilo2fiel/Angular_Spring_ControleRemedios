import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RemediosService } from './services/remedios.service';
import { DaoService } from './services/dao.service';
import { HttpClientModule } from '@angular/common/http';
import { TesteService } from './services/teste.service';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,

  ],
  providers: [
    DaoService,
    RemediosService,
    TesteService

  ]
})
export class SharedModule { }
