import { Module } from '@nestjs/common';
import { ManagementModule } from './management/management.module';
import { TicketsModule } from './tickets/tickets.module';

@Module({
  imports: [ManagementModule, TicketsModule],
})
export class UserModule {}
