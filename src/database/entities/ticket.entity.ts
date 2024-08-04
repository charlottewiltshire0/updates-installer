import { Column, Entity, ManyToOne, PrimaryGeneratedColumn } from 'typeorm';
import { UserEntity } from './user.entity';
import { DeviceEntity } from './device.entity';

@Entity({ name: 'tickets' })
export class TicketEntity {
  @PrimaryGeneratedColumn('uuid')
  id!: string;

  @Column({ type: 'varchar', nullable: false })
  installer_id!: string;

  @ManyToOne(() => UserEntity, (user) => user.tickets, { nullable: true })
  user_id!: UserEntity | null;

  @Column({ type: 'varchar', nullable: false })
  device_id!: string;

  @ManyToOne(() => DeviceEntity, (device) => device.tickets)
  device!: DeviceEntity;
}
