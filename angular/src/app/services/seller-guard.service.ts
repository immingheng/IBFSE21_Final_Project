import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";

@Injectable()
export class SellerGuardService implements CanActivate{

  constructor(private router: Router){}

  // THIS IS INJECTED TO app.component to check if user has logged in
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    this.router.navigate(['login']);
    throw new Error("Method not implemented.");

    //TODO SHOULD BE ABLE TO CHECK IF USER HAS LOGGED IN VIA HAVING JWT TOKEN IF POSSIBLE
  }

}
