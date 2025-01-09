package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class adownload_impl extends GXWebProcedure
{
   public adownload_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "contenttype") ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( ! entryPointCalled )
      {
         AV9contenttype = gxfirstwebparm ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV10filename = httpContext.GetPar( "filename") ;
            AV11filepath = httpContext.GetPar( "filepath") ;
         }
      }
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV8HttpResponse.addHeader("Content-Type", AV9contenttype);
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         AV8HttpResponse.addHeader("Content-Disposition", "attachment;filename="+AV10filename);
      }
      AV8HttpResponse.addFile(AV11filepath);
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      AV9contenttype = "" ;
      AV10filename = "" ;
      AV11filepath = "" ;
      AV8HttpResponse = httpContext.getHttpResponse();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short Gx_err ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private String AV9contenttype ;
   private String AV10filename ;
   private String AV11filepath ;
   private com.genexus.internet.HttpResponse AV8HttpResponse ;
}

