import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes, CanActivate } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'

import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { faKey, faUser, faEnvelope } from '@fortawesome/free-solid-svg-icons'


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
import { AuthModule } from '@auth0/auth0-angular';


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
      domain:'dev-r01a92vl.us.auth0.com',
      clientId:'KhnVRfaSBikVDALT74nTsEGNpkatLvCq'
    })
    ],
  providers: [ShopeeItemsService, LazadaItemsService, SellerGuardService],
  bootstrap: [AppComponent]
})

export class AppModule {
  constructor(library: FaIconLibrary){
    library.addIcons(faKey);
    library.addIcons(faUser);
    library.addIcons(faEnvelope);
  }
}
