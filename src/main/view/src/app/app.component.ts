import { Component, OnInit } from '@angular/core';


import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../styles/global.css';
import {ButtonTimerComponent} from "./components/example-base-component/button-timer.component";
import {AuthHttpService} from "./services/authHttp.service";


@Component({
  selector: 'app-container',
  template: require('./app.component.html'),
  styles: [require('./app.component.css')],
  providers: [
    AuthHttpService
  ],

  directives: [
    ButtonTimerComponent
  ]
})

export class AppComponent implements OnInit {

  constructor(private http:AuthHttpService) {
    console.log(" AppComponent constructor :", "run step constructor ");
    this.http.authGet('http://localhost:8088/index/1').subscribe(res=> console.log(res.json()))
  }

  ngOnInit(){
    console.log("sss");
  }
}
