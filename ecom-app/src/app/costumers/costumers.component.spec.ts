import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CostumersComponent } from './costumers.component';

describe('CostumersComponent', () => {
  let component: CostumersComponent;
  let fixture: ComponentFixture<CostumersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CostumersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CostumersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
