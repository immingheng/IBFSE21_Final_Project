import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  // FOR DATE IN FOOTER
  title = 'angular';
  d = new Date();
  year = this.d.getFullYear();

  @Input()
  isLoggedIn: boolean = true;

  ngOnInit(): void {
  }

  constructor(){
  }

  public logout(){
    this.isLoggedIn = false;
    alert('You have logged out!');
  }





}
