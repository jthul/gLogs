import { Injectable } from '@angular/core';
import { Http, Headers, Response, ConnectionBackend,RequestOptions } from '@angular/http';

@Injectable()
export class HttpClientService extends Http {

  constructor(_backend:ConnectionBackend, _defaultOption:RequestOptions) { super(_backend,_defaultOption);}

  prepareRequest(options:RequestOptions){
    if(options == null || typeof(options) == "undefined"){
        options = new RequestOptions();
    }
    let headers = new Headers();
    options.headers.append("authorization", localStorage.getItem('authorization'));
    return this;
  }

}
