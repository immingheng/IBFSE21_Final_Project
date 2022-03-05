// Angular
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes, CanActivate } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

// Auth0
import { AuthModule, AuthHttpInterceptor } from '@auth0/auth0-angular';

// FontAwesome-5
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faKey, faUser, faEnvelope } from '@fortawesome/free-solid-svg-icons'

// Created Components/Services
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { AboutComponent } from './component/about/about.component';
import { ContactComponent } from './component/contact/contact.component';
import { LoginComponent } from './authentication/login/login.component';
import { SignupComponent } from './component/signup/signup.component';
import { BuyerComponent } from './component/buyer/buyer.component';
import { SellerComponent } from './component/seller/seller.component';
import { SellerGuardService } from './services/seller-guard.service';
import { AddNewItemComponent } from './component/add-new-item/add-new-item.component';
import { ForgetPasswordComponent } from './authentication/forget-password/forget-password.component';
import { ShopeeItemsService } from './services/Shopee.service';
import { LazadaItemsService } from './services/Lazada.service';



// Apply canActivate: [SellerGuardService] to prevent unauthorised access to Seller & addItem.
const appRoutes : Routes = [
  {path:"", component:HomeComponent},
  {path:"about", component:AboutComponent},
  {path:"contact", component:ContactComponent},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"buyer", component:BuyerComponent},
  {path:"seller", component:SellerComponent},
  {path:"seller/addItem", component:AddNewItemComponent},
  {path:"forgetPassword", component:ForgetPasswordComponent},
  {path:'**',redirectTo:'/', pathMatch:'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    LoginComponent,
    SignupComponent,
    BuyerComponent,
    SellerComponent,
    AddNewItemComponent,
    ForgetPasswordComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FontAwesomeModule,
    AuthModule.forRoot({
      // Domain and client of Auth0 SPA-App
      domain:'dev-r01a92vl.us.auth0.com',
      clientId:'KhnVRfaSBikVDALT74nTsEGNpkatLvCq',

      //Specify audience and scope values required by API to call, as well as routes that should be intercepted by AuthHttpInterceptor

      // CHECK TOKEN EXISTS WHEN MAKING THE API CALL
      // HAVE TO CHANGE THIS FOR PRODUCTION
      // Request audience at user authentication
      // audience: 'http://localhost:4200',

      // Request this scope at user authentication time
      scope: 'read:current_user',

      // Specify configuration for interceptor
      // Interceptor will intercept any request to the specified uri to check if token exists and handle it accordingly.
      httpInterceptor: {
        allowedList:[
          {
            // Match any request that during development
            uri:'http://localhost:8080/api/*',
            tokenOptions: {
              // The attached token should target this audience
              audience: 'http://localhost:8080',

              // The attached token scope
              scope: 'read:current_user'
            }
          },
          // {
          //   // prod
          //   uri:'https://my-cute-shop.herokuapp.com/api/*',
          //   tokenOptions:{
          //     audience: 'https://my-cute-shop.herokuapp.com',
          //     scope: 'read:current_user'
          //   }
          // }

        ]
      }

    })
    ],
  providers: [ShopeeItemsService, LazadaItemsService, SellerGuardService,
    // Adding Auth0 HTTP Interceptor to the providers
    {provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptor, multi:true}],

  bootstrap: [AppComponent]
})

export class AppModule {
  constructor(library: FaIconLibrary){
    library.addIcons(faKey);
    library.addIcons(faUser);
    library.addIcons(faEnvelope);
  }
}
