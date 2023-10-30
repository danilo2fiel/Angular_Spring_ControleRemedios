import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TesteService {
  private apiUrl = 'api/remedios';

  constructor(private http: HttpClient) { }

  getDados() {
    return this.http.get(this.apiUrl);
  }

  postNomeQuantidade(nome: string, quantidade: number): Observable<any> {
    const body = { nome, quantidade };
    return this.http.post(this.apiUrl, body);
  }

  delete(id: number){
    return this.http.delete(this.apiUrl+'/'+id)
  }

  semana(): Observable<any>{
    const body = {};
    return this.http.put(this.apiUrl+'/semana', body);
  }

  editar(nome: string, quantidade: number, id: number): Observable<any> {
    const body = {nome, quantidade, id }
    return this.http.put(this.apiUrl+'/'+id, body);
  }
}
