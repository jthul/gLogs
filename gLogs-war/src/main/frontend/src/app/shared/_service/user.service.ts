import { Injectable } from '@angular/core';
import { Http, Headers, Response, ConnectionBackend,RequestOptions } from '@angular/http';

@Injectable()
export class UserService {
  constructor(private http: Http) { }

  checkToken(){
    let auth = localStorage.getItem('authorization');
    let headers = new Headers();
    headers.append('authorization', auth);
    let options = new RequestOptions({ headers: headers });
    return this.http.get('/api/user/checkToken',options)
    .map((response: Response) =>
        data=>{return true;},
        error=>{return false;}
      );
  }

  getUserInfos(){
    let auth = localStorage.getItem('authorization');
    let headers = new Headers();
    headers.append('authorization', auth);
    let options = new RequestOptions({ headers: headers });
    return this.http.get('/api/user/infos',options)
    .map((response: Response) => {return response.json();});
  }

}
