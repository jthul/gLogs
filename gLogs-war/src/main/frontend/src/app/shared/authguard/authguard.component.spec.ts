import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthguardComponent } from './authguard.component';

describe('AuthguardComponent', () => {
  let component: AuthguardComponent;
  let fixture: ComponentFixture<AuthguardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthguardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthguardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
