package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearcarpetaupload extends GXProcedure
{
   public crearcarpetaupload( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearcarpetaupload.class ), "" );
   }

   public crearcarpetaupload( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      crearcarpetaupload.this.AV12CliCod = aP0;
      crearcarpetaupload.this.AV11EmpCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10rutaUploadsCliente ;
      GXv_char2[0] = "" ;
      new web.devuelverutauploadsleg(remoteHandle, context).execute( AV12CliCod, AV11EmpCod, 0, GXv_char1, GXv_char2) ;
      crearcarpetaupload.this.AV10rutaUploadsCliente = GXv_char1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&rutaUploadsCliente ", "")+AV10rutaUploadsCliente) ;
      AV9Directory.setSource( AV10rutaUploadsCliente );
      AV9Directory.create();
      if ( AV9Directory.getErrCode() != 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "err creadir ", "")+GXutil.trim( AV9Directory.getErrDescription())) ;
      }
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
      AV10rutaUploadsCliente = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV15Pgmname = "" ;
      AV9Directory = new com.genexus.util.GXDirectory();
      AV15Pgmname = "crearCarpetaUpload" ;
      /* GeneXus formulas. */
      AV15Pgmname = "crearCarpetaUpload" ;
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String AV15Pgmname ;
   private String AV10rutaUploadsCliente ;
   private com.genexus.util.GXDirectory AV9Directory ;
}

