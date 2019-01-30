import { Component, OnInit } from '@angular/core';
import { SearchService } from '../search.service';
import { Search } from '../search';
import {FormBuilder, Validators} from '@angular/forms';
import { Form } from '../form';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  providers:  [SearchService]
})
export class SearchComponent implements OnInit {
  empty = false
  full = true
  showForm: Form

  constructor(public fb: FormBuilder, private searchService: SearchService) { }

  ngOnInit() {
    
  }
  public form = this.fb.group({
    search: ['', Validators.required],
  
  });
  public saveSearch(event) {
    
    const search = this.form.controls['search'].value;

    this.searchService.saveSearch(new Search(search)).subscribe(forms =>{
      this.showForm = forms[0] 
      this.empty = true
      this.full = false
    }
      
      
      // () => this.list.getAllForms()
    );
  }

}
