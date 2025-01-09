package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class localidadesdesdearchivo extends GXProcedure
{
   public localidadesdesdearchivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidadesdesdearchivo.class ), "" );
   }

   public localidadesdesdearchivo( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.Sdtlocalidades_sdt executeUdp( )
   {
      localidadesdesdearchivo.this.aP0 = new web.Sdtlocalidades_sdt[] {new web.Sdtlocalidades_sdt()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( web.Sdtlocalidades_sdt[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( web.Sdtlocalidades_sdt[] aP0 )
   {
      localidadesdesdearchivo.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12rutaAplicacion ;
      GXv_char2[0] = GXt_char1 ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char2) ;
      localidadesdesdearchivo.this.GXt_char1 = GXv_char2[0] ;
      AV12rutaAplicacion = GXt_char1 ;
      AV12rutaAplicacion += httpContext.getMessage( "/static/jsons_ini/localidades.json", "") ;
      AV8File.setSource( GXutil.trim( AV12rutaAplicacion) );
      if ( AV8File.exists() )
      {
         AV8File.openRead("");
         while ( ! AV8File.getEof() )
         {
            AV9json += AV8File.readLine() ;
         }
         AV8File.close();
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "No existe archivo ", "")+GXutil.trim( AV12rutaAplicacion)) ;
      }
      AV11localidades_sdt.fromJSonString(AV9json, null);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = localidadesdesdearchivo.this.AV11localidades_sdt;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11localidades_sdt = new web.Sdtlocalidades_sdt(remoteHandle, context);
      AV12rutaAplicacion = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV8File = new com.genexus.util.GXFile();
      AV9json = "" ;
      AV15Pgmname = "" ;
      AV15Pgmname = "localidadesDesdeArchivo" ;
      /* GeneXus formulas. */
      AV15Pgmname = "localidadesDesdeArchivo" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV15Pgmname ;
   private String AV9json ;
   private String AV12rutaAplicacion ;
   private com.genexus.util.GXFile AV8File ;
   private web.Sdtlocalidades_sdt[] aP0 ;
   private web.Sdtlocalidades_sdt AV11localidades_sdt ;
}

