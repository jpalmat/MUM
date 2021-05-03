import { TestBed, async, inject } from '@angular/core/testing';

import { UserdetailsGuardGuard } from './userdetails-guard.guard';

describe('UserdetailsGuardGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserdetailsGuardGuard]
    });
  });

  it('should ...', inject([UserdetailsGuardGuard], (guard: UserdetailsGuardGuard) => {
    expect(guard).toBeTruthy();
  }));
});
