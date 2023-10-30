import { Injectable } from '@angular/core';
import { DaoService } from './dao.service';
import { IRemedios } from '../models/remedios.interface';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RemediosService {

  public static get API_LANCAMENTOS(): string {
    return '/api/remedios';
  }

  constructor(
    private dao: DaoService
  ) { }

  cadastrarRemedio(remedio: IRemedios): Observable<HttpResponse<IRemedios>> {
    return this.dao.post<IRemedios>('http://localhost:8081/api/remedios',
    remedio, DaoService.MEDIA_TYPE_APP_JSON);
  }

  listaRemedios(): Observable<HttpResponse<IRemedios[]>> {
    return this.dao.get<IRemedios[]>('http://localhost:8081/api/remedios', DaoService.MEDIA_TYPE_APP_JSON);
  }
}
