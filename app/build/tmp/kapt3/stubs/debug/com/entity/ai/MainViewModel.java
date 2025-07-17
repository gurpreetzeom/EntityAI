package com.entity.ai;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u001c\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/entity/ai/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "TAG", "", "_chatHistory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/entity/ai/ChatMessage;", "aiProcessor", "Lcom/entity/ai/AIProcessor;", "chatHistory", "Lkotlinx/coroutines/flow/StateFlow;", "getChatHistory", "()Lkotlinx/coroutines/flow/StateFlow;", "cloudSync", "Lcom/entity/ai/CloudSyncService;", "loadChatHistory", "", "processInput", "input", "onComplete", "Lkotlin/Function0;", "testAWSConfiguration", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    private final java.lang.String TAG = "MainViewModel";
    private final com.entity.ai.AIProcessor aiProcessor = null;
    private final com.entity.ai.CloudSyncService cloudSync = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.entity.ai.ChatMessage>> _chatHistory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.entity.ai.ChatMessage>> chatHistory = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.entity.ai.ChatMessage>> getChatHistory() {
        return null;
    }
    
    private final void testAWSConfiguration() {
    }
    
    public final void processInput(@org.jetbrains.annotations.NotNull
    java.lang.String input, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onComplete) {
    }
    
    public final void loadChatHistory() {
    }
}