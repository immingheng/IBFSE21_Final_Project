import { Component, OnInit } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
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
              private router: Router,
              private domSanitizer: DomSanitizer) { }

  async ngOnInit(){
    const shop_id = await this.activatedRoute.snapshot.queryParams['shop_id'];
    console.log(shop_id);
    if (shop_id==null){
      console.log("queryParams of shop_id does not exists!")
      this.shopeeLinked = false;
    } else {
      this.shopeeLinked = true;
    }

  }

  items!: Item[];
  shopeeItems!: Item[];
  lazadaItems!: Item[];
  imageUrls: SafeResourceUrl[] = [];
  imageUrl!: SafeResourceUrl;

  // Both lazada and shopee are not linked at first
  shopeeLinked: boolean = false;
  lazadaLinked: boolean = false;


  public getShopeeListings(){
    this.shopeeSvc.getListings().then(r=>{
      this.shopeeItems = r;
      console.log(r);
      r.forEach(item=>{
        let itemImage = item.image.replace('"','');
        itemImage = itemImage.replace('"','');
        console.log(itemImage.toString());
        this.imageUrl = this.domSanitizer.bypassSecurityTrustUrl(itemImage);
        this.imageUrls.push(this.imageUrl);
      })
      console.log(this.imageUrls);

    });
  }



  public unlinkShop(){
  }


}
