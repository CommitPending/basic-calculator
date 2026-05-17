import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CalculatorComponent } from './calculator.component';
import { CalculatorService } from '../../services/calculator.service';
import { of, throwError } from 'rxjs';

describe('CalculatorComponent', () => {
  let component: CalculatorComponent;
  let fixture: ComponentFixture<CalculatorComponent>;
  let calculatorService: CalculatorService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculatorComponent ],
      imports: [ HttpClientTestingModule ],
      providers: [ CalculatorService ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalculatorComponent);
    component = fixture.componentInstance;
    calculatorService = TestBed.inject(CalculatorService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize with display "0"', () => {
    expect(component.display).toBe('0');
  });

  it('should input digit correctly', () => {
    component.inputDigit('5');
    expect(component.display).toBe('5');
  });

  it('should input multiple digits', () => {
    component.inputDigit('1');
    component.inputDigit('2');
    component.inputDigit('3');
    expect(component.display).toBe('123');
  });

  it('should input decimal point', () => {
    component.inputDigit('5');
    component.inputDecimal();
    component.inputDigit('5');
    expect(component.display).toBe('5.5');
  });

  it('should clear display', () => {
    component.inputDigit('5');
    component.clear();
    expect(component.display).toBe('0');
    expect(component.currentValue).toBe(0);
    expect(component.previousValue).toBe(0);
  });

  it('should perform addition', () => {
    spyOn(calculatorService, 'add').and.returnValue(of({ result: 15 }));
    
    component.inputDigit('10');
    component.performOperation('+');
    component.inputDigit('5');
    component.performOperation('=');
    
    expect(calculatorService.add).toHaveBeenCalledWith(10, 5);
  });

  it('should handle error from service', () => {
    spyOn(calculatorService, 'divide').and.returnValue(
      throwError(() => new Error('Cannot divide by zero'))
    );
    
    component.inputDigit('10');
    component.performOperation('/');
    component.inputDigit('0');
    component.performOperation('=');
    
    expect(component.errorMessage).toBe('Cannot divide by zero');
    expect(component.display).toBe('Error');
  });

  it('should toggle theme', () => {
    const initialTheme = component.isDarkMode;
    component.toggleTheme();
    expect(component.isDarkMode).toBe(!initialTheme);
  });

  it('should backspace correctly', () => {
    component.display = '123';
    component.backspace();
    expect(component.display).toBe('12');
  });
});
