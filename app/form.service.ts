import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {Form} from './form';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private http: HttpClient) { }

  postForm(form: Form){
    this.http.post('http://localhost:8080/form', form).subscribe();
    
  }
  getForms(){
    return this.http.get('http://localhost:8080/form');
  
  }
  findOne(id) {
    return this.http.get('http://localhost:8080/form/' + id).pipe(
      catchError(this.handleError<Form>(`findOne`))
    )

  }
  findAll(): Observable<Form[]>  {
    return this.http.get<any>('http://localhost:8080/form').pipe(
      catchError(this.handleError<Form>(`findAll`))
    );
  }
  saveUser(form: Form) {
    return this.http.post('http://localhost:8080/form', form).pipe(
      catchError(this.handleError<Form>(`saveUser`))
    );
  }
  delete(id) {
    return this.http.delete('http://localhost:8080/form/' + id).pipe(
      catchError(this.handleError<Form>(`delete`))
  );

  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
