import { Controller, Get, Req } from '@nestjs/common';

@Controller('/api/v1/users')
export class UserController {
  @Get()
  getListOfUsers(@Req() request: Request) {
    console.log(request);
  }
}
