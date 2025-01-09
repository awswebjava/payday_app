package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class alert extends GXProcedure
{
   public alert( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( alert.class ), "" );
   }

   public alert( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      alert.this.AV8DVMessageType = aP0;
      alert.this.AV10Mensaje = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV8DVMessageType, "error") == 0 )
      {
         AV9Titulo = httpContext.getMessage( "Error", "") ;
      }
      else if ( GXutil.strcmp(AV8DVMessageType, "info") == 0 )
      {
         AV9Titulo = httpContext.getMessage( "Información", "") ;
      }
      else if ( GXutil.strcmp(AV8DVMessageType, "nospecify") == 0 )
      {
         AV9Titulo = "" ;
      }
      else if ( GXutil.strcmp(AV8DVMessageType, "notice") == 0 )
      {
         AV9Titulo = httpContext.getMessage( "Atención!", "") ;
      }
      else if ( GXutil.strcmp(AV8DVMessageType, "success") == 0 )
      {
         AV9Titulo = httpContext.getMessage( "Los Cambios fueron guardados Exitosamente!", "") ;
      }
      httpContext.GX_msglist.addItem(new web.wwpbaseobjects.dvmessagegetbasicnotificationmsg(remoteHandle, context).executeUdp( AV9Titulo, AV10Mensaje, AV8DVMessageType, "", "true", ""));
      new web.msgdebug(remoteHandle, context).execute( AV13Pgmname, AV10Mensaje) ;
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
      AV9Titulo = "" ;
      AV13Pgmname = "" ;
      AV13Pgmname = "alert" ;
      /* GeneXus formulas. */
      AV13Pgmname = "alert" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8DVMessageType ;
   private String AV10Mensaje ;
   private String AV9Titulo ;
   private String AV13Pgmname ;
}

