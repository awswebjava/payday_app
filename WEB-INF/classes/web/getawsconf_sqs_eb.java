package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getawsconf_sqs_eb extends GXProcedure
{
   public getawsconf_sqs_eb( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getawsconf_sqs_eb.class ), "" );
   }

   public getawsconf_sqs_eb( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public com.gxawssdk.aws.common.SdtAWSConfiguration executeUdp( )
   {
      getawsconf_sqs_eb.this.aP0 = new com.gxawssdk.aws.common.SdtAWSConfiguration[] {new com.gxawssdk.aws.common.SdtAWSConfiguration()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( com.gxawssdk.aws.common.SdtAWSConfiguration[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( com.gxawssdk.aws.common.SdtAWSConfiguration[] aP0 )
   {
      getawsconf_sqs_eb.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "sqs_AK", ""), GXv_char2) ;
      getawsconf_sqs_eb.this.GXt_char1 = GXv_char2[0] ;
      AV8AWSConfiguration.setgxTv_SdtAWSConfiguration_Accesskey( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "sqs_SK", ""), GXv_char2) ;
      getawsconf_sqs_eb.this.GXt_char1 = GXv_char2[0] ;
      AV8AWSConfiguration.setgxTv_SdtAWSConfiguration_Secretkey( GXt_char1 );
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new web.getmetaparmvalue(remoteHandle, context).execute( httpContext.getMessage( "sqs_R", ""), GXv_char2) ;
      getawsconf_sqs_eb.this.GXt_char1 = GXv_char2[0] ;
      AV8AWSConfiguration.setgxTv_SdtAWSConfiguration_Region( GXt_char1 );
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getawsconf_sqs_eb.this.AV8AWSConfiguration;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8AWSConfiguration = new com.gxawssdk.aws.common.SdtAWSConfiguration(remoteHandle, context);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private com.gxawssdk.aws.common.SdtAWSConfiguration[] aP0 ;
   private com.gxawssdk.aws.common.SdtAWSConfiguration AV8AWSConfiguration ;
}

