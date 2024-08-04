import {
  Column,
  Entity,
  JoinColumn,
  ManyToOne,
  OneToMany,
  PrimaryGeneratedColumn,
} from 'typeorm';
import { UserEntity } from './user.entity';
import { TicketEntity } from './ticket.entity';

@Entity({ name: 'devices' })
export class DeviceEntity {
  @PrimaryGeneratedColumn('uuid')
  id!: string;

  @Column({ type: 'varchar', nullable: false })
  device_type!: string;

  @Column({ type: 'varchar', nullable: false })
  device_model!: string;

  @Column({ type: 'varchar', nullable: true })
  os_version?: string | null;

  @Column({ type: 'varchar', nullable: false })
  platform!: string;

  @Column({ type: 'varchar', nullable: false })
  architecture!: string;

  @ManyToOne(() => UserEntity, (user) => user.devices, { nullable: true })
  @JoinColumn({ name: 'user_id' })
  user_id: UserEntity;

  @OneToMany(() => TicketEntity, (ticket) => ticket.device)
  tickets: TicketEntity[];
}
