import { Component, OnInit } from '@angular/core';
import {UserService} from '../../shared/_service/user.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  private userInfos:any;

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userInfos = [];
    this.userInfos.userName="sal";
    console.log("test");
    this.userService.getUserInfos().subscribe((response: Response) => {this.userInfos = response;});
  }
}
