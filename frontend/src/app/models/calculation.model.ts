export interface CalculationRequest {
  a: number;
  b: number;
}

export interface CalculationResponse {
  result: number;
}

export interface ErrorResponse {
  timestamp: string;
  message: string;
  details: string;
}
