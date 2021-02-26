import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  // submitCommentUrl = 'https://mwa-project-2020-b.herokuapp.com/api/post/comment';
  // submitLikeUrl = 'https://mwa-project-2020-b.herokuapp.com/api/post/like';
  // submitUnlikeUrl = 'https://mwa-project-2020-b.herokuapp.com/api/post/unlike';

  submitCommentUrl = environment.baseUrl + '/post/comment';
  submitLikeUrl = environment.baseUrl + '/post/like';
  submitUnlikeUrl = environment.baseUrl + '/post/unlike';

  constructor(private http: HttpClient) {}

  sendComment(data, header) {
    return this.http
      .post(this.submitCommentUrl, data, { headers: header })
      .pipe(catchError(this.handleError));
  }

  submitLike(data, header) {
    return this.http
      .post(this.submitLikeUrl, data, { headers: header })
      .pipe(catchError(this.handleError));
  }

  submitUnlike(data, header) {
    return this.http
      .post(this.submitUnlikeUrl, data, { headers: header })
      .pipe(catchError(this.handleError));
  }

  private handleError(error) {
    if (error instanceof HttpErrorResponse) {
      // Server side error
      console.log('Server side error', error);
    } else {
      // client side error
      console.log('Client side error', error);
    }
    return throwError(error);
  }
}
