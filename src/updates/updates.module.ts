import { Module } from '@nestjs/common';
import { DownloadModule } from './download/download.module';
import { UploadModule } from './upload/upload.module';
import { VerisonModule } from './verison/verison.module';

@Module({
  imports: [DownloadModule, UploadModule, VerisonModule],
})
export class UpdatesModule {}
