import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { Item } from "../models/item.model";
import { Listing } from "../models/listing.model";

@Injectable()
export class ShopeeItemsService{

  constructor(private http: HttpClient){
  }

  items!:Item[];
  item_ids: number[] = [];
  data!: Listing;
  public getListings(): Promise<Item[]> {
    return lastValueFrom(this.http.get<Item[]>('api/shopee/listings'));
  };



}
