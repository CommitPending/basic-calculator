import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { CalculationRequest, CalculationResponse } from '../models/calculation.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  add(a: number, b: number): Observable<CalculationResponse> {
    const request: CalculationRequest = { a, b };
    return this.http.post<CalculationResponse>(`${this.apiUrl}/add`, request)
      .pipe(catchError(this.handleError));
  }

  subtract(a: number, b: number): Observable<CalculationResponse> {
    const request: CalculationRequest = { a, b };
    return this.http.post<CalculationResponse>(`${this.apiUrl}/subtract`, request)
      .pipe(catchError(this.handleError));
  }

  multiply(a: number, b: number): Observable<CalculationResponse> {
    const request: CalculationRequest = { a, b };
    return this.http.post<CalculationResponse>(`${this.apiUrl}/multiply`, request)
      .pipe(catchError(this.handleError));
  }

  divide(a: number, b: number): Observable<CalculationResponse> {
    const request: CalculationRequest = { a, b };
    return this.http.post<CalculationResponse>(`${this.apiUrl}/divide`, request)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An error occurred';
    
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      if (error.error && error.error.details) {
        errorMessage = error.error.details;
      } else {
        errorMessage = `Error: ${error.message}`;
      }
    }
    
    return throwError(() => new Error(errorMessage));
  }
}
