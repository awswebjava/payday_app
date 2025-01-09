package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class enviarmail extends GXProcedure
{
   public enviarmail( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( enviarmail.class ), "" );
   }

   public enviarmail( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 )
   {
      enviarmail.this.AV8SecUserName = aP0;
      enviarmail.this.AV9SecUserPerName = aP1;
      enviarmail.this.AV10Subject = aP2;
      enviarmail.this.AV11Texto = aP3;
      enviarmail.this.AV13html = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&SecUserName ", "")+AV8SecUserName) ;
      AV16MailRecipient.setAddress( AV8SecUserName );
      AV16MailRecipient.setName( AV9SecUserPerName );
      AV14MailMessage.getTo().removeAllItems();
      AV14MailMessage.getTo().add(AV16MailRecipient);
      AV14MailMessage.setSubject( AV10Subject );
      if ( ! AV13html )
      {
         AV14MailMessage.setText( AV11Texto );
      }
      else
      {
         AV14MailMessage.setHtmltext( AV11Texto );
      }
      AV15SMTPSession.setHost( httpContext.getMessage( "smtp.gmail.com", "") );
      AV15SMTPSession.setPort( 465 );
      AV15SMTPSession.getSender().setName( httpContext.getMessage( "A3L", "") );
      AV15SMTPSession.getSender().setAddress( httpContext.getMessage( "a3lfreelance@gmail.com", "") );
      AV15SMTPSession.setAuthentication( (short)(1) );
      AV15SMTPSession.setSecure( (short)(1) );
      AV15SMTPSession.setUserName( httpContext.getMessage( "a3lfreelance@gmail.com", "") );
      AV15SMTPSession.setPassword( httpContext.getMessage( "mzybkknjkvqxjhhb", "") );
      AV15SMTPSession.login();
      if ( ! (0==AV15SMTPSession.getErrCode()) )
      {
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "Error Login ", "")+GXutil.str( AV15SMTPSession.getErrCode(), 10, 0)+" "+AV15SMTPSession.getErrDescription()) ;
      }
      AV15SMTPSession.send(AV14MailMessage);
      if ( ! (0==AV15SMTPSession.getErrCode()) )
      {
         new web.msgdebug(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "Error Envío ", "")+GXutil.str( AV15SMTPSession.getErrCode(), 10, 0)+" "+AV15SMTPSession.getErrDescription()) ;
      }
      AV15SMTPSession.logout();
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      AV16MailRecipient = new com.genexus.internet.MailRecipient();
      AV14MailMessage = new com.genexus.internet.GXMailMessage();
      AV15SMTPSession = new com.genexus.internet.GXSMTPSession();
      AV19Pgmname = "EnviarMail" ;
      /* GeneXus formulas. */
      AV19Pgmname = "EnviarMail" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV19Pgmname ;
   private boolean AV13html ;
   private String AV8SecUserName ;
   private String AV9SecUserPerName ;
   private String AV10Subject ;
   private String AV11Texto ;
   private com.genexus.internet.MailRecipient AV16MailRecipient ;
   private com.genexus.internet.GXSMTPSession AV15SMTPSession ;
   private com.genexus.internet.GXMailMessage AV14MailMessage ;
}

