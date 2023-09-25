import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly APIUrl ="http://localhost:8081/user";

  constructor(private http:HttpClient) { }


  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.APIUrl+'/all');
  }

  addUser(val:User):Observable<any>{
    return this.http.post<User>(this.APIUrl+'/add',val);
  }

  updateUser(val:User,id:number):Observable<any>{
    return this.http.put(this.APIUrl+'/update/'+id,val);
  }

  deleteUser(id:number):Observable<any>{
    return this.http.delete(this.APIUrl+'/delete/'+id);
  }

}
