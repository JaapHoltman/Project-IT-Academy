import { Component, OnInit, } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
  providers:  [FormService]
})
export class DetailsComponent implements OnInit {

  form

  constructor(private formService: FormService) { }

  ngOnInit() {
    this.findOne(1);
  }
  
  
  findOne(id) {
    this.formService.findOne(id).subscribe(form => this.form = form
      // () => this.getAllForms()
      
    );
  }
  

}
