import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminMateriasComponent } from './admin-materias.component';

describe('AdminMateriasComponent', () => {
  let component: AdminMateriasComponent;
  let fixture: ComponentFixture<AdminMateriasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminMateriasComponent]
    });
    fixture = TestBed.createComponent(AdminMateriasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
