import { Component, HostListener } from '@angular/core';
import { CalculatorService } from '../../services/calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent {
  display: string = '0';
  currentValue: number = 0;
  previousValue: number = 0;
  operation: string = '';
  waitingForOperand: boolean = false;
  errorMessage: string = '';
  isDarkMode: boolean = true;

  constructor(private calculatorService: CalculatorService) {}

  @HostListener('window:keydown', ['$event'])
  handleKeyboardEvent(event: KeyboardEvent) {
    const key = event.key;
    
    if (key >= '0' && key <= '9') {
      this.inputDigit(key);
    } else if (key === '.') {
      this.inputDecimal();
    } else if (key === '+' || key === '-' || key === '*' || key === '/') {
      this.performOperation(key);
    } else if (key === 'Enter' || key === '=') {
      event.preventDefault();
      this.performOperation('=');
    } else if (key === 'Escape' || key === 'c' || key === 'C') {
      this.clear();
    } else if (key === 'Backspace') {
      this.backspace();
    }
  }

  inputDigit(digit: string) {
    this.errorMessage = '';
    
    if (this.waitingForOperand) {
      this.display = digit;
      this.waitingForOperand = false;
    } else {
      this.display = this.display === '0' ? digit : this.display + digit;
    }
  }

  inputDecimal() {
    this.errorMessage = '';
    
    if (this.waitingForOperand) {
      this.display = '0.';
      this.waitingForOperand = false;
    } else if (this.display.indexOf('.') === -1) {
      this.display += '.';
    }
  }

  clear() {
    this.display = '0';
    this.currentValue = 0;
    this.previousValue = 0;
    this.operation = '';
    this.waitingForOperand = false;
    this.errorMessage = '';
  }

  backspace() {
    if (this.display.length > 1) {
      this.display = this.display.slice(0, -1);
    } else {
      this.display = '0';
    }
  }

  performOperation(nextOperation: string) {
    const inputValue = parseFloat(this.display);

    if (this.operation && this.waitingForOperand) {
      this.operation = nextOperation;
      return;
    }

    if (this.previousValue === 0) {
      this.previousValue = inputValue;
    } else if (this.operation) {
      this.executeOperation(this.previousValue, inputValue, this.operation);
      return;
    }

    this.waitingForOperand = true;
    this.operation = nextOperation;
  }

  executeOperation(a: number, b: number, operation: string) {
    this.errorMessage = '';
    
    let serviceCall;
    
    switch (operation) {
      case '+':
        serviceCall = this.calculatorService.add(a, b);
        break;
      case '-':
        serviceCall = this.calculatorService.subtract(a, b);
        break;
      case '*':
        serviceCall = this.calculatorService.multiply(a, b);
        break;
      case '/':
        serviceCall = this.calculatorService.divide(a, b);
        break;
      default:
        return;
    }

    serviceCall.subscribe({
      next: (response) => {
        this.currentValue = response.result;
        this.display = String(this.currentValue);
        this.previousValue = this.currentValue;
        this.waitingForOperand = true;
      },
      error: (error) => {
        this.errorMessage = error.message;
        this.display = 'Error';
        this.previousValue = 0;
        this.currentValue = 0;
        this.operation = '';
      }
    });
  }

  toggleTheme() {
    this.isDarkMode = !this.isDarkMode;
    document.body.classList.toggle('light-mode', !this.isDarkMode);
    document.body.classList.toggle('dark-mode', this.isDarkMode);
  }
}
