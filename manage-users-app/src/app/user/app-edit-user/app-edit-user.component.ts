import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-edit-user',
  templateUrl: './app-edit-user.component.html',
  styleUrls: ['./app-edit-user.component.scss']
})
export class AppEditUserComponent implements OnInit{
  constructor(private service:UserService) { }

  @Input() user:User;
  firstName:string;
  lastName:string;
  email:string;
  pass:string;

  ngOnInit(): void {
    this.firstName=this.user.firstname;
     this.lastName=this.user.lastname; 
     this.email=this.user.email;
     this.pass=this.user.pass;
  }

  addUser(){
    const val: User = {
      firstname : this.firstName,
      lastname : this.lastName,
      email :this.email,
      pass : this.pass
    };
    this.service.addUser(val).subscribe(res=>{
      alert(res.toString());
    });
  }

  updateUser(){
    var val={
      id : this.user.id,
      firstname:this.firstName,
      lastname : this.lastName,
      email:this.email,
      pass:this.pass
    };
    this.service.updateUser(val,this.user.id).subscribe(res=>{
      alert(res.toString());
    });

  }
}
