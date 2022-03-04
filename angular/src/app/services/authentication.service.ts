import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";

@Injectable()
export class AuthService{

  authenticated: boolean = false;

  constructor(private http:HttpClient){}

  public async loginUser(username: String){
    let message = await lastValueFrom(this.http.get(`api/auth/user/${username}`))
  }



}
