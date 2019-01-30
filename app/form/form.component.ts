import { Component, OnInit, Input } from '@angular/core';
import { Form } from '../form';
import { FormService } from '../form.service';
import { ListComponent } from '../list/list.component';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  providers:  [FormService]
})
export class FormComponent implements OnInit {

  @Input()
  list: ListComponent;
  form: FormGroup;
  submitted = false;

  constructor(public formBuilder: FormBuilder, private formService: FormService) {}
  
  ngOnInit() {
  this.form = this.formBuilder.group({
    town: ['', Validators.required],
    skiarea: ['', Validators.required],
    sizeskiarea: ['', [Validators.required, Validators.pattern('^[0-9]*')]],
    snowheight: ['', [Validators.required, Validators.pattern('^[0-9]*')]],
    mapskiarea: ['', Validators.required],
    liftsopened: ['', [Validators.required, Validators.pattern('^[0-9,/]*')]],
    foto: ['', Validators.required]
    });
  }

   
    get f() { return this.form.controls; }
  

  public saveForm(event) {

    const town = this.form.controls['town'].value;
    const skiarea = this.form.controls['skiarea'].value;
    const sizeskiarea = this.form.controls['sizeskiarea'].value;
    const snowheight = this.form.controls['snowheight'].value;
    const mapskiarea = this.form.controls['mapskiarea'].value;
    const liftsopened = this.form.controls['liftsopened'].value;
    const foto = this.form.controls['foto'].value;
    this.formService.saveUser(new Form(0, town, skiarea, sizeskiarea, snowheight, mapskiarea, liftsopened, foto)).subscribe(
    );
    this.submitted = true;
  
  }
}

  




// oude versie, misschien in de toekomst nog een handig voorbeeld
  // form = new Form();

  // forms

  // constructor(private formService: FormService) { }

  // ngOnInit() {
  //   this.loadForms();
  // }
  // sendForm(){
  //   console.log("in sendForm");
  //   console.log("form: " + this.form);

  //   this.formService.postForm(this.form);

  // }
  // loadForms(){
  //   this.formService.getForms().subscribe(forms => this.forms = forms);
  // }

// }
