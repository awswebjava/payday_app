package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class msgsqs extends GXProcedure
{
   public msgsqs( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( msgsqs.class ), "" );
   }

   public msgsqs( int remoteHandle ,
                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      msgsqs.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      msgsqs.this.AV8CliCod = aP0;
      msgsqs.this.AV19body = aP1;
      msgsqs.this.AV15QueueUrl = aP2;
      msgsqs.this.AV20MessageGroupId = aP3;
      msgsqs.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtAWSConfiguration1[0] = AV13AWSConfiguration;
      new web.getawsconf_sqs_eb(remoteHandle, context).execute( GXv_SdtAWSConfiguration1) ;
      AV13AWSConfiguration = GXv_SdtAWSConfiguration1[0] ;
      AV12SendMessageRequest.setgxTv_SdtSendMessageRequest_Messagebody( AV19body );
      AV12SendMessageRequest.setgxTv_SdtSendMessageRequest_Queueurl( AV15QueueUrl );
      if ( ! (GXutil.strcmp("", AV20MessageGroupId)==0) )
      {
         AV12SendMessageRequest.setgxTv_SdtSendMessageRequest_Messagegroupid( GXutil.trim( AV20MessageGroupId) );
         GXt_dtime2 = AV22ahora ;
         GXv_dtime3[0] = GXt_dtime2 ;
         new web.getahora(remoteHandle, context).execute( AV8CliCod, GXv_dtime3) ;
         msgsqs.this.GXt_dtime2 = GXv_dtime3[0] ;
         AV22ahora = GXt_dtime2 ;
         AV21MessageDeduplicationId = localUtil.ttoc( AV22ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ") ;
         AV21MessageDeduplicationId = GXutil.strReplace( AV21MessageDeduplicationId, "\\/", "_") ;
         AV21MessageDeduplicationId = GXutil.strReplace( AV21MessageDeduplicationId, "/", "_") ;
         AV21MessageDeduplicationId = GXutil.strReplace( AV21MessageDeduplicationId, " ", "_") ;
         AV21MessageDeduplicationId = GXutil.strReplace( AV21MessageDeduplicationId, ":", "_") ;
         AV24random = DecimalUtil.doubleToDec(GXutil.random( )) ;
         AV21MessageDeduplicationId += GXutil.strReplace( GXutil.str( AV24random, 11, 9), ".", "_") ;
         AV21MessageDeduplicationId = GXutil.strReplace( AV21MessageDeduplicationId, ",", "_") ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV27Pgmname, httpContext.getMessage( "&MessageDeduplicationId ", "")+AV21MessageDeduplicationId) ;
         AV12SendMessageRequest.setgxTv_SdtSendMessageRequest_Messagededuplicationid( GXutil.trim( AV21MessageDeduplicationId) );
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV27Pgmname, httpContext.getMessage( "reciiibe ", "")+AV19body) ;
      GXv_SdtSendMessageResponse4[0] = AV11SendMessageResponse;
      GXv_objcol_SdtMessages_Message5[0] = AV10Messages ;
      GXv_boolean6[0] = AV9Success ;
      new com.gxawssdk.aws.sqs.sendmessagequeue(remoteHandle, context).execute( AV13AWSConfiguration, AV12SendMessageRequest, GXv_SdtSendMessageResponse4, GXv_objcol_SdtMessages_Message5, GXv_boolean6) ;
      AV11SendMessageResponse = GXv_SdtSendMessageResponse4[0] ;
      AV10Messages = GXv_objcol_SdtMessages_Message5[0] ;
      msgsqs.this.AV9Success = GXv_boolean6[0] ;
      if ( ! AV9Success )
      {
         AV18i = (short)(1) ;
         while ( AV18i <= AV10Messages.size() )
         {
            AV17error += ((com.genexus.SdtMessages_Message)AV10Messages.elementAt(-1+AV18i)).getgxTv_SdtMessages_Message_Description() ;
            if ( AV18i < AV10Messages.size() )
            {
               AV17error += ". " ;
            }
            AV18i = (short)(AV18i+1) ;
         }
         System.out.println( httpContext.getMessage( "Falló mensaje a SQS", "") );
         System.out.println( httpContext.getMessage( "&SendMessageResponse ", "")+AV11SendMessageResponse.toJSonString(false, true) );
         System.out.println( httpContext.getMessage( "&Messages ", "")+AV10Messages.toJSonString(false) );
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV27Pgmname, httpContext.getMessage( "&Success ", "")+GXutil.trim( GXutil.booltostr( AV9Success))) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV27Pgmname, httpContext.getMessage( "&SendMessageResponse ", "")+AV11SendMessageResponse.toJSonString(false, true)) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV27Pgmname, httpContext.getMessage( "&Messages ", "")+AV10Messages.toJSonString(false)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = msgsqs.this.AV17error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17error = "" ;
      AV13AWSConfiguration = new com.gxawssdk.aws.common.SdtAWSConfiguration(remoteHandle, context);
      GXv_SdtAWSConfiguration1 = new com.gxawssdk.aws.common.SdtAWSConfiguration[1] ;
      AV12SendMessageRequest = new com.gxawssdk.aws.sqs.SdtSendMessageRequest(remoteHandle, context);
      AV22ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime2 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime3 = new java.util.Date[1] ;
      AV21MessageDeduplicationId = "" ;
      AV24random = DecimalUtil.ZERO ;
      AV27Pgmname = "" ;
      AV11SendMessageResponse = new com.gxawssdk.aws.sqs.SdtSendMessageResponse(remoteHandle, context);
      GXv_SdtSendMessageResponse4 = new com.gxawssdk.aws.sqs.SdtSendMessageResponse[1] ;
      AV10Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      GXv_objcol_SdtMessages_Message5 = new GXBaseCollection[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV27Pgmname = "msgSQS" ;
      /* GeneXus formulas. */
      AV27Pgmname = "msgSQS" ;
      Gx_err = (short)(0) ;
   }

   private short AV18i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private java.math.BigDecimal AV24random ;
   private String AV20MessageGroupId ;
   private String AV21MessageDeduplicationId ;
   private String AV27Pgmname ;
   private java.util.Date AV22ahora ;
   private java.util.Date GXt_dtime2 ;
   private java.util.Date GXv_dtime3[] ;
   private boolean AV9Success ;
   private boolean GXv_boolean6[] ;
   private String AV19body ;
   private String AV15QueueUrl ;
   private String AV17error ;
   private com.gxawssdk.aws.sqs.SdtSendMessageRequest AV12SendMessageRequest ;
   private String[] aP4 ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV10Messages ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> GXv_objcol_SdtMessages_Message5[] ;
   private com.gxawssdk.aws.common.SdtAWSConfiguration AV13AWSConfiguration ;
   private com.gxawssdk.aws.common.SdtAWSConfiguration GXv_SdtAWSConfiguration1[] ;
   private com.gxawssdk.aws.sqs.SdtSendMessageResponse AV11SendMessageResponse ;
   private com.gxawssdk.aws.sqs.SdtSendMessageResponse GXv_SdtSendMessageResponse4[] ;
}

