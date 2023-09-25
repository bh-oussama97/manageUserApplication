import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'show-users',
  templateUrl: './show-users.component.html',
  styleUrls: ['./show-users.component.scss']
})
export class ShowUsersComponent implements OnInit{
  constructor(private service: UserService) { }

  UsersList: User[] ;
  ModalTitle:string;
  ActiveAddEditUserComp:boolean=false;
  user:User;


  ngOnInit(): void {
    this.refreshUsersList();
  }

  refreshUsersList(){
    this.service.getUsers().subscribe(data=>{
      this.UsersList = data;
    })
  }

  addClick(){
    this.user={
      id:0,
      firstname : "",
      lastname:"",
      email : "",
      pass : ""
    }
    this.ModalTitle = "Add User";
    this.ActiveAddEditUserComp = true;
  }

  editClick(item){
    this.user=item;
    this.ModalTitle = "Edit User";
    this.ActiveAddEditUserComp = true;

  }

  deleteClick(item){
    if(confirm('Are you sure??')){
      this.service.deleteUser(item.id).subscribe((data:any)=>{
        console.log("daata",data);
        alert(data.toString());
        this.refreshUsersList();
      });
    }

  }

  closeClick(){
    this.ActiveAddEditUserComp = false;
    this.refreshUsersList();
  }
}
