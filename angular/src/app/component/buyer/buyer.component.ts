import { query } from '@angular/animations';
import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { lastValueFrom} from 'rxjs';
import { ScrapeResult } from 'src/app/models/scrapResult.model';

@Component({
  selector: 'app-buyer',
  templateUrl: './buyer.component.html',
  styleUrls: ['./buyer.component.css']
})
export class BuyerComponent implements OnInit {

  searchForm!: FormGroup;
  searchResult!: String;
  query!: Promise<String>;
  noQueryResults: boolean = true;
  results!: ScrapeResult[];
  constructor(private fb: FormBuilder,
              private http: HttpClient) { }


  ngOnInit(): void {
    this.searchForm = this.fb.group({
      search: this.fb.control('', [Validators.required])

    })
  }

  ScrapeSearchSB(){
    this.searchResult = this.searchForm.value();
    console.log('Search result --> '+ this.searchResult);
    this.query = lastValueFrom(this.http.post<String>('api/buyer/search', JSON.stringify(this.searchResult)));
    let resolve = this.query.then(results => {
      this.noQueryResults = false;

    })

  }


}
