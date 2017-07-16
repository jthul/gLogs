import { Component, OnInit } from '@angular/core';
import { Title }     from '@angular/platform-browser';
import { AuthenticateService } from './_service/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  public username:string;
  public password:string;
  constructor(private titleService: Title,
              private authenticateService: AuthenticateService) { }

  ngOnInit() {
    this.titleService.setTitle("gLogs - Authentication");
  }

  checkValidity(){
    return this.username != null && this.username !=""
        && this.password!=null && this.password!="";
  }

  login(){
    this.authenticateService.login(this.username, this.password).subscribe(
                data => {

                },
                error => {

                });
  }
}
