package org.example.hongchengai.service;

import org.example.hongchengai.pojo.dto.ReceiveMessageDto;
import org.example.hongchengai.pojo.dto.ReturnMessageDto;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


public class ReturnService implements IReturnService {
    /**
     *
     * @param receiveMessageDto 用户传来的数据
     * @param answerTimes   回答次数
     * @return  处理好的返回数据
     */
    @Override
    public ReturnMessageDto returnResult(ReceiveMessageDto receiveMessageDto,int answerTimes) throws Exception{
        IIOService ioService = new IOService();
        String questionsPath = "F:\\AI\\questions.txt";
        String answersPath = "F:\\AI\\answers.txt";
        ioService.writeFile(questionsPath, receiveMessageDto.getMessage());
        Path path = Paths.get(answersPath);

        // 获取文件所在的目录
        Path dir = path.getParent();

        // 创建WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // 注册WatchService来监听目录内的变化事件（创建、修改、删除）
        dir.register(watchService, ENTRY_MODIFY);

        System.out.println("监听文件的变化: " + path.getFileName());

        // 等待直到事件发生 (阻塞)
        WatchKey key = watchService.take();

        // 遍历所有事件
        for (WatchEvent<?> event : key.pollEvents()) {
            // 获取事件的类型
            WatchEvent.Kind<?> kind = event.kind();

            // 获取发生变化的文件名
            Path changedFile = (Path) event.context();

            // 检查是否是我们要监听的特定文件
            if (kind == ENTRY_MODIFY && changedFile.equals(path.getFileName())) {
                System.out.println("文件已修改: " + changedFile);
                // 这里可以添加对文件变化的处理逻辑
                break;  // 停止监听，如果只需要检测一次变化
            }
        }
        watchService.close();



        ReturnMessageDto returnMessageDto = new ReturnMessageDto(answerTimes+1,"ai",
                ioService.readFile(answersPath),true,false,false);

        return returnMessageDto;
    }
}
