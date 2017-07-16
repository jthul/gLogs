import { Component, OnInit } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, NavigationExtras } from '@angular/router';
import {UserService} from '../_service/user.service';

@Component({
  selector: 'app-authguard',
  templateUrl: './authguard.component.html'
})
export class AuthguardComponent implements CanActivate {

  constructor(private router: Router, private userService:UserService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    let auth = localStorage.getItem('authorization');
    if(auth != null){
      this.userService.checkToken().subscribe(
        data => {
          return true;
        },
        error =>{
          let navigationExtras: NavigationExtras = {
            queryParams: { 'error_id': 1 }
          };
          this.router.navigate(["/login"],navigationExtras);
          return false;
        });
        // By default we will return true;
        return true;
      }else{
        let navigationExtras: NavigationExtras = {
          queryParams: { 'error_id': 1 }
        };
        this.router.navigate(['/login'],navigationExtras);
        return false;
      }
    }
  }
