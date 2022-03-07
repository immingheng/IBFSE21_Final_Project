import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { Item } from 'src/app/models/item.model';
import { LazadaItemsService } from 'src/app/services/Lazada.service';
import { ShopeeItemsService } from 'src/app/services/Shopee.service';

@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrls: ['./seller.component.css']
})
export class SellerComponent implements OnInit {

  constructor(private shopeeSvc: ShopeeItemsService,
              private lazadaSvc: LazadaItemsService,
              private activatedRoute: ActivatedRoute,
              private domSanitizer: DomSanitizer,
              private http: HttpClient) { }

  shop_id: any;
  shopee_id: any;
  items!: Item[];
  shopeeItems!: Item[];
  lazadaItems!: Item[];
  imageUrls: SafeResourceUrl[] = [];
  imageUrl!: SafeResourceUrl;

  // Both lazada and shopee are not linked at first
  shopeeLinked: boolean = false;
  shopeeExists!: boolean;
  lazadaLinked: boolean = false;


  async ngOnInit(){
    // check if user exists on db and extract shopee_shop_id by making a call to the backend
    lastValueFrom(this.http.get<Number>('http://localhost:8080/api/auth/user/shopee_shop_id')).then(r=>{
      this.shopee_id = r;
      console.log(this.shopee_id);
      if (this.shopee_id!=null){
        this.shopeeExists = true;
        this.shop_id=this.shopee_id;
        console.log("this.shop_id is "+this.shop_id);
      } else {
        this.shopeeExists = false;
      }
    }).catch(err=>{
      console.log('SHOPEE SHOP IS NOT LINKED TO THIS USER');
      console.log(err);
    }

    );

    if (this.shop_id==0){
      this.shop_id = await this.activatedRoute.snapshot.queryParams['shop_id'];
      console.log(this.shop_id);
      if (this.shop_id==null){
        console.log("queryParams of shop_id does not exists!")
      this.shopeeLinked = false;
      } else {
      this.shopeeLinked = true;
      }
    }
  }



  public getShopeeListings(){
    this.shopeeSvc.getListings(this.shop_id).then(r=>{
      this.shopeeItems = r;
      console.log(r);
      r.forEach(item=>{
        let itemImage = item.image.replace('"','');
        itemImage = itemImage.replace('"','');
        // console.log(itemImage.toString());
        // ANGULAR BY DEFAULT WILL WANT TO SANITISE THIS TO PROTECT ONE FROM XSS SCRIPTING THEREFORE HAVE TO SANITISE IMAGE URL WITH DOMSANITIZER FOR IMAGES TO BE DISPLAYED
        this.imageUrl = this.domSanitizer.bypassSecurityTrustUrl(itemImage);
        this.imageUrls.push(this.imageUrl);
      })
      // console.log(this.imageUrls);
    })
    .catch(err=>{
      alert('Something went wrong!');
      console.log(err);
    })
  }


  public getLazadaListings(){
    //TODO
  }



  public unlinkShop(){
    this.shop_id = null;
  }


}
