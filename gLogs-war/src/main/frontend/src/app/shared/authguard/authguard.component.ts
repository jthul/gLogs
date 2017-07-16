import { Component, OnInit } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';


@Component({
  selector: 'app-authguard',
  templateUrl: './authguard.component.html'
})
export class AuthguardComponent implements CanActivate {
  constructor(private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    this.router.navigate(['/login']);
    return false;
  }

}
