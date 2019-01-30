import { Injectable } from '@angular/core';
import { Search } from './search';
import { HttpClient } from '@angular/common/http';
import {Observable, of} from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  saveSearch(search: Search) {
    return this.http.post('http://localhost:8080/search', search).pipe(
      catchError(this.handleError<Search>(`saveUser`))
    );
  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}

