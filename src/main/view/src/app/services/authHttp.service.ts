import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';

// Just for example, to initiaze variables in constructor
import { Http,Headers,RequestOptions} from '@angular/http';

@Injectable()
export class AuthHttpService{

  options:RequestOptions;

  constructor(private http:Http){
    console.log(this.http)
    this.http=http;
    console.log(this.http)
    let headers = new Headers({'Content-Type':'applicastion/json','Authorization':'Basic c2VsZW5hNDU6MTExMTEx'})
    this.options = new RequestOptions({headers:headers})
  }

  authGet(url:string){
    return this.http.get(url,this.options);
  }
}
