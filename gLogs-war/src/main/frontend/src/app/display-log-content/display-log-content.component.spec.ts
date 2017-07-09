import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayLogContentComponent } from './display-log-content.component';

describe('DisplayLogContentComponent', () => {
  let component: DisplayLogContentComponent;
  let fixture: ComponentFixture<DisplayLogContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayLogContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayLogContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
