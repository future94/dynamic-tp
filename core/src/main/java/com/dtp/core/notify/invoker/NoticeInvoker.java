package com.dtp.core.notify.invoker;

import com.dtp.common.pattern.filter.Invoker;
import com.dtp.core.context.BaseNotifyCtx;
import com.dtp.core.context.DtpNotifyCtxHolder;
import com.dtp.core.context.NoticeCtx;
import com.dtp.core.handler.NotifierHandler;

/**
 * NoticeInvoker related
 *
 * @author: yanhom
 * @since 1.0.8
 */
public class NoticeInvoker implements Invoker<BaseNotifyCtx> {

    @Override
    public void invoke(BaseNotifyCtx context) {
        DtpNotifyCtxHolder.set(context);
        NoticeCtx noticeCtx = (NoticeCtx) context;
        NotifierHandler.getInstance().sendNoticeAsync(noticeCtx.getProp(), noticeCtx.getDiffs());
    }
}
