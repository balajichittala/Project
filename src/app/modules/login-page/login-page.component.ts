import { Component, OnInit, signal } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { SharedService } from '../../services/shared.service';
import { RegisterUser, User, UserResponse } from '../../models/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.scss'
})
export class LoginPageComponent implements OnInit {

  loginForm!: FormGroup;
  registerationForm!: FormGroup;
  showUserLogin = false;
  showvendorLogin = false;
  showCreateNew = false;
  invalidCredentials = false;

  successAlert = false;
  successMsg = '';
  failureAlert = false;
  failureMsg = ''; 

  showLoader = false;
  loaderText = '';

  constructor(private fb: FormBuilder, private sharedService: SharedService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.registerationForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.compose([Validators.required, Validators.minLength(6)])],
      email: ['', Validators.compose([Validators.required, Validators.email,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')])],
      role: ['U', Validators.required],
      phone: ['', Validators.required]
    });
  }

  hide = signal(true);
  
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  showLoginType(type: string) {
    this.invalidCredentials = false;
    this.loginForm.markAsUntouched();
    if(type == 'user') {
      this.showUserLogin = true;
      this.showvendorLogin = false;
      this.showCreateNew = false;
    } 
    
    if(type == 'vendor') {
      this.showvendorLogin = true;
      this.showUserLogin = false;
      this.showCreateNew = false;
    }

    if(type == 'new') {
      this.showCreateNew = true;
      this.showvendorLogin = false;
      this.showUserLogin = false;
    }


  }

  clearForm() {
    this.loginForm.controls['email'].patchValue('');
    this.loginForm.controls['password'].patchValue('');
    if(this.invalidCredentials) {
      this.loginForm.markAllAsTouched();
    }
  }

  login(): void {
    const body = new User();
    body.email = this.loginForm.controls['email'].value;
    body.password = this.loginForm.controls['password'].value;


    this.sharedService.userLogin(body).subscribe({
      next: (data: UserResponse) => {
        this.invalidCredentials = false;
        this.sharedService.loggedInUser = data;
        this.sharedService.isUserLoggedIn = true;
        this.router.navigateByUrl(data.role === 'U' ? 'user-landing' : 'vendor-landing');
        console.log(data);
      }, error: (error: HttpErrorResponse) => {
        this.invalidCredentials = true;
        this.clearForm();
      } 
    });

  }

  register(): void {
    this.showLoader = true;
    this.loaderText = 'Registering......';
    const body = new RegisterUser();
    body.username = this.registerationForm.controls['username'].value;
    body.password = this.registerationForm.controls['password'].value;
    body.email = this.registerationForm.controls['email'].value;
    body.phone = this.registerationForm.controls['phone'].value;
    body.role = this.registerationForm.controls['role'].value;

    this.sharedService.registerUser(body).subscribe({
      next: (data: string) => {
        this.showLoader = false;
        this.successAlert = true;
        this.failureAlert = false;
        this.successMsg = 'Registration Successful';
        this.failureMsg = '';

        setTimeout(() => {
          this.showLoader = true;
          this.loaderText = 'Logging In ............'
          const Loginbody = new User();
          Loginbody.email = body.email;
          Loginbody.password = body.password;
      
      
          this.sharedService.userLogin(body).subscribe({
            next: (data: UserResponse) => {
              this.invalidCredentials = false;
              this.sharedService.loggedInUser = data;
              this.sharedService.isUserLoggedIn = true;
              this.showLoader = false;
              this.router.navigateByUrl(data.role === 'U' ? 'user-landing' : 'vendor-landing');
              console.log(data);
            }, error: (error: HttpErrorResponse) => {
              this.invalidCredentials = true;
              this.showLoader = false;
              this.clearForm();
            } 
          });

        }, 2000)

      }, error: (error: HttpErrorResponse) => {
        this.showLoader = false;
        this.successAlert = false;
        this.failureAlert = true;
        this.successMsg = '';
        this.failureMsg = 'Account Already Exists';
      } 
    });
  }

  numberOnly(event: Event): void {
    const input = event.target as HTMLInputElement;
    input.value = input.value.replace(/[^0-9]/g, "");
  }
}