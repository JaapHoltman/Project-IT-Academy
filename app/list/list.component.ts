import { Component, OnInit } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers:  [FormService]
})
export class ListComponent implements OnInit {

  forms: Form[];

  

  constructor(private formService: FormService) { }

  ngOnInit() {
    this.getAllForms();
  }

  getAllForms() {
    this.formService.findAll().subscribe(
      forms => {
        this.forms = forms;
      },
      err => {
        console.log(err);
      }
    );
  }
  delete(id) {
    this.formService.delete(id).subscribe(
      () => this.getAllForms()
    );
  }
  
// ngOnInit() {
  //   this.loadForms();
  // }
  // loadForms(){
  //     this.formService.getForms().subscribe(
  //       forms => this.forms = forms
      
  //       );
  //   }
}
